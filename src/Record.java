import java.util.Date;

/**
 * Created by svetlanashmalko on 21.08.16.
 */
public class Record {

    Long number;
    String name;
    Date date;

    public Record(Long number, String name, Date date) {
        this.number = number;
        this.name = name;
        this.date = date;
    }

    public Long getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }


}
