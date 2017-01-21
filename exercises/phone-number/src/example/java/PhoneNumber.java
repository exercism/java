public class PhoneNumber {

    private final String number;

    public PhoneNumber(String phoneNumber) {
        number = normalize(extractDigits(phoneNumber));
    }

    private String extractDigits(String dirtyNumber) {
        return dirtyNumber.replaceAll("[^\\d]", "");
    }

    private String normalize(String number) {
        if(number.length() > 11 || number.length() < 10){
            throw new IllegalArgumentException("Number must be 10 or 11 digits");
        }

        if(number.length() == 11){
            if(number.startsWith("1")){
                number = number.substring(1, number.length());
            }
            else{
                throw new IllegalArgumentException("Can only have 11 digits if number starts with '1'");
            }
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
