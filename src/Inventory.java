public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private boolean hasFood;
    private boolean hasFirewood;
    private boolean hasWater;

    public Inventory() {
        this.weapon=new Weapon("Yumruk",-1,0,0);
        this.armor=new Armor(-1,"Paçavra",0,0);
        this.hasFood = false;
        this.hasFirewood = false;
        this.hasWater=false;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public boolean isHasFood() {
        return hasFood;
    }

    public void setHasFood(boolean hasFood) {
        this.hasFood=hasFood;
    }

    public boolean isHasFirewood() {
        return hasFirewood;
    }

    public void setHasFirewood(boolean hasFirewood) {
        this.hasFirewood = hasFirewood;
    }

    public boolean isHasWater() {
        return hasWater;
    }

    public void setHasWater(boolean hasWater) {
        this.hasWater = hasWater;
    }
}
