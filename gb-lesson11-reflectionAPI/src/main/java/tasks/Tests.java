package tasks;

public class Tests {
@Test(priority = 6)
    void test1(){
    System.out.println("test1 is starting with priority 6");
    }
    @Test(priority = 3)
    void test2(){
        System.out.println("test2 is starting with priority 3");
    }
    @Test(priority = 8)
    void test3(){
        System.out.println("test3 is starting with priority 8");
    }

    @BeforeSuite
    void before(){
        System.out.println("BeforeSuite is starting");
    }
//    @BeforeSuite
//    void before2(){
//        System.out.println("before2 ");
//    }

    @AfterSuite
    void after(){
        System.out.println("AfterSuite is starting");
    }
//    @AfterSuite
//    void after2(){
//        System.out.println("after2");
//    }
}
