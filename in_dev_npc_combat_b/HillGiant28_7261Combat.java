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
import com.palidino.osrs.model.CombatBonus;
import com.palidino.osrs.model.npc.combat.NpcCombatAggression;
import com.palidino.osrs.model.npc.combat.style.NpcCombatStyle;
import com.palidino.osrs.model.npc.combat.style.NpcCombatStyleType;
import com.palidino.osrs.model.npc.combat.style.NpcCombatDamage;
import com.palidino.osrs.model.npc.combat.style.NpcCombatProjectile;
import com.palidino.osrs.model.npc.combatscript.NCombatScript;
import lombok.var;

public class HillGiant28_7261Combat extends NCombatScript {
    @Override
    public List<NpcCombatDefinition> getCombatDefs() {
        var drop = NpcCombatDrop.builder().rareDropTableRate(NpcCombatDropTable.CHANCE_1_IN_256);
        var dropTable = NpcCombatDropTable.builder().chance(0.2).order(NpcCombatDropTable.Order.RANDOM_UNIQUE);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.DARK_TOTEM_BASE)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.DARK_TOTEM_MIDDLE)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.DARK_TOTEM_TOP)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(0.3);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.ANCIENT_SHARD)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(4.0);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.ENSOULED_GIANT_HEAD_13475)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(NpcCombatDropTable.CHANCE_RARE);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.IRON_2H_SWORD)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.STEEL_PLATEBODY)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.MITHRIL_ARROW, 3)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.ADAMANT_ARROW, 1, 5)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.CHAOS_RUNE, 2)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.DEATH_RUNE, 2)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRIMY_KWUARM)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRIMY_CADANTINE)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRIMY_LANTADYME)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRIMY_DWARF_WEED)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.STRAWBERRY_SEED, 2)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.SWEETCORN_SEED, 3)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.LIMPWURT_SEED)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.WATERMELON_SEED, 1, 4)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(NpcCombatDropTable.CHANCE_UNCOMMON);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.IRON_DAGGER)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.IRON_FULL_HELM)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.IRON_KITESHIELD)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.STEEL_LONGSWORD)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.STEEL_ARROW, 10)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.STEEL_DAGGER)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.COSMIC_RUNE, 2)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.LAW_RUNE, 2)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.MIND_RUNE, 3)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.NATURE_RUNE, 6)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.FIRE_RUNE, 15)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRIMY_HARRALANDER)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRIMY_RANARR_WEED)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRIMY_IRIT_LEAF)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRIMY_AVANTOE)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.TOMATO_SEED, 1, 3)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.CABBAGE_SEED, 4)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.LIMPWURT_ROOT)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.BEER)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.BODY_TALISMAN)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(NpcCombatDropTable.CHANCE_COMMON);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.IRON_ARROW, 3)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.WATER_RUNE, 7)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRIMY_GUAM_LEAF)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRIMY_MARRENTILL)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRIMY_TARROMIN)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.POTATO_SEED, 4)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.ONION_SEED, 4)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(NpcCombatDropTable.CHANCE_ALWAYS);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.BIG_BONES)));
        drop.table(dropTable.build());


        var combat = NpcCombatDefinition.builder();
        combat.id(NpcId.HILL_GIANT_28_7261);
        combat.hitpoints(NpcCombatHitpoints.total(35));
        combat.stats(NpcCombatStats.builder().attackLevel(18).defenceLevel(26).bonus(CombatBonus.MELEE_ATTACK, 18).build());
        combat.aggression(NpcCombatAggression.PLAYERS);
        combat.deathAnimation(4653).blockAnimation(4651);
        combat.drop(drop.build());

        var style = NpcCombatStyle.builder();
        style.type(NpcCombatStyleType.melee(CombatBonus.ATTACK_CRUSH));
        style.damage(NpcCombatDamage.maximum(4));
        style.animation(4652).attackSpeed(4);
        style.projectile(NpcCombatProjectile.id(335));
        combat.style(style.build());


        return Arrays.asList(combat.build());
    }
}
