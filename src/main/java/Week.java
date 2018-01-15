public enum Week {
    WEEKDAY, WEEKEND;
    public String toString() {
        switch (this) {
            case WEEKDAY:
                return "Weekday";
            case WEEKEND:
                return "Weekend";
            default:
                return null;
        }
    }
}