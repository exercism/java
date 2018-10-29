import static java.lang.Math.pow;

class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {

        int number = numberToCheck;
        int calculation = 0;
        int length = String.valueOf(number).length();

        while (number > 0) {
            calculation += pow((number % 10), length);
            number = number / 10;
        }
        return numberToCheck == calculation;
    }
}
