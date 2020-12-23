package tasks;

public class Tasks1 {
    public static void main(String[] args) {

    }

    //Task 1
    public static boolean method1(int a, int b) {
        return a + b > 10 && a + b <= 20;
    }

    //Task 2
    public static void method2(int a) {
        if (a < 0) {
            System.out.println(a + " отрицательное");
        } else {
            System.out.println(a + " положительное");
        }
    }

    //Task 3
    public static boolean isNegative(int a) {
        return (a < 0);
    }

    //Task 4
    public static void printName(String name) {
        System.out.println("Привет " + name);
    }

    //Task 5
    public static int[] zeroAndOne() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else if (arr[i] == 0) {
                arr[i] = 1;
            }
        }
        return arr;
    }

    //Task 6
    public static int[] fillArray() {
        int[] arr = new int[8];
        int[] arr2 = {2, 5, 8, 11, 14, 17, 20, 23};
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr2[i];
        }
        return arr;
    }

    //Task 7
    public static int[] sixMultiplyTwo() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        return arr;
    }

    //Task 8
    public static int[][] matrix() {
        int[][] matrix = new int[5][5];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j) {
                    matrix[i][j] = 1;
                }
            }
        }
        return matrix;
    }

    //Task 9
    public static void minMaxArray(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
    }

    //Task 10
    public static void year(int n) {
        if (n % 400 == 0) {
            System.out.println(n + "-ий год является високосным");
        } else if (n % 100 == 0) {
            System.out.println(n + "-ий год не является високосным");
        } else if (n % 4 == 0) {
            System.out.println(n + "-ий год является високосным");
        }
    }

    //Task 11
    public static boolean checkBalanceArray(int[] arr) {
        int sumLeft = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum%2 != 0) {
            return false;
        }
        for(int i = 0; i<arr.length; i++){
        sumLeft += arr[i];
        if(sum == sumLeft*2)
            return true;
        } return false;
    }

}