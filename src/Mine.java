import java.util.Random;

public class Mine extends BattleLoc {
    public Mine(Player player) {
        super(player, "Maden", new Snake(), "Silah, zırh veya para", 5);
    }

    public void dropLoots() {
        Random r = new Random();
        int chance = r.nextInt(1, 101);

        if (chance <= 15) {
            specificWeaponLoots();
        } else if (chance <= 30) {
            specificArmorLoots();
        } else if (chance <= 55) {
            specificMoneyLoots();
        } else {
            System.out.println("Hiçbir şey kazanamadınız.");
        }

    }

    private void specificWeaponLoots() {
        Random r = new Random();
        int number = r.nextInt(100);

        if (number < 20) {
            System.out.println("Tüfek kazandınız.");
            this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(3));
        } else if (number < 50) {
            System.out.println("Kılıç kazandınız.");
            this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(2));
        } else {
            System.out.println("Tabanca kazandınız.");
            this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(1));
        }
    }

    private void specificArmorLoots() {
        Random r = new Random();
        int number = r.nextInt(100);

        if (number < 20) {
            System.out.println("Ağır zırh kazandınız.");
            this.getPlayer().getInventory().setArmor(Armor.getArmorObjByID(3));
        } else if (number < 50) {
            System.out.println("Orta zırh kazandınız.");
            this.getPlayer().getInventory().setArmor(Armor.getArmorObjByID(2));
        } else {
            System.out.println("Hafif zırh kazandınız.");
            this.getPlayer().getInventory().setArmor(Armor.getArmorObjByID(1));
        }
    }

    private void specificMoneyLoots() {
        Random r = new Random();
        int number = r.nextInt(100);

        if (number < 20) {
            System.out.println("10 para kazandınız.");
            this.getPlayer().setMoney(getPlayer().getMoney() + 10);
        } else if (number < 50) {
            System.out.println("5 para kazandınız.");
            this.getPlayer().setMoney(getPlayer().getMoney() + 5);
        } else {
            System.out.println("1 para kazandınız.");
            this.getPlayer().setMoney(getPlayer().getMoney() + 1);
        }
    }
}

