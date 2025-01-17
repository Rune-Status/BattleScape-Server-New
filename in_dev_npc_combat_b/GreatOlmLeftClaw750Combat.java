package script.npc.combat;

import java.util.Arrays;
import java.util.List;
import com.palidino.osrs.io.cache.NpcId;
import com.palidino.osrs.model.npc.combat.NpcCombatDefinition;
import com.palidino.osrs.model.npc.combat.NpcCombatHitpoints;
import com.palidino.osrs.model.HitpointsBar;
import com.palidino.osrs.model.npc.combat.NpcCombatStats;
import com.palidino.osrs.model.CombatBonus;
import com.palidino.osrs.model.npc.combat.NpcCombatFocus;
import com.palidino.osrs.model.npc.combatscript.NCombatScript;
import lombok.var;

public class GreatOlmLeftClaw750Combat extends NCombatScript {
    @Override
    public List<NpcCombatDefinition> getCombatDefs() {
        var combat = NpcCombatDefinition.builder();
        combat.id(NpcId.GREAT_OLM_LEFT_CLAW_750);
        combat.hitpoints(NpcCombatHitpoints.builder().total(500).bar(HitpointsBar.GREEN_RED_100).build());
        combat.stats(NpcCombatStats.builder().attackLevel(250).magicLevel(175).rangedLevel(250).defenceLevel(175).bonus(CombatBonus.ATTACK_MAGIC, 60).bonus(CombatBonus.ATTACK_RANGED, 60).bonus(CombatBonus.MELEE_DEFENCE, 50).bonus(CombatBonus.DEFENCE_MAGIC, 50).bonus(CombatBonus.DEFENCE_RANGED, 50).build());
        combat.focus(NpcCombatFocus.builder().retaliationDisabled(true).build());
        combat.combatScript("greatolm");


        return Arrays.asList(combat.build());
    }
}
