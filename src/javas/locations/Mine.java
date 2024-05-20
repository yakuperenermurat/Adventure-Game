package javas.locations;

import javas.BattleLoc;
import javas.Player;
import javas.obstacles.Snake;

public class Mine extends BattleLoc {
    public Mine(Player player) {
        super(player, "Maden", new Snake(), "tabak", 5);
    }
}
