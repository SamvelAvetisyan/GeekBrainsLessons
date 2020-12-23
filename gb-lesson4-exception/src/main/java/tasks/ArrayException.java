package tasks;
/*
1	Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2	Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
3	В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException и вывести результат расчета.

 */

public class ArrayException {
    public static int sumMatrix(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4 || arr.length != 4) {
                throw new MyArraySizeException("неправильно задан размер массива");
            }
        }
        int[][] arrInt = new int[4][4];

        int sum = 0;
        for (int i = 0; i < arrInt.length; i++) {
            for (int j = 0; j < arrInt[i].length; j++) {
                try {
                    arrInt[i][j] = Integer.parseInt(arr[i][j]);
                    sum += arrInt[i][j];
                } catch (NumberFormatException | NullPointerException e) {
                    throw new MyArrayDataException("в этом ячейке лежит не число "
                            + String.format("%d %d", i, j));
                }
            }
        }
        // System.out.println(Arrays.deepToString(arrInt));
        // System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {
        String[][] massiv = new String[][]{{"1", "2", "3", "4"},
                {"10", "20", "30", "40"},
                {"100", "200", "300", "400"},
                {"1000", "2000", "3000", "4000"}};
        try {
            System.out.println(sumMatrix(massiv));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
