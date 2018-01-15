import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import static java.lang.Integer.parseInt;

public class SkipassDaily implements Skipass{
    private int days;
    private int code;
    private Week w;
    private String date;
    private boolean blocked = false;

    @Override
    public void setBlock() {
        blocked = true;
    }

    @Override
    public boolean getBlock() {
        return blocked;
    }

    public SkipassDaily(DaysCounter days, Week w, int code){
        this.days = parseInt(days.toString());
        this.code = code;
        this.w = w;
    }

    @Override
    public void useSkipass() {
        if(!active() && days > 0 && inTime()){
            days--;
            date = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        }
    }

    @Override
    public String left() {
        if(days > 0) {
            return days + "  more days left";
        }
        else if(active()){
            return "Last day in use";
        }
        return "Out of limit";
    }

    @Override
    public boolean isValid() {
        return (days > 0 || active()) && inTime() && !getBlock();
    }

    @Override
    public String getType() {
        return w.toString() + "/" + SkipassType.DAYS;
    }

    @Override
    public boolean inTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        return (calendar.get(Calendar.DAY_OF_WEEK) < 6 && 0 < calendar.get(Calendar.DAY_OF_WEEK) && w == Week.WEEKDAY) ||
                (calendar.get(Calendar.DAY_OF_WEEK) < 8 && 5 < calendar.get(Calendar.DAY_OF_WEEK) && w == Week.WEEKEND);
    }

    @Override
    public int getCode() {
        return code;
    }

    private boolean active(){
        return Objects.equals(date, new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
    }

}
