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
import com.palidino.osrs.model.npc.combat.NpcCombatImmunity;
import com.palidino.osrs.model.npc.combat.NpcCombatFocus;
import com.palidino.osrs.model.npc.combat.NpcCombatKillCount;
import com.palidino.osrs.model.npc.combat.style.NpcCombatStyle;
import com.palidino.osrs.model.npc.combat.style.NpcCombatStyleType;
import com.palidino.osrs.model.npc.combat.style.NpcCombatDamage;
import com.palidino.osrs.model.npc.combat.style.NpcCombatProjectile;
import com.palidino.osrs.model.npc.combat.style.NpcCombatEffect;
import com.palidino.osrs.model.Graphic;
import com.palidino.osrs.model.npc.combatscript.NCombatScript;
import lombok.var;

public class Venenatis464Combat extends NCombatScript {
    @Override
    public List<NpcCombatDefinition> getCombatDefs() {
        var drop = NpcCombatDrop.builder();
        var dropTable = NpcCombatDropTable.builder().chance(0.05).log(true);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.VENENATIS_SPIDERLING)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(0.29).log(true);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.TREASONOUS_RING)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(0.58).log(true);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.DRAGON_2H_SWORD)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(0.87).log(true);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.DRAGON_PICKAXE)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(1.0);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.CLUE_SCROLL_ELITE)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(1.2).broadcast(true).log(true);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.VESTAS_LONGSWORD_32254)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.STATIUSS_WARHAMMER_32256)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.VESTAS_SPEAR_32258)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.MORRIGANS_JAVELIN_32260, 50)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.MORRIGANS_THROWING_AXE_32261, 50)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.ZURIELS_STAFF_32262)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(NpcCombatDropTable.CHANCE_RARE);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.YEW_SEED)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.MAGIC_SEED)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.PALM_TREE_SEED)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRIMY_SNAPDRAGON_NOTED, 100)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.DARK_FISHING_BAIT, 375)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.MAGIC_LOGS_NOTED, 100)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.LIMPWURT_ROOT_NOTED, 50)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.UNCUT_DRAGONSTONE)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.RED_SPIDERS_EGGS_NOTED, 500)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(NpcCombatDropTable.CHANCE_UNCOMMON);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.DIAMOND_BOLTS_E, 100)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.RUNE_2H_SWORD)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.RUNE_KNIFE, 60)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.SUPERCOMPOST_NOTED, 100)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.UNICORN_HORN_NOTED, 100)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GOLD_ORE_NOTED, 300)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.CANNONBALL, 250)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.ANTIDOTE_PLUS_PLUS_4_NOTED, 10)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.ONYX_BOLT_TIPS, 60)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GRIMY_TORSTOL_NOTED, 1, 5)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(NpcCombatDropTable.CHANCE_COMMON);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.RUNE_PICKAXE)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.CHAOS_RUNE, 400)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.DEATH_RUNE, 300)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.BLOOD_RUNE, 200)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.UNCUT_RUBY_NOTED, 20)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.UNCUT_DIAMOND_NOTED, 10)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.DARK_CRAB_NOTED, 8)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.SUPER_RESTORE_4, 3)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.COINS, 15000, 20000)));
        drop.table(dropTable.build());


        var combat = NpcCombatDefinition.builder();
        combat.id(NpcId.VENENATIS_464);
        combat.hitpoints(NpcCombatHitpoints.total(255));
        combat.stats(NpcCombatStats.builder().attackLevel(470).magicLevel(150).defenceLevel(490).bonus(CombatBonus.MELEE_DEFENCE, 260).bonus(CombatBonus.DEFENCE_MAGIC, 850).bonus(CombatBonus.DEFENCE_RANGED, 100).build());
        combat.aggression(NpcCombatAggression.builder().range(8).build());
        combat.immunity(NpcCombatImmunity.builder().poison(true).venom(true).build());
        combat.focus(NpcCombatFocus.builder().keepWithinCombatTiles(1).singleTargetFocus(true).build());
        combat.killCount(NpcCombatKillCount.builder().sendMessage(true).build());
        combat.combatScript("VenenatisCS").deathAnimation(5321).blockAnimation(5320);
        combat.drop(drop.build());

        var style = NpcCombatStyle.builder();
        style.type(NpcCombatStyleType.melee(CombatBonus.ATTACK_STAB));
        style.damage(NpcCombatDamage.maximum(49));
        style.animation(5319).attackSpeed(4);
        style.projectile(NpcCombatProjectile.id(335));
        style.effect(NpcCombatEffect.builder().poison(8).build());
        combat.style(style.build());

        style = NpcCombatStyle.builder();
        style.type(NpcCombatStyleType.MAGIC);
        style.damage(NpcCombatDamage.maximum(49));
        style.animation(5330).attackSpeed(4);
        style.castGraphic(new Graphic(164, 92)).targetGraphic(new Graphic(166, 124));
        style.projectile(NpcCombatProjectile.id(335));
        style.effect(NpcCombatEffect.builder().poison(8).build());
        style.multiTarget(true);
        combat.style(style.build());


        return Arrays.asList(combat.build());
    }
}
