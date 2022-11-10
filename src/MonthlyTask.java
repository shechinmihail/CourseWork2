import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task {
    public MonthlyTask(String header, String description, ListTask listTask, LocalDateTime localDateTime) {
        super(header, description, listTask, localDateTime);
    }

    @Override
    public boolean nextDateAndTime(LocalDate enteredDate) {
        var firstOfDate = getDateTime().toLocalDate();
        while (!firstOfDate.isAfter(enteredDate)) {
            if (firstOfDate.equals(enteredDate)) {
                return true;
            }
            firstOfDate = firstOfDate.plusMonths(1);
        }
        return false;
    }
}
