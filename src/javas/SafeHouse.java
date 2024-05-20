package javas;

public class SafeHouse extends NormalLoc {
    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    @Override
    public boolean onLocation() {
        // Tüm ödüller toplandıysa oyunu kazanıldı olarak işaretle
        if (getPlayer().getInventory().hasAward("Food") &&
                getPlayer().getInventory().hasAward("Firewood") &&
                getPlayer().getInventory().hasAward("Water")) {
            System.out.println("Tüm ödüller toplandı! Oyunu kazandınız!");
            return false; // Oyunu bitir
        }else {
            System.out.println("Güvenli evdesiniz ! ");
            System.out.println("Canınız yenilendi ! ");
            this.getPlayer().setHealth(this.getPlayer().getOrjinalHealth());

            return true;
        }
    }
}