package script.npc.combat;

import java.util.Arrays;
import java.util.List;
import com.palidino.osrs.io.cache.NpcId;
import com.palidino.osrs.model.npc.combat.NpcCombatDefinition;
import com.palidino.osrs.model.npc.combat.NpcCombatHitpoints;
import com.palidino.osrs.model.npc.combat.NpcCombatStats;
import com.palidino.osrs.model.CombatBonus;
import com.palidino.osrs.model.npc.combat.NpcCombatAggression;
import com.palidino.osrs.model.npc.combat.NpcCombatImmunity;
import com.palidino.osrs.model.npc.combat.style.NpcCombatStyle;
import com.palidino.osrs.model.npc.combat.style.NpcCombatStyleType;
import com.palidino.osrs.model.npc.combat.style.NpcCombatDamage;
import com.palidino.osrs.model.npc.combat.style.NpcCombatProjectile;
import com.palidino.osrs.model.npc.combat.style.NpcCombatEffect;
import com.palidino.osrs.model.npc.combatscript.NCombatScript;
import lombok.var;

public class JalMejrah85Combat extends NCombatScript {
    @Override
    public List<NpcCombatDefinition> getCombatDefs() {
        var combat = NpcCombatDefinition.builder();
        combat.id(NpcId.JAL_MEJRAH_85);
        combat.hitpoints(NpcCombatHitpoints.total(25));
        combat.stats(NpcCombatStats.builder().magicLevel(120).rangedLevel(120).defenceLevel(55).bonus(CombatBonus.ATTACK_RANGED, 30).bonus(CombatBonus.MELEE_DEFENCE, 30).bonus(CombatBonus.DEFENCE_MAGIC, -20).bonus(CombatBonus.DEFENCE_RANGED, 45).build());
        combat.aggression(NpcCombatAggression.builder().range(8).always(true).sameTarget(true).build());
        combat.immunity(NpcCombatImmunity.builder().venom(true).build());
        combat.deathAnimation(7580).blockAnimation(7579);

        var style = NpcCombatStyle.builder();
        style.type(NpcCombatStyleType.RANGED);
        style.damage(NpcCombatDamage.maximum(19));
        style.animation(7578).attackSpeed(3).attackRange(4);
        style.projectile(NpcCombatProjectile.id(335));
        style.effect(NpcCombatEffect.builder().runDrain(3).includeMiss(true).build());
        combat.style(style.build());


        return Arrays.asList(combat.build());
    }
}
