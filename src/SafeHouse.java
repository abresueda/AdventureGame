public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Güvenli evdesiniz.");
        System.out.println("Canınız yenilendi.");
        this.getPlayer().setHealthy(this.getPlayer().getOriginalHealth());

        if (getPlayer().hasAllAward()) {
            System.out.println("Tüm ödülleri topladınız ve Güvenli Eve döndünüz. Oyunu kazandınız! ");
            return false;
        } return true;
    }
}