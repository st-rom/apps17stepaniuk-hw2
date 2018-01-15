public enum TriesCounter {
    TEN, TWENTY, FIFTY, HUNDRED;

    public String toString() {
        switch (this) {
            case TEN:
                return "10";
            case TWENTY:
                return "20";
            case FIFTY:
                return "50";
            case HUNDRED:
                return "100";
            default:
                return "0";
        }
    }
}