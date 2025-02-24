import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DialingCodes {

    private final Map<Integer, String> countryByDialingCode = new HashMap<>();

    public Map<Integer, String> getCodes() {
        return Map.copyOf(countryByDialingCode);
    }

    public void setDialingCode(Integer code, String country) {
        countryByDialingCode.put(code, country);
    }

    public String getCountry(Integer code) {
        return countryByDialingCode.get(code);
    }

    public void addNewDialingCode(Integer code, String country) {
        if (!countryByDialingCode.containsValue(country)) {
            countryByDialingCode.putIfAbsent(code, country);
        }
    }

    public Integer findDialingCode(String country) {
        for (Map.Entry<Integer, String> entry : countryByDialingCode.entrySet()) {
            if (Objects.equals(entry.getValue(), country)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void updateCountryDialingCode(Integer code, String country) {
        Integer existingCode = findDialingCode(country);
        if (existingCode != null) {
            countryByDialingCode.remove(existingCode);
            countryByDialingCode.put(code, country);
        }
    }
}
