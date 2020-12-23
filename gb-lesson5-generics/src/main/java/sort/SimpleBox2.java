package sort;

public class SimpleBox2 implements Comparable<SimpleBox2>{
   //СМОТРЕТЬ SimpleBox
    private int size;

    public SimpleBox2(int size) {

        this.size = size;
    }
    public void info(){
        System.out.println("Box: " + size);
    }

    @Override
    public String toString() {
        return String.format("SimpleBox2: %d", size);
        //return "SimpleBox2: " + size;
    }

    @Override
    public int compareTo(SimpleBox2 o) {
       return this.size - o.size;
    }
    // Все! мы объяснили как java должен сравнить наши коробки
}
