public class PhoneNumber {

    private final String number;

    public PhoneNumber(String phoneNumber) {
        number = normalize(extractDigits(phoneNumber));
    }

    private String extractDigits(String dirtyNumber) {
        return dirtyNumber.replaceAll("[^\\d]", "");
    }

    private String normalize(String number) {
        if(number.length() == 11 && number.startsWith("1")) {
            number = number.substring(1, number.length());
        }

        final boolean numberIsValid = (number.length() == 10);

        if(!numberIsValid) {
            throw new IllegalArgumentException();
        }
        
        return number;
    }

    public String getNumber() {
        return number;
    }

    public String getAreaCode() {
        return number.substring(0, 3);
    }

    public String getExchangeCode() {
        return number.substring(3, 6);
    }

    public String getSubscriberNumber() {
        return number.substring(6, 10);
    }

    public String pretty() {
        return "(" + getAreaCode() + ") " + getExchangeCode() + "-" + getSubscriberNumber();
    }

}
