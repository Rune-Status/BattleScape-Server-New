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
import com.palidino.osrs.model.npc.combat.style.NpcCombatStyle;
import com.palidino.osrs.model.npc.combat.style.NpcCombatStyleType;
import com.palidino.osrs.model.npc.combat.style.NpcCombatDamage;
import com.palidino.osrs.model.npc.combat.style.NpcCombatProjectile;
import com.palidino.osrs.model.npc.combatscript.NCombatScript;
import lombok.var;

public class Flambeed149Combat extends NCombatScript {
    @Override
    public List<NpcCombatDefinition> getCombatDefs() {
        var drop = NpcCombatDrop.builder();
        var dropTable = NpcCombatDropTable.builder().chance(NpcCombatDropTable.CHANCE_ALWAYS);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.CAKE, 5)));
        drop.table(dropTable.build());


        var combat = NpcCombatDefinition.builder();
        combat.id(NpcId.FLAMBEED_149);
        combat.hitpoints(NpcCombatHitpoints.total(210));
        combat.stats(NpcCombatStats.builder().attackLevel(120).defenceLevel(75).bonus(CombatBonus.MELEE_ATTACK, 100).bonus(CombatBonus.DEFENCE_STAB, 50).bonus(CombatBonus.DEFENCE_SLASH, 50).bonus(CombatBonus.DEFENCE_CRUSH, 5).bonus(CombatBonus.DEFENCE_MAGIC, 5).bonus(CombatBonus.DEFENCE_RANGED, 50).build());
        combat.aggression(NpcCombatAggression.PLAYERS);
        combat.combatScript("FlambeedCS").deathAnimation(1752).blockAnimation(1751);
        combat.drop(drop.build());

        var style = NpcCombatStyle.builder();
        style.type(NpcCombatStyleType.melee(CombatBonus.ATTACK_CRUSH));
        style.damage(NpcCombatDamage.maximum(22));
        style.animation(1750).attackSpeed(4);
        style.projectile(NpcCombatProjectile.id(335));
        combat.style(style.build());


        return Arrays.asList(combat.build());
    }
}
