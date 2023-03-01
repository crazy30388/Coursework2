import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task{
    public YearlyTask(String title, Type type, int id,
                      LocalDateTime dateTime, String description, LocalDateTime dateLead) {
        super(title, type, id, dateTime, description, dateLead);
    }
    @Override
    public boolean appearsIn(LocalDate date){
        return getDateLead().toLocalDate().getDayOfYear() == date.getDayOfYear();
    }
}
