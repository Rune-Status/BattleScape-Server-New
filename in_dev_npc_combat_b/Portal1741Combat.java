package script.npc.combat;

import java.util.Arrays;
import java.util.List;
import com.palidino.osrs.io.cache.NpcId;
import com.palidino.osrs.model.npc.combat.NpcCombatDefinition;
import com.palidino.osrs.model.npc.combat.NpcCombatSpawn;
import com.palidino.osrs.model.npc.combat.NpcCombatHitpoints;
import com.palidino.osrs.model.npc.combat.NpcCombatImmunity;
import com.palidino.osrs.model.npc.combat.NpcCombatFocus;
import com.palidino.osrs.model.npc.combatscript.NCombatScript;
import lombok.var;

public class Portal1741Combat extends NCombatScript {
    @Override
    public List<NpcCombatDefinition> getCombatDefs() {
        var combat = NpcCombatDefinition.builder();
        combat.id(NpcId.PORTAL_1741);
        combat.spawn(NpcCombatSpawn.builder().respawnDelay(500).build());
        combat.hitpoints(NpcCombatHitpoints.total(250));
        combat.immunity(NpcCombatImmunity.builder().bind(true).build());
        combat.focus(NpcCombatFocus.builder().retaliationDisabled(true).build());
        combat.combatScript("PestControlCS");


        return Arrays.asList(combat.build());
    }
}
