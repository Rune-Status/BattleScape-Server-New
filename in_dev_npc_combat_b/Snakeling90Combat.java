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
import com.palidino.osrs.model.npc.combat.NpcCombatFocus;
import com.palidino.osrs.model.npc.combat.style.NpcCombatStyle;
import com.palidino.osrs.model.npc.combat.style.NpcCombatStyleType;
import com.palidino.osrs.model.npc.combat.style.NpcCombatDamage;
import com.palidino.osrs.model.npc.combat.style.NpcCombatProjectile;
import com.palidino.osrs.model.npc.combat.style.NpcCombatEffect;
import com.palidino.osrs.model.npc.combatscript.NCombatScript;
import lombok.var;

public class Snakeling90Combat extends NCombatScript {
    @Override
    public List<NpcCombatDefinition> getCombatDefs() {
        var combat = NpcCombatDefinition.builder();
        combat.id(NpcId.SNAKELING_90);
        combat.hitpoints(NpcCombatHitpoints.total(1));
        combat.stats(NpcCombatStats.builder().attackLevel(140).bonus(CombatBonus.MELEE_ATTACK, 120).bonus(CombatBonus.ATTACK_MAGIC, 120).bonus(CombatBonus.MELEE_DEFENCE, -40).bonus(CombatBonus.DEFENCE_MAGIC, -40).bonus(CombatBonus.DEFENCE_RANGED, -40).build());
        combat.aggression(NpcCombatAggression.builder().range(20).build());
        combat.immunity(NpcCombatImmunity.builder().poison(true).venom(true).build());
        combat.focus(NpcCombatFocus.builder().meleeUnlessUnreachable(true).bypassMapObjects(true).build());
        combat.deathAnimation(2408).blockAnimation(1742);

        var style = NpcCombatStyle.builder();
        style.type(NpcCombatStyleType.melee(CombatBonus.ATTACK_STAB));
        style.damage(NpcCombatDamage.maximum(15));
        style.animation(1741).attackSpeed(4);
        style.projectile(NpcCombatProjectile.id(335));
        style.effect(NpcCombatEffect.builder().venom(6).build());
        combat.style(style.build());

        style = NpcCombatStyle.builder();
        style.type(NpcCombatStyleType.MAGIC);
        style.damage(NpcCombatDamage.maximum(15));
        style.animation(1741).attackSpeed(4).attackRange(3);
        style.projectile(NpcCombatProjectile.id(335));
        style.effect(NpcCombatEffect.builder().venom(6).build());
        combat.style(style.build());


        return Arrays.asList(combat.build());
    }
}
