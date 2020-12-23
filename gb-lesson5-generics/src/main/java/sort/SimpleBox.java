package sort;

public class SimpleBox implements Comparable {
    private int size;

    public SimpleBox(int size) {

        this.size = size;
    }
    public void info(){
        System.out.println("Box: " + size);
    }
    //5) имплементим compareTo(см. Main)
    //6)логика compareTo- если он вернет положительное число то наша текущая коробка
    //больше, чем который передается как параметр (это)

    @Override
    public int compareTo(Object o) {
      // SimpleBox another =(SimpleBox)o ; //6) во первых, мы должны (o) откастовать до коробки
       return this.size - ((SimpleBox)o).size;
    //7)здесь return вернет >0 если размер нашей коробка будет больше размера который будет
        }
}
