package Task;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task {
    public DailyTask(String title, Type type, int id,
                     LocalDateTime dateTime, String description, LocalDateTime dateLead) {
        super(title, type, id, dateTime, description, dateLead);
    }
    @Override
    public boolean appearsIn(LocalDate date){
        return true;
    }
}
