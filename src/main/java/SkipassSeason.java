import java.text.SimpleDateFormat;
import java.util.Date;
import static java.lang.Integer.parseInt;

public class SkipassSeason extends SkipassDaily{
    private int year = parseInt(new SimpleDateFormat("yyyy").format(new Date()));
    private int mon = parseInt(new SimpleDateFormat("MM").format(new Date()));
    public SkipassSeason(int code){
        super(DaysCounter.UNLIM, Week.WEEKEND, code);
    }

    @Override
    public boolean isValid() {
        return inTime() && isSeason() && !getBlock();
    }

    private boolean isSeason(){
        return (parseInt(new SimpleDateFormat("yyyy").format(new Date().toString())) == year &&
                parseInt(new SimpleDateFormat("MM").format(new Date().toString())) - mon < 5) ||
                (parseInt(new SimpleDateFormat("yyyy").format(new Date().toString())) - year == 1 &&
                parseInt(new SimpleDateFormat("MM").format(new Date().toString())) < 6 &&
                mon > 10);
    }

    @Override
    public String getType() {
        return SkipassType.SEASON.toString();
    }

    @Override
    public String left() {
        return "Until season ends";
    }
}
