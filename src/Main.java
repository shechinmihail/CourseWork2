import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    private static ProcessingTask processingTask = new ProcessingTask();

    public static void main(String[] args) {
        //ProcessingTask processingTask = new ProcessingTask();
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner);
                            break;
                        case 2:
                            delete(processingTask, scanner);
                            break;
                        case 3:
                            getAllByDate(processingTask, scanner);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static void inputTask(Scanner scanner) {
        System.out.print("Введите название задачи: ");
        String header = scanner.next();
        scanner.nextLine();
        System.out.println("Введите описание задачи: ");
        String description = scanner.nextLine();
        System.out.println("Введите дату в формате dd.mm.yyyy: ");
        String date = scanner.nextLine();
        LocalDate taskDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        System.out.println("Введите время оповещения в формате hh:mm ");
        String time = scanner.nextLine();
        LocalTime taskTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
        LocalDateTime result = LocalDateTime.of(taskDate, taskTime);
        System.out.println("Введите тип задачи: Личная(1) или Рабочая(2) ");
        int listTask = scanner.nextInt();
        ListTask typeTask = listTask == 1 ? ListTask.PERSONALTASK : ListTask.WORKTASK;

        System.out.println("Введите повторяемость задачи:");
        System.out.println(" 0-однократная");
        System.out.println(" 1-ежедневная");
        System.out.println(" 2-еженедельная");
        System.out.println(" 3-ежемесячная");
        System.out.println(" 4-ежегодная");
        int type = scanner.nextInt();
        switch (type) {
            case 0:
                processingTask.inputTask(new Task(header, description, typeTask, result));
                break;
            case 1:
                processingTask.inputTask(new DailyTask(header, description, typeTask, result));
                break;
            case 2:
                processingTask.inputTask(new WeeklyTask(header, description, typeTask, result));
                break;
            case 3:
                processingTask.inputTask(new MonthlyTask(header, description, typeTask, result));
                break;
            case 4:
                processingTask.inputTask(new AnnualTask(header, description, typeTask, result));
                break;
            default:
                throw new RuntimeException("Нет такой задачи! ");
        }

    }

    private static void delete(ProcessingTask processingTask, Scanner scanner) {
        System.out.println("Введите id задачи, которую нужно удалить: ");
        int id = scanner.nextInt();
        processingTask.delete(id);
    }

    private static void getAllByDate(ProcessingTask processingTask, Scanner scanner) {
        System.out.println("Введите дату в формате dd.mm.yyyy: ");
        scanner.nextLine();
        String date = scanner.nextLine();
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        var allTask = processingTask.getAllByDate(localDate);
        System.out.println("Список задач на этот день ");
        for (Task task: allTask){
            System.out.println(task);
        }
    }


    private static void printMenu() {
        System.out.println(
                """
                        1. Добавить задачу
                        2. Удалить задачу
                        3. Получить задачу на указанный день
                        0. Выход
                        """
        );
    }
}