package script.npc.combat;

import java.util.Arrays;
import java.util.List;
import com.palidino.osrs.io.cache.NpcId;
import com.palidino.osrs.model.npc.combat.NpcCombatDefinition;
import com.palidino.osrs.model.npc.combat.NpcCombatDrop;
import com.palidino.osrs.model.npc.combat.NpcCombatDropTable;
import com.palidino.osrs.model.npc.combat.NpcCombatDropTableDrop;
import com.palidino.osrs.model.item.RandomItem;
import com.palidino.osrs.io.cache.ItemId;
import com.palidino.osrs.model.npc.combat.NpcCombatHitpoints;
import com.palidino.osrs.model.npc.combat.NpcCombatStats;
import com.palidino.osrs.model.npc.combat.style.NpcCombatStyle;
import com.palidino.osrs.model.npc.combat.style.NpcCombatStyleType;
import com.palidino.osrs.model.CombatBonus;
import com.palidino.osrs.model.npc.combat.style.NpcCombatDamage;
import com.palidino.osrs.model.npc.combat.style.NpcCombatProjectile;
import com.palidino.osrs.model.npc.combatscript.NCombatScript;
import lombok.var;

public class Rogue135Combat extends NCombatScript {
    @Override
    public List<NpcCombatDefinition> getCombatDefs() {
        var drop = NpcCombatDrop.builder();
        var dropTable = NpcCombatDropTable.builder().chance(NpcCombatDropTable.CHANCE_1_IN_128);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.CLUE_SCROLL_EASY)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(NpcCombatDropTable.CHANCE_RARE);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.CHAOS_RUNE, 1, 2)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.FIRE_RUNE, 4)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.AIR_RUNE, 8)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.MIND_RUNE, 6)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.IRON_PLATEBODY)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.CADANTINE)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.LANTADYME)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.DWARF_WEED)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.COPPER_ORE)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.JUG_OF_WINE)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.LOCKPICK)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(NpcCombatDropTable.CHANCE_UNCOMMON);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.BRONZE_ARROW, 7)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.EARTH_RUNE, 3)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.BRONZE_MED_HELM)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.IRON_DAGGER)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.IRON_DAGGER_P)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.STAFF_OF_AIR)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.HARRALANDER)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.RANARR_WEED)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.IRIT_LEAF)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.AVANTOE)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.KWUARM)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.EARTH_TALISMAN)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.FISHING_BAIT)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.CABBAGE)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(NpcCombatDropTable.CHANCE_COMMON);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.BRONZE_BOLTS, 4, 12)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GUAM_LEAF)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.MARRENTILL)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.TARROMIN)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(NpcCombatDropTable.CHANCE_ALWAYS);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.BONES)));
        drop.table(dropTable.build());


        var combat = NpcCombatDefinition.builder();
        combat.id(NpcId.ROGUE_135);
        combat.hitpoints(NpcCombatHitpoints.total(125));
        combat.stats(NpcCombatStats.builder().attackLevel(140).defenceLevel(150).build());
        combat.deathAnimation(836).blockAnimation(404);
        combat.drop(drop.build());

        var style = NpcCombatStyle.builder();
        style.type(NpcCombatStyleType.melee(CombatBonus.ATTACK_STAB));
        style.damage(NpcCombatDamage.maximum(15));
        style.animation(412).attackSpeed(4);
        style.projectile(NpcCombatProjectile.id(335));
        combat.style(style.build());


        return Arrays.asList(combat.build());
    }
}
