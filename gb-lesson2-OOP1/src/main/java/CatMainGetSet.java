public class CatMainGetSet {
    public static void main(String[] args) {
        CatGetSet cat = new CatGetSet("Barsik", "Red", 5);
        System.out.println(cat.getName());
        cat.setName("Murzik");
        System.out.println(cat.getName());
    }
}
