import java.sql.*;

public class Main2 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        connect();
        //fillTableByStatement();
        //   prepareStatements();
        //   addDataPreparedStatementEx();
        rollbackEx();
    }

    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement psInsert;//параметризованный запрос

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        stmt = connection.createStatement();
    }

    //1) хотим решить задачу, добавить 1000 студентов в таблицу
    private static void fillTableByStatement() throws SQLException {
        long time = System.currentTimeMillis();
        connection.setAutoCommit(false);//1-1)мы выключили setAutoCommit поставили false(открыли транзакцию)
        for (int i = 0; i < 1000; i++) {
            stmt.executeUpdate(String.format("INSERT INTO students (name, score) VALUES ('%s', %d);",
                    "Bob" + (i + 1), 10 + i * 10 % 100));
        }
        connection.setAutoCommit(true);//1-1)мы включили setAutoCommit и
        // добавление 1000 элементов происходит в период 1 транзакции, БЫСТРЕЕ!
        System.out.println("time: " + (System.currentTimeMillis() - time));
    }

    public static void prepareStatements() throws SQLException {
        psInsert = connection.prepareStatement("INSERT INTO students (name, score) VALUES (?,?);");
    }//2) создали  (psInsert)

    //2-1)напишем метод чтобы заполнить таблицу
    public static void addDataPreparedStatementEx() throws SQLException {
        for (int i = 1; i <= 10; i++) {
            psInsert.setString(1, "Bob" + i);
            psInsert.setInt(2, i * 10);
            psInsert.executeUpdate();
        }
    }

    //3) с автокомитом PreparedStatement
    private static void transaction() throws SQLException {
        long t = System.currentTimeMillis();
        connection.setAutoCommit(false);
        for (int i = 1; i <= 1000; i++) {
            psInsert.setString(1, "Bob" + i);
            psInsert.setInt(2, i * 10 % 100);
            psInsert.executeUpdate();
        }
        connection.setAutoCommit(true);
        System.out.println("time: " + (System.currentTimeMillis() - t));
    }

    //4) упакуем запрос
    private static void psBatchEx() {
        try (PreparedStatement prepInsert = connection.prepareStatement(
                "INSERT INTO students (name, score) VALUES (?, ?)")) {
            connection.setAutoCommit(false);
            for (int i = 1; i <= 1000; i++) {
                prepInsert.setString(1, "Bob" + i);
                prepInsert.setInt(2, i * 10 % 100);
                prepInsert.addBatch();//4-1)добавляем в пакет, по каждой итерации
                //и формируется пакет запросов
            }
            int[] result = prepInsert.executeBatch();//4-2) здесь разом этот пакет выполняем
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //5)при выполнении каких то операции можем поставить контрольные точки(Savepoint), и если надо
    //откатятся к этой точке
    private static void rollbackEx() throws SQLException {
        // autoCommit = true
        stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob1', 10);");
        Savepoint sp1 = connection.setSavepoint(); // 5-1) setSavepoint() автоматически отключает autoCommit
        // autoCommit = false
        stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob2', 20);");//5-2) здесь
        //добавляется Bob2, 20
        connection.rollback(sp1);//5-3)rollback это откат, и он отменяет все изменения которые
        // были сделаны после Savepoint sp1, здесь исчезает Bob2, 20
        stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob3', 30);");
        connection.setAutoCommit(true);//5-4) здесь вручную включаем AutoCommit
        // и добавится в таблицу'Bob3', 30
        //5-5) в итоге добавится в таблицу,'Bob1', 10 и 'Bob3', 30
    }

    public static void disconnect() {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (psInsert != null) {
            try {
                psInsert.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}

