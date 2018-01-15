public class Turnstile {
    public boolean useSkipass(Skipass card) {
        card.useSkipass();
        System.out.println(card.getType() + "\n(" + card.getCode() + ")");
        System.out.println(card.left());
        return card.isValid();
    }

    public void blockSkipass(Skipass card){
        card.setBlock();
    }
}
