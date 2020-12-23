package tasks;
/*
1.	Создайте три аннотации: @DbTable, @DbColumn, @DbId.
- В аннотации @DbTable должен быть параметр name, указывающий на имя таблицы, в которой будут храниться объекты.
- Все поля, отмеченные аннотацией @DbColumn должны быть сохранены в таблицу (имя поля совпадает с именем столбца в таблице).
- Поле, помеченное аннотацией @DbId, должно быть отображено в столбец с именем id, такое поле является обязательным.
2.	Создайте обобщенный класс вида ReflectionRepository<T>, где T - тип класса, объекты которого необходимо сохранять в БД;
3.	ReflectionRepository должен позволять: добавлять объекты в таблицу, удалять объект из таблицы по id, удалить все объекты из
таблицы, получать объект по id, получать все объекты из таблицы;
4.	* После сохранения должен вернуться объект с id, присвоенным базой данных.

 */

import java.sql.SQLException;

public class MainClass {
    public static void main(String[] args) throws IllegalAccessException, SQLException, ClassNotFoundException {
        ReflectionRepository<Book> reflectionRepository = new ReflectionRepository<>(Book.class);
        reflectionRepository.save(new Book("Remark","Three Friends",100));
        reflectionRepository.save(new Book("Artur Konan Doyl","Sherlock Holmes",150));
        reflectionRepository.save(new Book("Raffi","Samvel",200));

        Book book=reflectionRepository.findById(1l);
        System.out.println(book);
       // System.out.println(reflectionRepository.findAll());
    }


}

