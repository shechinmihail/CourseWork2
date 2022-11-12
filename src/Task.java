import java.time.LocalDate;
import java.time.LocalDateTime;

public class Task implements Repeat {

    private int id;
    private String header;
    private String description;
    private ListTask listTask;
    private LocalDateTime dateTime;

    private static int idGenerator = 1;

    public Task(String header, String description, ListTask listTask, LocalDateTime localDateTime) {
        this.id = idGenerator++;
        this.header = header;
        this.description = description;
        this.listTask = listTask;
        this.dateTime = localDateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ListTask getListTask() {
        return listTask;
    }

    public void setListTask(ListTask listTask) {
        this.listTask = listTask;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setLocalDateTime(LocalDate date) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean nextDateAndTime(LocalDate enteredDate) {
        return enteredDate.isEqual(getDateTime().toLocalDate());
    }

    @Override
    public String toString() {
        return "Задача " +
                "id " + id +
                ", Наименование '" + header + '\'' +
                ", Описание '" + description + '\'' +
                ", Тип " + listTask +
                ", Дата " + dateTime +
                '}';
    }
}
