public class River extends BattleLoc{
    public River(Player player) {
        super(player, "Nehir", new Bear(),"Su",2);
    }

    @Override
    public boolean isHasVisited() {
        return this.getPlayer().getInventory().isHasWater();
    }
}
