package script.packetdecoder.widget;

import com.palidino.osrs.io.Widget;
import com.palidino.osrs.io.cache.WidgetId;
import com.palidino.osrs.model.dialogue.Dialogue;
import com.palidino.osrs.model.player.Player;

public class DialogueWidget implements Widget {
    @Override
    public int[] getIds() {
        return new int[] {
            WidgetId.CHATBOX_SELECTION, WidgetId.SCREEN_SELECTION, WidgetId.CHATBOX_CONTINUE, WidgetId.MAKE_X
        };
    }

    @Override
    public void execute(Player player, int index, int widgetId, int childId, int slot, int itemId) {
        if (widgetId == WidgetId.CHATBOX_SELECTION) {
            slot--;
        } else if (widgetId == WidgetId.CHATBOX_CONTINUE) {
            slot = 0;
        } else if (widgetId == WidgetId.MAKE_X) {
            childId -= 14;
        }
        Dialogue.handleWidget(player, childId, slot);
    }
}
