package javas.locations;

import javas.BattleLoc;
import javas.Player;
import javas.obstacles.Bear;

public class River extends BattleLoc {
    public River(Player player) {
        super(player, "Nehir" , new Bear() ,"Water",3);
    }
}
