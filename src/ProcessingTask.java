import java.time.LocalDate;
import java.util.*;

public class ProcessingTask {

    private Map<Integer, Task> taskMap = new TreeMap<>();
    private Collection<Task> deleteTask;

    public void inputTask(Task task) {
        taskMap.put(task.getId(), task);
    }

    public void delete(int id) {
        taskMap.remove(id);
    }

    public Collection<Task> getAllByDate(LocalDate enteredDate) {
        List<Task> taskList = new ArrayList<>();
        for (Map.Entry<Integer, Task> integerTaskEntry : taskMap.entrySet()){
            var task = integerTaskEntry.getValue();
            if (task.nextDateAndTime(enteredDate)){
                taskList.add(task);
            }
        }
        return taskList;
    }

}
