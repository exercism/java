class Leap {

    boolean isLeapYear(int year) {
        boolean isLeapYear = false;
        if (year % 4 == 0 && year % 100 == 0 && year % 400 == 0) {
            isLeapYear = true;
        } else if (year % 4 == 0 && year % 100 != 0) {
            isLeapYear = true;
        }
        return isLeapYear;
    }

}
