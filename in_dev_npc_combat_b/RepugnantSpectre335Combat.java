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
import com.palidino.osrs.model.HitpointsBar;
import com.palidino.osrs.model.npc.combat.NpcCombatStats;
import com.palidino.osrs.model.CombatBonus;
import com.palidino.osrs.model.npc.combat.NpcCombatSlayer;
import com.palidino.osrs.model.npc.combat.NpcCombatAggression;
import com.palidino.osrs.model.npc.combat.NpcCombatKillCount;
import com.palidino.osrs.model.npc.combat.NpcCombatType;
import com.palidino.osrs.model.npc.combat.style.NpcCombatStyle;
import com.palidino.osrs.model.npc.combat.style.NpcCombatStyleType;
import com.palidino.osrs.model.npc.combat.style.NpcCombatDamage;
import com.palidino.osrs.model.Graphic;
import com.palidino.osrs.model.npc.combat.style.NpcCombatProjectile;
import com.palidino.osrs.model.npc.combatscript.NCombatScript;
import lombok.var;

public class RepugnantSpectre335Combat extends NCombatScript {
    @Override
    public List<NpcCombatDefinition> getCombatDefs() {
        var drop = NpcCombatDrop.builder().rareDropTableRate(NpcCombatDropTable.CHANCE_1_IN_256).rolls(3);
        var dropTable = NpcCombatDropTable.builder().chance(0.4).log(true);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.MYSTIC_ROBE_BOTTOM_DARK)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(2.0).log(true);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.IMBUED_HEART)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.ETERNAL_GEM)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.DUST_BATTLESTAFF)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.MIST_BATTLESTAFF)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(NpcCombatDropTable.CHANCE_RARE);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.DWARF_WEED_SEED)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.SNAPDRAGON_SEED)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.TORSTOL_SEED)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(8.0);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.CLUE_SCROLL_HARD)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(NpcCombatDropTable.CHANCE_UNCOMMON);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.IRIT_SEED)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.TOADFLAX_SEED)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.AVANTOE_SEED)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.CADANTINE_SEED)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.KWUARM_SEED)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.POISON_IVY_SEED)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.LANTADYME_SEED)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRIMY_CADANTINE, 1, 3)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRIMY_LANTADYME, 1, 3)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRIMY_DWARF_WEED, 1, 3)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.MITHRIL_BATTLEAXE)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.BATTLESTAFF)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.LAVA_BATTLESTAFF)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.BLACK_PLATELEGS)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.RUNE_FULL_HELM)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.RUNE_CHAINBODY)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.ADAMANTITE_ORE)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.LIMPWURT_ROOT_NOTED, 2, 11)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(NpcCombatDropTable.CHANCE_COMMON);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.BELLADONNA_SEED)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.CACTUS_SEED)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRIMY_GUAM_LEAF, 1, 3)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRIMY_MARRENTILL, 1, 3)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRIMY_TARROMIN, 1, 3)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRIMY_HARRALANDER, 1, 3)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRIMY_RANARR_WEED, 1, 3)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRIMY_IRIT_LEAF, 1, 3)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRIMY_AVANTOE, 1, 3)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRIMY_KWUARM, 1, 3)));
        drop.table(dropTable.build());


        var combat = NpcCombatDefinition.builder();
        combat.id(NpcId.REPUGNANT_SPECTRE_335);
        combat.hitpoints(NpcCombatHitpoints.builder().total(390).bar(HitpointsBar.GREEN_RED_60).build());
        combat.stats(NpcCombatStats.builder().magicLevel(380).defenceLevel(220).bonus(CombatBonus.MELEE_DEFENCE, 120).bonus(CombatBonus.DEFENCE_RANGED, 115).build());
        combat.slayer(NpcCombatSlayer.builder().level(60).experience(4085).build());
        combat.aggression(NpcCombatAggression.PLAYERS);
        combat.killCount(NpcCombatKillCount.builder().asName("Superior Slayer Creature").build());
        combat.combatScript("SuperiorSlayerCS").type(NpcCombatType.UNDEAD).deathAnimation(6369).blockAnimation(6370);
        combat.drop(drop.build());

        var style = NpcCombatStyle.builder();
        style.type(NpcCombatStyleType.MAGIC);
        style.damage(NpcCombatDamage.maximum(39));
        style.animation(6368).attackSpeed(4);
        style.targetGraphic(new Graphic(336, 300));
        style.projectile(NpcCombatProjectile.id(335));
        combat.style(style.build());


        return Arrays.asList(combat.build());
    }
}
