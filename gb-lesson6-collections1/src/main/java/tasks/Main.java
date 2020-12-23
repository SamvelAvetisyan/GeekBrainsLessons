package tasks;

public class Main {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.add("1","Petrov");
        phonebook.add("2","Ivanov");
        phonebook.add("3","Smirnov");
        phonebook.add("4","Petrov");
        phonebook.add("5","Sidorov");
       phonebook.get("Ivanov");
    }

}
