public class Toolstore extends NormalLoc{
    public Toolstore(Player player) {
        super(player,"Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Mağazaya Hoşgeldiniz !");
        boolean showMenu = true;
        while(showMenu) {
            System.out.println("1-Silahlar\n2-Zırhlar\n3-Çıkış Yap");
            System.out.print("Seçiminiz: ");
            int selectTool = input.nextInt();
            while (selectTool < 1 || selectTool > 3) {
                System.out.print("Geçerli seçim yapınız: ");
                selectTool = input.nextInt();
            }
            switch (selectTool) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Çıkış yapıyorsunuz!");
                    showMenu=false;
                    break;

            }
        } return true;
    }

    public void printWeapon() {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Silahlar:");
        for (Weapon w: Weapon.weapons()) {
            System.out.println(w.getId() + "." + w.getName() + "\tHasar:" + w.getDamage() + "\tPara: " + w.getPrice());
        }
        System.out.println("0 - Çıkış Yap");
    }

    public void buyWeapon() {
        System.out.print("Bir silah seçiniz:");
        int selectWeapon = input.nextInt();

        while (selectWeapon < 0 || selectWeapon > Weapon.weapons().length) {
            System.out.print("Geçerli seçim yapınız: ");
            selectWeapon = input.nextInt();
        }

        if (selectWeapon != 0) {

            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeapon);

            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli miktarda paranız yok! ");
                } else {
                    System.out.println(selectedWeapon.getName() + " silahını satın aldınız!");
                    int balance = getPlayer().getMoney() - selectedWeapon.getPrice();
                    getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız: " + this.getPlayer().getMoney());

                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                }
            }
        }
    }
    public void printArmor() {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Zırhlar: ");
        for (Armor a: Armor.armors()) {
            System.out.println(a.getId() + "." + a.getName() + "\t\tEngelleme:" + a.getBlock() + "\tPara:" + a.getPrice());
        }
        System.out.println("0 - Çıkış Yap");
    }
    public void buyArmor() {
        System.out.print("Bir zırh seçiniz:");
        int selectArmor=input.nextInt();

        while (selectArmor <0 || selectArmor > Armor.armors().length) {
            System.out.print("Geçerli seçim yapınız: ");
            selectArmor = input.nextInt();
        }

        if(selectArmor != 0) {

            Armor selectedArmor = Armor.getArmorObjByID(selectArmor);

            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli miktarda paranız yok! ");
                } else {
                    System.out.println(selectedArmor.getName() + " zırhı seçtiniz.");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız: " + this.getPlayer().getMoney());

                    this.getPlayer().getInventory().setArmor(selectedArmor);
                }
            }
        }
    }
}
