import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class BafflingBirthdays {
    private static final int nonLeapYear = 2001;
    private static final int daysInYear = 365;

    boolean sharedBirthday(List<String> birthdates) {
        Set<String> seen = new HashSet<>();
        for (String birthdate : birthdates) {
            String monthDay = birthdate.substring(5);
            if (!seen.add(monthDay)) {
                return true;
            }
        }
        return false;
    }
    
    List<String> randomBirthdates(int groupSize) {
        if (groupSize <= 0) {
            return List.of();
        }
        List<String> birthdates = new ArrayList<>(groupSize);
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < groupSize; i++) {
            int dayOfYear = random.nextInt(1, daysInYear + 1);
            LocalDate date = LocalDate.ofYearDay(nonLeapYear, dayOfYear);
            birthdates.add(date.toString());
        }
        return birthdates;
    }

    double estimatedProbabilityOfSharedBirthday(int groupSize) {
        if (groupSize <= 1) {
            return 0.0;
        }
        if (groupSize > daysInYear) {
            return 100.0;
        }
        double probabilityNoSharedBirthday = 1.0;
        for (int k = 0; k < groupSize; k++) {
            probabilityNoSharedBirthday *= (daysInYear - k) / (double) daysInYear;
        }
        return (1 - probabilityNoSharedBirthday) * 100.0;
    }
}
