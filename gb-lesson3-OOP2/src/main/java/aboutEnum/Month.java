package aboutEnum;

public enum Month {
    //1) когда нужно явно фиксированный набор значений
    //2) Здесь пишется пачка константов
    JANUARY(1),
    FEBRUARY(2),
    MARCH(3),
    APRIL(4),
    MAY(5),
    JUNE(6),
    JULY(7),
    AUGUST(8),
    SEPTEMBER(9),
    OCTOBER(10),
    NOVEMBER(11),
    DECEMBER(12);
    //3) можем заполнять значениями, у Enum тоже есть конструктор и он приватный
        private int index;//4) если нам нужно индексация месяцев

    public int getIndex() {
        return index;
    }

    private Month(int index) {//4-1)
        this.index = index;
    }
}
