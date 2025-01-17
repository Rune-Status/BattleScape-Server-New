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
import com.palidino.osrs.model.npc.combatscript.NCombatScript;
import lombok.var;

public class JalAk165Combat extends NCombatScript {
    @Override
    public List<NpcCombatDefinition> getCombatDefs() {
        var combat = NpcCombatDefinition.builder();
        combat.id(NpcId.JAL_AK_165);
        combat.hitpoints(NpcCombatHitpoints.total(40));
        combat.stats(NpcCombatStats.builder().attackLevel(160).magicLevel(160).rangedLevel(160).defenceLevel(95).bonus(CombatBonus.ATTACK_STAB, 45).bonus(CombatBonus.ATTACK_SLASH, 45).bonus(CombatBonus.ATTACK_CRUSH, 45).bonus(CombatBonus.ATTACK_MAGIC, 45).bonus(CombatBonus.ATTACK_RANGED, 45).bonus(CombatBonus.MELEE_DEFENCE, 25).bonus(CombatBonus.DEFENCE_MAGIC, 25).bonus(CombatBonus.DEFENCE_RANGED, 25).build());
        combat.aggression(NpcCombatAggression.builder().range(8).always(true).sameTarget(true).build());
        combat.immunity(NpcCombatImmunity.builder().venom(true).build());
        combat.combatScript("JalAkCS").deathAnimation(7584).blockAnimation(7585);

        var style = NpcCombatStyle.builder();
        style.type(NpcCombatStyleType.melee(CombatBonus.ATTACK_CRUSH));
        style.damage(NpcCombatDamage.maximum(29));
        style.animation(7587).attackSpeed(6);
        style.projectile(NpcCombatProjectile.id(335));
        combat.style(style.build());

        style = NpcCombatStyle.builder();
        style.type(NpcCombatStyleType.RANGED);
        style.damage(NpcCombatDamage.maximum(29));
        style.animation(7587).attackSpeed(6);
        style.projectile(NpcCombatProjectile.id(335));
        combat.style(style.build());

        style = NpcCombatStyle.builder();
        style.type(NpcCombatStyleType.MAGIC);
        style.damage(NpcCombatDamage.maximum(29));
        style.animation(7587).attackSpeed(6);
        style.projectile(NpcCombatProjectile.id(335));
        combat.style(style.build());


        return Arrays.asList(combat.build());
    }
}
