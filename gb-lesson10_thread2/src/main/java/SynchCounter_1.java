public class SynchCounter_1 {
    public int c;

    public int value() {
        return c;
    }//getter

    public SynchCounter_1() {
        c = 0;
    }

    public synchronized void inc() {
        c++;
    }

    public synchronized void dec() {
        c--;
    }
    //1) здесь сказали что наши методы синхронизированы,
// то есть мы у одного и того же счетчика(SynchCounter) не можем одновременно
//вызвать 2 метода (dec и inc), пока кто то уменьшает никто не может увеличивать
//и наоборот
//2)то есть проблема гонки решаем с помощью синхронизации


}

