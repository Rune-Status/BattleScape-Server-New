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
import com.palidino.osrs.model.npc.combat.style.NpcCombatStyle;
import com.palidino.osrs.model.npc.combat.style.NpcCombatStyleType;
import com.palidino.osrs.model.CombatBonus;
import com.palidino.osrs.model.npc.combat.style.NpcCombatDamage;
import com.palidino.osrs.model.npc.combat.style.NpcCombatProjectile;
import com.palidino.osrs.model.npc.combatscript.NCombatScript;
import lombok.var;

public class RockCrab13Combat extends NCombatScript {
    @Override
    public List<NpcCombatDefinition> getCombatDefs() {
        var drop = NpcCombatDrop.builder().rareDropTableRate(NpcCombatDropTable.CHANCE_1_IN_256);
        var dropTable = NpcCombatDropTable.builder().chance(0.8);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.CLUE_SCROLL_EASY)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(NpcCombatDropTable.CHANCE_RARE);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.CHAOS_RUNE)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.JADE_BOLT_TIPS)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.LIMPWURT_ROOT)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRIMY_RANARR_WEED)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRIMY_AVANTOE)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.TARROMIN_SEED)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.RANARR_SEED)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.CASKET)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(NpcCombatDropTable.CHANCE_UNCOMMON);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.BRONZE_AXE)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.IRON_JAVELIN)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.NATURE_RUNE, 4)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.SPINACH_ROLL)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.KNIFE)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.OPAL_BOLT_TIPS, 5)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.IRON_ORE)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.COAL, 2)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.COPPER_ORE, 3)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.TIN_ORE, 3)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.FISHING_BAIT, 1, 10)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(NpcCombatDropTable.CHANCE_COMMON);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.BRONZE_PICKAXE)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.IRON_PICKAXE)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.FIRE_RUNE, 7)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.COINS, 4, 413)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.OYSTER, 1, 2)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.SEAWEED_NOTED, 1, 5)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.EDIBLE_SEAWEED, 2)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.OYSTER_PEARL)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.EMPTY_OYSTER)));
        drop.table(dropTable.build());


        var combat = NpcCombatDefinition.builder();
        combat.id(NpcId.ROCK_CRAB_13);
        combat.hitpoints(NpcCombatHitpoints.total(50));
        combat.deathAnimation(1314).blockAnimation(1313);
        combat.drop(drop.build());

        var style = NpcCombatStyle.builder();
        style.type(NpcCombatStyleType.melee(CombatBonus.ATTACK_CRUSH));
        style.damage(NpcCombatDamage.maximum(1));
        style.animation(1312).attackSpeed(6);
        style.projectile(NpcCombatProjectile.id(335));
        combat.style(style.build());


        return Arrays.asList(combat.build());
    }
}
