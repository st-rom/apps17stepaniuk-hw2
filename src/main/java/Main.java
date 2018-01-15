public class Main {
    public static void main(String[] args){
        Shop shop = new Shop();
        Turnstile tur = new Turnstile();
        Skipass sp = shop.sellSkipass();
        System.out.println("\n" + sp.getCode());
        tur.useSkipass(sp);
        System.out.println(sp.left());
        System.out.println(sp.getType());
        tur.useSkipass(sp);
        Skipass sp2 = shop.sellSkipass();
        tur.useSkipass(sp2);
        System.out.println(sp.left());
        System.out.println(sp2.left());
        tur.blockSkipass(sp2);
        System.out.println(sp2.getBlock());
        tur.useSkipass(sp2);
    }
}
