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
import com.palidino.osrs.model.npc.combat.style.NpcCombatStyle;
import com.palidino.osrs.model.npc.combat.style.NpcCombatStyleType;
import com.palidino.osrs.model.npc.combat.style.NpcCombatDamage;
import com.palidino.osrs.model.npc.combat.style.NpcCombatProjectile;
import com.palidino.osrs.model.npc.combatscript.NCombatScript;
import lombok.var;

public class LizardmanShamanCombat extends NCombatScript {
    @Override
    public List<NpcCombatDefinition> getCombatDefs() {
        var drop = NpcCombatDrop.builder();
        var dropTable = NpcCombatDropTable.builder().chance(NpcCombatDropTable.CHANCE_ALWAYS);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.BIG_BONES)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.BUCHU_SEED, 8, 12)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GOLPAR_SEED, 8, 12)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.NOXIFER_SEED, 8, 12)));
        drop.table(dropTable.build());


        var combat = NpcCombatDefinition.builder();
        combat.id(NpcId.LIZARDMAN_SHAMAN);
        combat.hitpoints(NpcCombatHitpoints.total(150));
        combat.stats(NpcCombatStats.builder().attackLevel(130).magicLevel(130).rangedLevel(130).defenceLevel(210).bonus(CombatBonus.MELEE_ATTACK, 58).bonus(CombatBonus.ATTACK_RANGED, 56).bonus(CombatBonus.DEFENCE_STAB, 102).bonus(CombatBonus.DEFENCE_SLASH, 160).bonus(CombatBonus.DEFENCE_CRUSH, 150).bonus(CombatBonus.DEFENCE_MAGIC, 160).build());
        combat.aggression(NpcCombatAggression.builder().range(6).always(true).build());
        combat.immunity(NpcCombatImmunity.builder().poison(true).venom(true).build());
        combat.combatScript("LizardmanShamanCS").deathAnimation(7196).blockAnimation(7194);
        combat.drop(drop.build());

        var style = NpcCombatStyle.builder();
        style.type(NpcCombatStyleType.melee(CombatBonus.ATTACK_CRUSH));
        style.damage(NpcCombatDamage.maximum(31));
        style.animation(7158).attackSpeed(4);
        style.projectile(NpcCombatProjectile.id(335));
        combat.style(style.build());

        style = NpcCombatStyle.builder();
        style.type(NpcCombatStyleType.RANGED);
        style.damage(NpcCombatDamage.maximum(31));
        style.animation(7193).attackSpeed(4).attackRange(9);
        style.projectile(NpcCombatProjectile.id(335));
        combat.style(style.build());


        return Arrays.asList(combat.build());
    }
}
