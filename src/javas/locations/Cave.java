package javas.locations;

import javas.BattleLoc;
import javas.Player;
import javas.obstacles.Zombie;

public class Cave extends BattleLoc {
    public Cave(Player player) {
        super(player,"Mağara" , new Zombie(),"Food" ,3);
    }
}
