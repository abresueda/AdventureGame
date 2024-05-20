import java.util.Random;

public abstract class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    private boolean hasVisited;
    private boolean randomCombat;

    public BattleLoc(Player player, String name,Obstacle obstacle,String award, int maxObstacle) {
        super(player, name);
        this.obstacle=obstacle;
        this.award=award;
        this.maxObstacle=maxObstacle;
        this.hasVisited=false;
    }

    @Override
    public boolean onLocation() {
        if (isHasVisited()) {
            System.out.println("Bu bölgeye daha önce girdiniz ve ödülleri kazandınız! Bir daha giremezsiniz!");
            return true;
        }

        int obsNumber = this.randomObstacleNumber();

        System.out.println("Şuan bu noktadasınız: " + this.getName());
        System.out.println("Dikkatli Ol! Burada " + obsNumber + " tane " + this.getObstacle().getName() + " yaşıyor!");
        System.out.println("Savaş (S) veya Kaç (K) ! Karar Senin !");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();

        Random r= new Random();
        randomCombat = r.nextBoolean();

        if (selectCase.equals("S")) {
            System.out.println("Savaşmayı seçtiniz!");
            if (combat(obsNumber)) {
                System.out.println(this.getName() + " içindeki tüm canavarları yendiniz!");
                if (this.getName().equals("Mağara")) {
                    this.getPlayer().getInventory().setHasFood(true);
                } else if (this.getName().equals("Orman")) {
                    this.getPlayer().getInventory().setHasFirewood(true);
                } else if (this.getName().equals("Nehir")) {
                    this.getPlayer().getInventory().setHasWater(true);
                }
                setHasVisited(true);
                System.out.println(this.getAward() + " ödülünü kazandınız! ");
                return true;
            }

            if (this.getPlayer().getHealthy() <= 0) {
                System.out.println("Öldünüz! ");
                return false;
            }

        }  return true;

    }


    public boolean combat(int obsNumber) {
        for (int i=1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
            playerStats();
            obstacleStats(i);
            while(this.getPlayer().getHealthy() > 0 && this.getObstacle().getHealth()>0 ) {
                if (randomCombat) {
                    System.out.println("Vur (V) veya Kaç (K) ! Karar Senin ! ");
                    String selectCombat = input.nextLine().toUpperCase();
                    if (selectCombat.equals("V")) {
                        System.out.println(this.getObstacle().getName() + " vurdunuz! ");
                        this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();
                        randomCombat = !randomCombat;
                    } else {
                        return false;
                    }
                }else {
                    if (this.getObstacle().getHealth() > 0) {
                        System.out.println("----------------------------------------------------------------------------------");
                        System.out.println(this.getObstacle().getName()  + " size vurdu!");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (obstacleDamage < 0) {
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealthy(this.getPlayer().getHealthy() - obstacleDamage);
                        afterHit();
                    }
                    randomCombat = !randomCombat;
                }
            }
            if (this.getObstacle().getHealth() < this.getPlayer().getHealthy()) {
                System.out.println("----------------------------------------------------------------------------------");
                System.out.println("Canavarı yendiniz! ");
                System.out.println(this.getObstacle().getAward() + " para kazandınız.");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                Mine dropLoots= new Mine(getPlayer());
                dropLoots.dropLoots();
                System.out.println("Güncel Paranız: " + this.getPlayer().getMoney());

            } else {
                return false;
            }
        }
        return true;
    }

    public void afterHit() {
        System.out.println("Canınız: " + this.getPlayer().getHealthy());
        System.out.println(this.getObstacle().getName() + " Canı: " + this.getObstacle().getHealth());
    }

    public void playerStats() {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Oyuncu Değerleri:");
        System.out.println("Sağlık: " + this.getPlayer().getHealthy());
        System.out.println("Silah: " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Hasar: " + this.getPlayer().getTotalDamage());
        System.out.println("Zırh: " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Engelleme: " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Para: " + this.getPlayer().getMoney());
        }

    public void obstacleStats(int i) {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println( i + "." + this.getObstacle().getName() + " Değerleri:");
        System.out.println("Sağlık: " + this.getObstacle().getHealth());
        System.out.println("Hasar: " + this.getObstacle().getDamage());
        System.out.println("Ödül Parası: " + this.getObstacle().getAward());
    }

    public int randomObstacleNumber() {
        Random r= new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;  //0 ihtimalini yok etmek için +1 ekledik.
    }
    public Obstacle getObstacle() {
        return obstacle;
    }
    public void setObstacle(Obstacle obstacle) {
        this.obstacle=obstacle;
    }
    public String getAward() {
        return  award;
    }
    public void setAward(String award) {
        this.award=award;
    }
    public int getMaxObstacle() {
        return maxObstacle;
    }
    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
    public boolean isHasVisited() {
        return hasVisited;
    }
    public void setHasVisited(boolean hasVisited) {
        this.hasVisited = hasVisited;
    }
}
