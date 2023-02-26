import Task.Task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IncorrectArgumentException {

        TaskService service = new TaskService();
        try (Scanner scanner = new Scanner(System.in)){
            label:
            while (true){
                printMenu();
                System.out.println("Выберите пункт меню: ");
                if(scanner.hasNextInt()){
                    int menu = scanner.nextInt();
                    switch (menu){
                        case 1:
                            Task task;
                            task = createTask(scanner);
                            System.out.println(task);
                            try{
                                service.add(task);
                            }
                            catch (IncorrectArgumentException e)
                            {
                                e.printStackTrace();
                                System.out.println(e);
                            }
                            break;
                        case 2:
                            System.out.println("Введите id задачи для удаления");
                            try{
                                service.remove(scanner.nextInt());
                            }
                            catch (TaskNotFoundException e){
                                e.printStackTrace();
                                System.out.println(e);
                            }
                            break;
                        case 3:
                            System.out.println("Введите дату чтобы посмотреть список задач, вводите дату в формате 00.00.0000");
                            System.out.println(service.getAllByDate(LocalDate.parse(scanner.next(), DateTimeFormatter.ISO_DATE)));
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню в списке");
                }
            }
        }
    }

    private static Task createTask(Scanner scanner) {
        Task o = null;
        return o;
    }

    private static void printMenu() {
    }
}