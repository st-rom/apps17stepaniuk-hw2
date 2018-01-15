public enum DaysCounter {
    ONE_DAY, TWO_DAYS, FIVE_DAYS, UNLIM;
    public String toString() {
        switch (this) {
            case ONE_DAY:
                return "1";
            case TWO_DAYS:
                return "2";
            case FIVE_DAYS:
                return "5";
            case UNLIM:
                return "0";
            default:
                return "0";
        }
    }

}
