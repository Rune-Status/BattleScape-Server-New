package script.packetdecoder;

import com.palidino.io.Stream;
import com.palidino.osrs.io.PacketDecoder;
import com.palidino.osrs.model.Movement;
import com.palidino.osrs.model.player.Player;
import com.palidino.osrs.util.RequestManager;
import lombok.var;

public class MovementDecoder extends PacketDecoder {
    public MovementDecoder() {
        super(96, 52);
    }

    @Override
    public void execute(Player player, int index, int size, Stream stream) {
        var y = stream.getUShort128();
        var x = stream.getUShort128();
        var moveType = stream.getUByte128();
        var message = "[Movement(" + index + ")] x=" + x + "; y=" + y + "; moveType=" + moveType;
        RequestManager.addUserPacketLog(player, message);
        if (player.getGameMode() == 0 || player.isDead()) {
            return;
        }
        if (player.getMovement().isViewing() || player.getAppearance().getNpcId() == Movement.VIEWING_NPC_ID) {
            if (!player.getMovement().getTeleporting() && !player.getMovement().getTeleported()) {
                player.getMovement().stopViewing();
                player.getWidgetManager().removeInteractiveWidgets();
            }
            return;
        }
        player.clearIdleTime();
        player.setInteractingEntity(null);
        player.putAttribute("packet_decoder_index", index);
        player.putAttribute("packet_decoder_move_x", x);
        player.putAttribute("packet_decoder_move_y", y);
        player.putAttribute("packet_decoder_move_type", moveType);
        if (complete(player)) {
            stop(player);
            return;
        }
        player.putAttribute("packetdecoder", this);
    }

    @Override
    public boolean complete(Player player) {
        var index = player.getAttributeInt("packet_decoder_index");
        var x = player.getAttributeInt("packet_decoder_move_x");
        var y = player.getAttributeInt("packet_decoder_move_y");
        var moveType = player.getAttributeInt("packet_decoder_move_type");
        if (player.isLocked()) {
            return false;
        }
        if (!player.getMovement().isRouting() && player.getX() == x && player.getY() == y) {
            player.getCombat().clear(false);
            return false;
        }
        if (player.getController().movementHook(index, x, y, moveType)) {
            return true;
        }
        player.getMovement().fullRoute(x, y, moveType);
        return true;
    }

    @Override
    public void stop(Player player) {
        player.removeAttribute("packet_decoder_move_x");
        player.removeAttribute("packet_decoder_move_y");
        player.removeAttribute("packet_decoder_move_type");
    }
}
