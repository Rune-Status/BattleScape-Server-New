package script.packetdecoder.command;

import com.palidino.osrs.io.Command;
import com.palidino.osrs.model.player.Player;

public class ChatIconCommand implements Command {
    @Override
    public String getExample() {
        return "id";
    }

    @Override
    public boolean canUse(Player player) {
        return player.getRights() == Player.RIGHTS_ADMIN;
    }

    @Override
    public void execute(Player player, String message) {
        player.getMessaging().setOverrideIcon(Integer.parseInt(message));
    }
}
