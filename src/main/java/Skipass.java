public interface Skipass {
    String left();
    String getType();
    boolean isValid();
    void useSkipass();
    int getCode();
    boolean inTime();
    void setBlock();
    boolean getBlock();
}
