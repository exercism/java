class Leap {

    /**
     * Determines if the given `year` is a leap year or not
     *
     * @return true if `year` is leap year else false
     */
    static boolean leapYear(int year) {
        boolean isLeapYear = false;
        if(year % 4 == 0 && year % 100 == 0 && year % 400 == 0)
        {
            isLeapYear = true;
        }
        else if (year % 4 == 0 && year % 100 != 0)
        {
            isLeapYear = true;
        }
        return isLeapYear;
    }

}