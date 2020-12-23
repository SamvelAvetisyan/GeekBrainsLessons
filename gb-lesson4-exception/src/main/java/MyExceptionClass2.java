public class MyExceptionClass2 extends RuntimeException {
    private int length;//1)мы здесь можем добавить поле,

    public int getLength() {
        return length;
    }

    public MyExceptionClass2(String message, int length) {
        super(message);
        this.length = length;
    }//2) к message подшить длину
}
