import java.util.Arrays;
import java.util.Scanner;

public class Player {
    private int damage;
    private int healthy;
    private int originalHealth;
    private int money;
    private String charName;
    private String name;
    private Scanner input= new Scanner(System.in);
    private Inventory inventory;
    private boolean hasAllAward;

    public Player (String name) {
        this.name=name;
        this.inventory=new Inventory();
    }
    public void selectChar() {
        Samurai samurai=new Samurai();
        Archer archer=new Archer();
        Knight knight=new Knight();

        GameChar[] charList = {new Samurai(),new Archer(),new Knight()};
        for (GameChar gameChar: charList) {
            System.out.println( "ID: " + gameChar.getId() +
                    "\tKarakter:" + gameChar.getName() +
                    "\tHasar:" + gameChar.getDamage() +
                    "\tSağlık:" + gameChar.getHealthy() +
                    "\tPara:" + gameChar.getMoney());
        }
        System.out.println("----------------------------------------------------------------------------------");
        System.out.print("Lütfen karakterinizi seçiniz: ");

            int selectChar = input.nextInt();
            switch (selectChar) {
                case 1:
                    initPlayer(new Samurai());
                    break;
                case 2:
                    initPlayer(new Archer());
                    break;
                case 3:
                    initPlayer(new Knight());
                    break;
                default:
                    initPlayer(new Samurai());
            }
        System.out.println("Seçtiğiniz Karakter: " + this.getCharName() +
                "\tHasar:" + this.getDamage()+
                "\tSağlık:" + this.getHealthy()+
                "\tPara:" + this.getMoney());
        }

    public void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealthy(gameChar.getHealthy());
        this.setOriginalHealth(gameChar.getHealthy());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }
    public void printInfo() {
        System.out.println("Silahınız:" + this.getInventory().getWeapon().getName() +
                "\tZırhınız:" + this.getInventory().getArmor().getName() +
                "\tEngelleme:"+ this.getInventory().getArmor().getBlock() +
                "\tHasarınız:" + this.getTotalDamage() +
                "\tSağlığınız:" + this.getHealthy() +
                "\tParanız:" + this.getMoney());
    }
    public boolean hasAllAward() {
        return inventory.isHasFood() && inventory.isHasFirewood() && inventory.isHasWater();
    }

    public void selectLoc() {
    }
    public int getTotalDamage() {
        return damage + this.getInventory().getWeapon().getDamage();

    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage=damage;
    }
    public int getHealthy() {
        return healthy;
    }
    public void setHealthy(int healthy) {
        if (healthy < 0) {
            healthy=0;
    }
        this.healthy=healthy;
    }
    public int getOriginalHealth() {
        return originalHealth;
    }
    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money=money;
    }
    public String getCharName() {
        return charName;
    }
    public void setCharName(String charName) {
        this.charName=charName;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name=name;
    }
    public Inventory getInventory() {
        return inventory;
    }
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    public boolean isHasAllAward() {
        return hasAllAward;
    }
    public void setHasAllAward(boolean hasAllAward) {
        this.hasAllAward = hasAllAward;
    }
}
