class Leap {
    private int year;

    Leap(int year) {
        this.year = year;
    }

    boolean isLeapYear() {
        return (this.year % 4 == 0) && (this.year % 100 != 0 || this.year % 400 == 0);
    }

}