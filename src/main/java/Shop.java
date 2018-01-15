import java.util.Scanner;


public class Shop{
    private int code = 100000;
    private Scanner reader = new Scanner(System.in);

    public Skipass sellSkipass() {
        int wt = chooseWeekType();
        Week w;
        if (wt == 1) {
            w = Week.WEEKDAY;
        } else {
            w = Week.WEEKEND;
        }
        int st = chooseSkipassType(wt);
        if (st == 3){
            return new SkipassSeason(generateCode());
        }
        int num = chooseAmount(wt, st);
        if (st == 1) {
            if (num == 1) {
                return new SkipassDaily(DaysCounter.ONE_DAY, w, generateCode());
            } else if (num == 2) {
                return new SkipassDaily(DaysCounter.TWO_DAYS, w, generateCode());
            } else if (num == 5) {
                return new SkipassDaily(DaysCounter.FIVE_DAYS, w, generateCode());
            }
        }
        else if (st == 2) {
            if (num == 10) {
                return new SkipassTries(TriesCounter.TEN, w, generateCode());
            }
            else if (num == 20) {
                return new SkipassTries(TriesCounter.TWENTY, w, generateCode());
            }
            else if (num == 50) {
                return new SkipassTries(TriesCounter.FIFTY, w, generateCode());
            }
            else if (num == 100) {
                return new SkipassTries(TriesCounter.HUNDRED, w, generateCode());
            }
        }
        return null;
    }

    private int chooseWeekType(){
        int wt = 0;
        System.out.println("Choose time of week for your skipass:\n" +
                "Press 1 for weekdays\nPress 2 for weekends");
        while (wt != 1 && wt != 2) {
            wt = reader.nextInt();
        }
        return wt;
    }

    private int chooseSkipassType(int wt){
        int st = 0;

        System.out.println("Now choose it's type:\n" +
                "Press 1 to buy skipass for some amount of days(unlimited number of rides)\n" +
                "Press 2 to buy amount of rides");
        if (wt == 2) {
            System.out.println("Press 3 to buy unlimited weekend rides for this whole season");
        }
        while (st != 1 && st != 2 && (st != 3 || wt != 2)) {
            st = reader.nextInt();
        }
        return st;
    }

    private int chooseAmount(int wt, int st){
        int num = 0;
        if (st == 1) {
            if (wt == 1) {
                System.out.println("Finally choose 1, 2 or 5 days skipass you want to buy (type number)");
            }
            else {
                System.out.println("Finally choose 1 or 2 days skipass you want to buy (type number)");
            }
            while (num != 1 && num != 2 && (num != 5 || wt != 1)) {
                num = reader.nextInt();
            }
        }
        else if (st == 2) {
            System.out.println("Finally choose how many rides you want to buy: 10, 20, 50 or 100 (type number)");
            while (num != 10 && num != 20 && num != 50 && num != 100) {
                num = reader.nextInt();
            }
        }
        return num;
    }

    private int generateCode(){
        code++;
        return code;
    }
}
