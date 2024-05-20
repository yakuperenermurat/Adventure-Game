package javas.locations;

import javas.BattleLoc;
import javas.Player;
import javas.obstacles.Vampire;

public class Forest extends BattleLoc {
    public Forest(Player player) {
        super(player,"Orman",new Vampire(),"Firewood",3);
    }
}
