import java.sql.*;

public class Main1 {

    public static void main(String[] args) {
        try {
            connect();
            //insertEx();
            // updateEx();
            // deleteEx();
            //  clearTableEx();
            //  readEx();
            //  createTableEx();
            dropTableEx();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    //1) для подключения к базе нам понадобится
    private static Connection connection;//1-1)объект типа connection, то есть это само по себе подключение
    private static Statement stmt;//1-2)для отправки запросов понадобится stmt, тип данных которое позволяет
    // отправлять запросы в базу и получать оттуда какие то ответы

    //2)для подключения нужно некие операции
    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");//2-1) у нас есть некий класс org.sqlite.JDBS
        // и его необходимо загрузить в память
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        //2-2) создаем новый объект connection через DriverManager, все объекты для подключения
        // jdbc создаются через методы а не через new. "jdbc:sqlite:main.db" путь к БД
        stmt = connection.createStatement();//2-3)для отправки запросов
    }

    public static void insertEx() throws SQLException {//4) добавление в таблицу
        stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob4', 60);");
        //4-1) метод executeUpdate интовый, показывает сколько записей мы меняли
        //добавляется Bob4 60
    }

    public static void updateEx() throws SQLException {//5)изменение данных
        System.out.println(stmt.executeUpdate("UPDATE students SET score = 100 WHERE name = 'Bob4';"));

    }
    public static void deleteEx() throws SQLException {//6)удаление объекта при условии
        System.out.println(stmt.executeUpdate("Delete from students WHERE name = 'Bob1';"));
        //sout: 0, потому что Bob1 нет в таблице
    }

    public static void clearTableEx() throws SQLException {//7)очистим все записи из таблицы
        stmt.executeUpdate("DELETE FROM students;");
    }

    //8) сейчас посмотрим чтение
    public static void readEx() throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT * FROM students Where id>1;");
        //8-1)ResultSet -это табличка с ответом, то есть в ResultSet прилетает матрица

        //9) получив ResultSet можем узнать метаданные таблицы(название, тип, количество... столбцов)
        ResultSetMetaData rsmd = rs.getMetaData();
        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            System.out.println(rsmd.getColumnName(i));
        }

        while (rs.next()){//8-2) как из rs читать данные?
            System.out.println(rs.getInt(1) + " " + rs.getString("name")
                    + " " + rs.getInt(3));//8-3) 1 индекс(номер столбца), name или 2(индекс), 3-индекс
        }//8-4) sout: 2 Bob2 80      3 Bob3 90


    }



    //3) после открытия соединения нужно закрыть методом disconnect(),
// самый важный элемент закрывается в конце и так по порядку
    public static void disconnect(){
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    //10)посмотрим создание таблицы
    private static void createTableEx() throws SQLException {
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS animalsGB (\n" +
                "        id    INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "        name  TEXT,\n" +
                "        score INTEGER\n" +
                "    );");
    }

    private static void dropTableEx() throws SQLException {
        stmt.executeUpdate("DROP TABLE IF EXISTS animalGB;");
    }//11)сбросить таблицу (удалить)

}

