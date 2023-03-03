import java.time.LocalDate;
import java.util.*;

public class TaskService {
    private final Map<Integer, Task> taskMap;

    public TaskService() {
        taskMap = new HashMap<>();
    }

    public void add(Task task) throws IncorrectArgumentException {
        if (task.getTitle() == null || task.getDescription() == null) {
            throw new IncorrectArgumentException("Неккоректно введены данные задачи");
        }
        taskMap.put(task.getId(), task);
    }

    public Task remove(int id) throws TaskNotFoundException {
        Task task = taskMap.remove(id);
        if (task == null) {
            throw new TaskNotFoundException("В списке нет задачис таким id");
        }
        return task;
    }

    public Collection<Task> getAllByDate(LocalDate date) {
        ArrayList<Task> list = new ArrayList<>();
        for (int i = 1; i < taskMap.size() + 1; i++) {
            if (taskMap.get(i).appearsIn(date)) {
                list.add(taskMap.get(i));
            }
        }
        if (list.isEmpty()) {
            System.out.println("На сегодня у вас нет задач");
        }
        return list;
    }
}
