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
import com.palidino.osrs.model.npc.combat.style.NpcCombatStyle;
import com.palidino.osrs.model.npc.combat.style.NpcCombatProjectile;
import com.palidino.osrs.model.npc.combatscript.NCombatScript;
import lombok.var;

public class Guard21_3010Combat extends NCombatScript {
    @Override
    public List<NpcCombatDefinition> getCombatDefs() {
        var drop = NpcCombatDrop.builder();
        var dropTable = NpcCombatDropTable.builder().chance(NpcCombatDropTable.CHANCE_1_IN_128);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.CLUE_SCROLL_MEDIUM)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(NpcCombatDropTable.CHANCE_RARE);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.IRON_ORE)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.MIND_TALISMAN)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.CHAOS_RUNE, 1, 2)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.NATURE_RUNE)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.BLOOD_RUNE)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.SWEETCORN_SEED, 3)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.STRAWBERRY_SEED, 1, 2)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.WATERMELON_SEED, 2)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRAIN)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(NpcCombatDropTable.CHANCE_UNCOMMON);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.STEEL_ARROW, 1, 5)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.IRON_ARROW, 1, 2)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.BODY_TALISMAN)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(NpcCombatDropTable.CHANCE_COMMON);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.IRON_DAGGER)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.IRON_BOLTS, 1, 12)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.BRONZE_ARROW, 1, 2)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.AIR_RUNE, 6)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.EARTH_RUNE, 3)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.FIRE_RUNE, 2)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.POTATO_SEED, 4)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.ONION_SEED, 4)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.CABBAGE_SEED, 4)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.TOMATO_SEED, 3)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.COINS, 1, 30)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(NpcCombatDropTable.CHANCE_ALWAYS);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.BONES)));
        drop.table(dropTable.build());


        var combat = NpcCombatDefinition.builder();
        combat.id(NpcId.GUARD_21_3010);
        combat.drop(drop.build());

        var style = NpcCombatStyle.builder();
        style.animation(6489);
        style.projectile(NpcCombatProjectile.id(335));
        combat.style(style.build());


        return Arrays.asList(combat.build());
    }
}
