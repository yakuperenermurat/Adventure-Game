package javas;

import javas.armorAndweapon.Armor;
import javas.armorAndweapon.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private List<String> awards;

    public Inventory() {
        this.weapon = new Weapon("Yumruk", -1, 0, 0);
        this.armor = new Armor(-1, "Paçavra", 0, 0);
        this.awards = new ArrayList<>();
    }

    // Ödül kontrolü
    public boolean hasAward(String award) {
        return awards.contains(award);
    }

    // Ödül ekleme
    public void addAward(String award) {
        awards.add(award);
    }

    // Ödül listesini alma
    public List<String> getAwards() {
        return awards;
    }


    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
