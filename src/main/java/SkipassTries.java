import java.util.Calendar;
import java.util.Date;

import static java.lang.Integer.parseInt;

public class SkipassTries implements Skipass{
    private int tries;
    private int code;
    private Week w;
    private boolean blocked = false;

    @Override
    public void setBlock() {
        blocked = true;
    }

    @Override
    public boolean getBlock() {
        return blocked;
    }

    public SkipassTries(TriesCounter tries, Week w, int code){
        this.tries = parseInt(tries.toString());
        this.code = code;
        this.w = w;
    }

    @Override
    public String getType() {
        return w.toString() + "/" + SkipassType.TRIES;
    }

    @Override
    public boolean isValid() {
        return tries > 0 && inTime() && !getBlock();
    }

    @Override
    public String left() {
        if (tries > 0) {
            return tries + " rides left";
        }
        return "Out of limit";
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public void useSkipass() {
        if(isValid()) {
            tries--;
        }
    }

    @Override
    public boolean inTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        return (calendar.get(Calendar.DAY_OF_WEEK) < 6 && 0 < calendar.get(Calendar.DAY_OF_WEEK) && w == Week.WEEKDAY) ||
                (calendar.get(Calendar.DAY_OF_WEEK) < 8 && 5 < calendar.get(Calendar.DAY_OF_WEEK) && w == Week.WEEKEND);
    }
}
