public enum SkipassType {
    DAYS, TRIES, SEASON;
    public String toString() {
        switch (this) {
            case DAYS:
                return "For days";
            case TRIES:
                return "For tries";
            case SEASON:
                return "For season";
            default:
                return "0 TRIES";
        }
    }
}
