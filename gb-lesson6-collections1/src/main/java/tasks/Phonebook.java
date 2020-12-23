package tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
/*
2	Написать простой класс Телефонный Справочник, который хранит в себе список фамилий
 и телефонных номеров. В этот телефонный справочник с помощью метода add() можно добавлять
  записи, а с помощью метода get() искать номер телефона по фамилии.
 */
public class Phonebook {
    Map<String,String> phoneNumbers=new HashMap<>();

    public void add(String number,String name){
        phoneNumbers.put(number,name);
    }

    public Map<String,String> get(String name){
        return phoneNumbers.entrySet().stream().
                filter(e->e.getValue().equals(name)).
                collect(Collectors.toMap(entry->entry.getKey(), entry->entry.getValue()));
    }
}
