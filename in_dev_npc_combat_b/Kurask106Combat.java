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
import com.palidino.osrs.model.npc.combat.NpcCombatSlayer;
import com.palidino.osrs.model.npc.combat.NpcCombatAggression;
import com.palidino.osrs.model.npc.combat.NpcCombatImmunity;
import com.palidino.osrs.model.npc.combat.style.NpcCombatStyle;
import com.palidino.osrs.model.npc.combat.style.NpcCombatStyleType;
import com.palidino.osrs.model.npc.combat.style.NpcCombatDamage;
import com.palidino.osrs.model.npc.combat.style.NpcCombatProjectile;
import com.palidino.osrs.model.npc.combatscript.NCombatScript;
import lombok.var;

public class Kurask106Combat extends NCombatScript {
    @Override
    public List<NpcCombatDefinition> getCombatDefs() {
        var drop = NpcCombatDrop.builder().rareDropTableRate(NpcCombatDropTable.CHANCE_1_IN_256);
        var dropTable = NpcCombatDropTable.builder().chance(0.03);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.KURASK_HEAD)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(0.29);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.LEAF_BLADED_BATTLEAXE)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(0.58);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.MYSTIC_ROBE_TOP_LIGHT)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(NpcCombatDropTable.CHANCE_1_IN_128);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.CLUE_SCROLL_HARD)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(0.79);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.LEAF_BLADED_SWORD)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(NpcCombatDropTable.CHANCE_UNCOMMON);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.POISON_IVY_SEED)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.CACTUS_SEED)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.KWUARM_SEED)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.CADANTINE_SEED)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.LANTADYME_SEED)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.DWARF_WEED_SEED)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.SNAPDRAGON_SEED)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.TORSTOL_SEED)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.RUNE_LONGSWORD)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.ADAMANT_PLATEBODY)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.RUNE_AXE)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRIMY_IRIT_LEAF, 1, 3)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRIMY_AVANTOE, 1, 3)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRIMY_KWUARM, 1, 3)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRIMY_CADANTINE, 1, 3)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRIMY_DWARF_WEED, 1, 3)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRIMY_RANARR_WEED, 1, 3)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRIMY_LANTADYME, 1, 3)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.PAPAYA_FRUIT_NOTED, 10)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.WHITE_BERRIES_NOTED, 12)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.COCONUT_NOTED, 10)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(NpcCombatDropTable.CHANCE_COMMON);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRIMY_GUAM_LEAF, 1, 3)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRIMY_MARRENTILL, 1, 3)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRIMY_TARROMIN, 1, 3)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRIMY_HARRALANDER, 1, 3)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.COINS, 44, 5000)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.LIMPWURT_ROOT_NOTED, 10, 20)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.FLAX_NOTED, 100)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.BIG_BONES_NOTED, 20)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.MITHRIL_KITESHIELD)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.NATURE_RUNE, 5, 30)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.BELLADONNA_SEED)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.TOADFLAX_SEED)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.IRIT_SEED)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.AVANTOE_SEED)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(NpcCombatDropTable.CHANCE_ALWAYS);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.BONES)));
        drop.table(dropTable.build());


        var combat = NpcCombatDefinition.builder();
        combat.id(NpcId.KURASK_106);
        combat.hitpoints(NpcCombatHitpoints.total(97));
        combat.stats(NpcCombatStats.builder().attackLevel(67).defenceLevel(105).bonus(CombatBonus.DEFENCE_SLASH, 20).bonus(CombatBonus.DEFENCE_CRUSH, 20).build());
        combat.slayer(NpcCombatSlayer.builder().level(70).superiorId(NpcId.KING_KURASK_295).build());
        combat.aggression(NpcCombatAggression.PLAYERS);
        combat.immunity(NpcCombatImmunity.builder().poison(true).build());
        combat.deathAnimation(1513).blockAnimation(1514);
        combat.drop(drop.build());

        var style = NpcCombatStyle.builder();
        style.type(NpcCombatStyleType.melee(CombatBonus.ATTACK_CRUSH));
        style.damage(NpcCombatDamage.maximum(11));
        style.animation(1512).attackSpeed(4);
        style.projectile(NpcCombatProjectile.id(335));
        combat.style(style.build());


        return Arrays.asList(combat.build());
    }
}
