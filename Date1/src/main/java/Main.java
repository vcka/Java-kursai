import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        LocalDate birthDay = LocalDate.of(1980, 06, 24);
        LocalDate todaysDay = LocalDate.now();
        System.out.println("Metai: " + ChronoUnit.YEARS.between(birthDay, todaysDay));
        System.out.println("Menesiai: " + ChronoUnit.MONTHS.between(birthDay, todaysDay));
        System.out.println("Dienos: " + ChronoUnit.DAYS.between(birthDay, todaysDay));
        Map<String,String> dates = new HashMap<>();
        for (int i = birthDay.getYear(); i < todaysDay.getYear(); i++) {
            dates.put(i + "-06-24", String.valueOf(LocalDate.parse(i + "-06-24").getDayOfWeek()));
        }
        Map<String, Long> collect = dates.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.counting()));

        System.out.println(collect);
    }
}
