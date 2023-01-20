```java
import java.time.*;

class Leap {

    boolean isLeapYear(int year) {
        return LocalDate.of(year, Month.FEBRUARY, 28).isLeapYear();
    }
}
```
