import java.util.Random;

public class BattleLoc extends Location{

    private  Obstacle obstacle ;
    private String locAward;
    private int maxObstacle;
    private boolean visited ;

    public BattleLoc(Player player, String name , Obstacle obstacle, String locAward, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.locAward = locAward;
        this.maxObstacle = maxObstacle;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getLocAward() {
        return locAward;
    }

    public void setLocAward(String locAward) {
        this.locAward = locAward;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        System.out.println("Şuan buradasınız : " + this.getName());
        System.out.println("Dikkatli ol! Burada " + obsNumber +" tane "+ this.getObstacle().getName() + " yaşıyor ! " );
        System.out.print("<S>avaş veya <K>aç : ");
        String selectCase = input.nextLine().toUpperCase();
        if(selectCase.equals("S") && combat(obsNumber)){
            System.out.println(this.getName() + " tüm düşmanları yendiniz !");
            // Ödülü envantere ekle
            getPlayer().getInventory().addAward(getLocAward());
            System.out.println("Bölüm Sonu Ödülünüz : "+getLocAward());
            return true;
        }
        if(this.getPlayer().getHealth() <= 0){
            System.out.println("Öldünüz !");
            return false;
        }
        return true;
    }
    public boolean combat(int obsNumber) {
        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOrjinalHealth());
            playerStats();
            obstacleStats(i);

            // İlk saldıranı belirle
            boolean playerAttacksFirst = determineFirstAttacker();

            while (getPlayer().getHealth() > 0 && getObstacle().getHealth() > 0) {
                System.out.print("<V>ur veya <K>aç : ");
                String selectCombat = input.nextLine().toUpperCase();

                if (selectCombat.equals("V")) {
                    if (playerAttacksFirst) {
                        playerAttack();
                        if (getObstacle().getHealth() <= 0) {
                            return true; // Oyuncu düşmanı yendi
                        }
                        obstacleAttack();
                    } else {
                        obstacleAttack();
                        if (getPlayer().getHealth() <= 0) {
                            return false; // Düşman oyuncuyu yendi
                        }
                        playerAttack();
                    }
                } else {
                    return false; // Savaştan kaçıldı
                }
            }

            if (getObstacle().getHealth() <= 0) {
                System.out.println("Düşmanı Yendiniz ! ");
                System.out.println(getObstacle().getObsAward() + " para kazandınız ! ");
                getPlayer().setMoney(getPlayer().getMoney() + getObstacle().getObsAward());
                System.out.println(getObstacle().getObsAward() + " kazandınız ! ");


                System.out.println("Güncel Paranız : " + getPlayer().getMoney());
                System.out.println("-----------------------");
            } else {
                return false; // Oyuncu kaybetti
            }
        }

        return true; // Tüm düşmanlar yenildi
    }
    public void afterHit(){
        System.out.println("Canınız: " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " Canı : " + this.getObstacle().getHealth());
        System.out.println("----------");
    }
    public void playerStats(){
        System.out.println("Oyuncu Değerleri");
        System.out.println("------------------------");
        System.out.println("Sağlık : " + this.getPlayer().getHealth());
        System.out.println("Silah : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Zırh : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Hasar : " + this.getPlayer().getTotalDamage());
        System.out.println("Para : " + this.getPlayer().getMoney());
        System.out.println("-------");
    }
    public void obstacleStats(int i){
        System.out.println(i + ". "+this.getObstacle().getName() + " Değerleri ");
        System.out.println("------------------------");
        System.out.println("Sağlık : " + this.getObstacle().getHealth());
        System.out.println("Hasar : " + this.getObstacle().getDamage());
        System.out.println("Ödül : " + this.getObstacle().getObsAward());
    }
    public int randomObstacleNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }
    private boolean determineFirstAttacker() {
        Random random = new Random();
        return random.nextBoolean();
    }
    private void playerAttack() {
        System.out.println("Siz vurdunuz ! ");
        getObstacle().setHealth(getObstacle().getHealth() - getPlayer().getTotalDamage());
        afterHit();
    }

    private void obstacleAttack() {
        System.out.println("Canavar Size Vurdu !");
        int obstacleDamage = getObstacle().getDamage() - getPlayer().getInventory().getArmor().getBlock();
        if (obstacleDamage < 0) {
            obstacleDamage = 0;
        }
        getPlayer().setHealth(getPlayer().getHealth() - obstacleDamage);
        afterHit();
    }
}