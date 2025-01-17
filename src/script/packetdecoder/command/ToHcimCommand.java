package script.packetdecoder.command;

import com.palidino.osrs.io.Command;
import com.palidino.osrs.model.player.Player;
import com.palidino.rs.RSPlayer;
import lombok.var;

public class ToHcimCommand implements Command {
    @Override
    public String getExample() {
        return "username";
    }

    @Override
    public boolean canUse(Player player) {
        return player.getRights() == Player.RIGHTS_ADMIN;
    }

    @Override
    public void execute(Player player, String username) {
        var player2 = player.getWorld().getPlayerByUsername(username);
        if (player2 == null) {
            player.getGameEncoder().sendMessage("Unable to find user " + username + ".");
            return;
        }
        player2.setGameMode(RSPlayer.GAME_MODE_HARDCORE_IRONMAN);
        player2.getGameEncoder().sendMessage("Your gamemode has been set to Hardcore mode by " + player.getUsername());
        player.getGameEncoder().sendMessage("Success");
    }
}
