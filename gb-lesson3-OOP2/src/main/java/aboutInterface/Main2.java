package aboutInterface;

public class Main2 {
    public static void main(String[] args) {
        //1) Для Transport
       Transport transport = new Car();//2) Здесь можем передать Car Bicycle ...
       CorrectPerson person = new CorrectPerson();


        person.start(transport);//3) будет работать метод класса что передали в 2
        person.stop();
    }
}
