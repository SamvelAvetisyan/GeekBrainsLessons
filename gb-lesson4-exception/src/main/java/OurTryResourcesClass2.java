public class OurTryResourcesClass2 implements AutoCloseable {
    //напишем свой класс который будет обрабатывать свой try с ресурсами.

    @Override
    public void close() throws Exception {
        System.out.println("Мои ресурсы закрыты!");//напишем что произойдет при закрытии
        //(например напечатать сообщение);
    }

    public static void main(String[] args) {
        try(OurTryResourcesClass2 obj = new OurTryResourcesClass2()) {

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
