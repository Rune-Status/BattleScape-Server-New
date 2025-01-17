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
import com.palidino.osrs.model.npc.combat.NpcCombatSpawn;
import com.palidino.osrs.model.npc.combat.NpcCombatHitpoints;
import com.palidino.osrs.model.npc.combat.NpcCombatStats;
import com.palidino.osrs.model.CombatBonus;
import com.palidino.osrs.model.npc.combat.NpcCombatImmunity;
import com.palidino.osrs.model.npc.combat.NpcCombatKillCount;
import com.palidino.osrs.model.npc.combat.style.NpcCombatStyle;
import com.palidino.osrs.model.npc.combat.style.NpcCombatStyleType;
import com.palidino.osrs.model.npc.combat.style.NpcCombatDamage;
import com.palidino.osrs.model.npc.combat.style.NpcCombatProjectile;
import com.palidino.osrs.model.npc.combatscript.NCombatScript;
import lombok.var;

public class GiantMole230Combat extends NCombatScript {
    @Override
    public List<NpcCombatDefinition> getCombatDefs() {
        var drop = NpcCombatDrop.builder().rareDropTableRate(NpcCombatDropTable.CHANCE_1_IN_256);
        var dropTable = NpcCombatDropTable.builder().chance(0.034).broadcast(true).log(true);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.BABY_MOLE)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(0.2);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.CLUE_SCROLL_ELITE)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(NpcCombatDropTable.CHANCE_RARE);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.MITHRIL_BAR)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.OYSTER_PEARLS)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(NpcCombatDropTable.CHANCE_UNCOMMON);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.LAW_RUNE, 15)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.IRON_ARROW, 690)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.IRON_ORE_NOTED, 100)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.SHARK, 4)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.YEW_LOGS_NOTED, 100)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRIMY_TORSTOL_NOTED, 1, 5)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(NpcCombatDropTable.CHANCE_COMMON);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.AIR_RUNE, 105)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.FIRE_RUNE, 105)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.BLOOD_RUNE, 15)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.DEATH_RUNE, 7)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.ADAMANT_LONGSWORD)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.MITHRIL_AXE)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.MITHRIL_BATTLEAXE)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.MITHRIL_PLATEBODY)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.RUNE_MED_HELM)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.AMULET_OF_STRENGTH)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(NpcCombatDropTable.CHANCE_ALWAYS);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.BIG_BONES)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.MOLE_CLAW)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.MOLE_SKIN, 1, 3)));
        drop.table(dropTable.build());


        var combat = NpcCombatDefinition.builder();
        combat.id(NpcId.GIANT_MOLE_230);
        combat.spawn(NpcCombatSpawn.builder().respawnDelay(15).build());
        combat.hitpoints(NpcCombatHitpoints.total(200));
        combat.stats(NpcCombatStats.builder().attackLevel(200).magicLevel(200).defenceLevel(200).bonus(CombatBonus.DEFENCE_STAB, 60).bonus(CombatBonus.DEFENCE_SLASH, 80).bonus(CombatBonus.DEFENCE_CRUSH, 100).bonus(CombatBonus.DEFENCE_MAGIC, 80).bonus(CombatBonus.DEFENCE_RANGED, 60).build());
        combat.immunity(NpcCombatImmunity.builder().venom(true).build());
        combat.killCount(NpcCombatKillCount.builder().sendMessage(true).build());
        combat.combatScript("GiantMoleCS").deathAnimation(3310).blockAnimation(3311);
        combat.drop(drop.build());

        var style = NpcCombatStyle.builder();
        style.type(NpcCombatStyleType.melee(CombatBonus.ATTACK_CRUSH));
        style.damage(NpcCombatDamage.maximum(21));
        style.animation(3312).attackSpeed(4);
        style.projectile(NpcCombatProjectile.id(335));
        combat.style(style.build());


        return Arrays.asList(combat.build());
    }
}
