public class Cave extends BattleLoc{

    public Cave(Player player) {
        super(player, "Mağara",new Zombie(),"Yemek",3);
    }

    @Override
    public boolean isHasVisited() {
        return this.getPlayer().getInventory().isHasFood();
    }
}
