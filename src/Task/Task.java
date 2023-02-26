package Task;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Task {
    private static int idGenerator=1;
    private final String title;
    private final Type type;
    private final int id;
    private final LocalDateTime dateTime;
    private final String description;

    private  LocalDateTime dateLead;


    public Task(String title, Type type, int id, LocalDateTime dateTime,
                String description, LocalDateTime dateLead) {
        this.title = title;
        this.type = type;
        this.id = idGenerator++;
        this.dateTime = LocalDateTime.now();
        this.description = description;
        this.dateLead = dateLead;
    }

    public static int getIdGenerator() {
        return idGenerator;
    }

    public static void setIdGenerator(int idGenerator) {
        Task.idGenerator = idGenerator;
    }

    public String getTitle() {
        return title;
    }

    public Type getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDateLead() {
        return dateLead;
    }

    public void setDateLead(LocalDateTime dateLead) {
        this.dateLead = dateLead;
    }


    public boolean appearsIn(LocalDate date) {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(title, task.title) && Objects.equals(type, task.type) && Objects.equals(dateTime, task.dateTime) && Objects.equals(description, task.description) && Objects.equals(dateLead, task.dateLead);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, id, dateTime, description, dateLead);
    }

    @Override
    public String toString() {
        return getId() + " - " + getTitle() + ".\n " + getDescription() + ".\n "
                + getType() + ".\n Периодичность повторения задачи " + ".\n Дата первого выполнения "
                + getDateLead();
    }
}
