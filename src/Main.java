import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IncorrectArgumentException {

        TaskService service = new TaskService();
        try (Scanner scanner = new Scanner(System.in)){
            label:
            while (true){
                TaskMenu.printMenu();
                System.out.println("Выберите пункт меню: ");
                if(scanner.hasNextInt()){
                    int menu = scanner.nextInt();
                    switch (menu){
                        case 1:
                            Task task;
                            task = CreateTask.createTask(scanner);
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
                            System.out.println("Введите дату чтобы посмотреть список задач, вводите дату в формате дд.мм.гггг");
                            System.out.println(service.getAllByDate(LocalDate.parse(scanner.next(), DateTimeFormatter.ISO_LOCAL_DATE)));
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
}