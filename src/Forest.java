public class Forest extends BattleLoc {
    public Forest(Player player) {
        super(player, "Orman", new Vampire(), "Odun", 3);
    }

    @Override
    public boolean isHasVisited() {
        return this.getPlayer().getInventory().isHasFirewood();
    }
}
