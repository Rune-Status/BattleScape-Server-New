package script.packetdecoder.widget;

import com.palidino.osrs.io.Widget;
import com.palidino.osrs.io.cache.ItemId;
import com.palidino.osrs.io.cache.VarpId;
import com.palidino.osrs.io.cache.WidgetChild;
import com.palidino.osrs.io.cache.WidgetId;
import com.palidino.osrs.model.player.Magic;
import com.palidino.osrs.model.player.Player;

public class CombatOptionsWidget implements Widget {
    @Override
    public int[] getIds() {
        return new int[] {
            WidgetId.COMBAT
        };
    }

    @Override
    public void execute(Player player, int index, int widgetId, int childId, int slot, int itemId) {
        switch (childId) {
        case 3:
        case 7:
        case 11:
        case 15:
            player.getCombat().setAttackStyle((childId - 3) / 4);
            break;
        case 20:
        case 25:
            int varpValue = -1;
            if (player.getMagic().getSpellbook() == Magic.LUNAR_MAGIC
                    || player.getMagic().getSpellbook() == Magic.ARCEUUS_MAGIC) {
                player.getGameEncoder().sendMessage("You can't autocast this spellbook.");
                return;
            } else if (player.getEquipment().getWeaponId() == ItemId.TRIDENT_OF_THE_SEAS_FULL
                    || player.getEquipment().getWeaponId() == ItemId.TRIDENT_OF_THE_SEAS
                    || player.getEquipment().getWeaponId() == ItemId.UNCHARGED_TRIDENT
                    || player.getEquipment().getWeaponId() == ItemId.TRIDENT_OF_THE_SEAS_E
                    || player.getEquipment().getWeaponId() == ItemId.UNCHARGED_TRIDENT_E
                    || player.getEquipment().getWeaponId() == ItemId.TRIDENT_OF_THE_SWAMP
                    || player.getEquipment().getWeaponId() == ItemId.UNCHARGED_TOXIC_TRIDENT
                    || player.getEquipment().getWeaponId() == ItemId.TRIDENT_OF_THE_SWAMP_E
                    || player.getEquipment().getWeaponId() == ItemId.UNCHARGED_TOXIC_TRIDENT_E
                    || player.getEquipment().getWeaponId() == ItemId.SANGUINESTI_STAFF
                    || player.getEquipment().getWeaponId() == ItemId.SANGUINESTI_STAFF_UNCHARGED) {
                player.getGameEncoder().sendMessage("This staff can't autocast spells.");
                return;
            }
            if (player.getMagic().getSpellbook() == Magic.ANCIENT_MAGIC) {
                if (player.getEquipment().getWeaponId() == ItemId.ANCIENT_STAFF
                        || player.getEquipment().getWeaponId() == ItemId.ANCIENT_STAFF_20431
                        || player.getEquipment().getWeaponId() == ItemId.MASTER_WAND
                        || player.getEquipment().getWeaponId() == ItemId.MASTER_WAND_20560
                        || player.getEquipment().getWeaponId() == ItemId.KODAI_WAND
                        || player.getEquipment().wearingFullAhrims()
                                && player.getEquipment().getNeckId() == ItemId.AMULET_OF_THE_DAMNED_FULL
                        || player.getEquipment().getWeaponId() == ItemId.ZURIELS_STAFF
                        || player.getEquipment().getWeaponId() == ItemId.ZURIELS_STAFF_32262
                        || player.getEquipment().getWeaponId() == ItemId.ZURIELS_STAFF_DEG_32269
                        || player.getEquipment().getWeaponId() == ItemId.CORRUPT_ZURIELS_STAFF_32278
                        || player.getEquipment().getWeaponId() == ItemId.C_ZURIELS_STAFF_DEG_32285) {
                    varpValue = ItemId.ANCIENT_STAFF;
                } else {
                    player.getGameEncoder().sendMessage("This staff can't autocast Ancient Magicks.");
                    return;
                }
            } else if (player.getMagic().getSpellbook() == Magic.STANDARD_MAGIC) {
                if (player.getEquipment().getWeaponId() == ItemId.IBANS_STAFF) {
                    varpValue = ItemId.IBANS_STAFF;
                } else if (player.getEquipment().getWeaponId() == ItemId.SLAYERS_STAFF
                        || player.getEquipment().getWeaponId() == ItemId.SLAYERS_STAFF_E) {
                    varpValue = ItemId.SLAYERS_STAFF;
                } else if (player.getEquipment().getWeaponId() == ItemId.STAFF_OF_THE_DEAD
                        || player.getEquipment().getWeaponId() == ItemId.TOXIC_STAFF_UNCHARGED
                        || player.getEquipment().getWeaponId() == ItemId.TOXIC_STAFF_OF_THE_DEAD) {
                    varpValue = ItemId.STAFF_OF_THE_DEAD;
                } else if (player.getEquipment().getWeaponId() == ItemId.STAFF_OF_LIGHT) {
                    varpValue = ItemId.STAFF_OF_LIGHT;
                }
            }
            player.getGameEncoder().setVarp(VarpId.SPELL_SELECT_WEAPON, varpValue);
            player.getWidgetManager().sendWidget(WidgetChild.ViewportContainer.COMBAT, WidgetId.SPELL_SELECT);
            player.getGameEncoder().sendWidgetSettings(WidgetId.SPELL_SELECT, 1, 0, 52, 2);
            player.putAttribute("magic_defensive", childId == 20);
            break;
        case 29:
            player.getCombat().setAutoRetaliate(!player.getCombat().getAutoRetaliate());
            break;
        case 35:
            player.getCombat().activateSpecialAttack();
            break;
        }
    }
}
