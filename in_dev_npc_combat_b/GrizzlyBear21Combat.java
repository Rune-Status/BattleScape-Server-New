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

public class GrizzlyBear21Combat extends NCombatScript {
    @Override
    public List<NpcCombatDefinition> getCombatDefs() {
        var drop = NpcCombatDrop.builder();
        var dropTable = NpcCombatDropTable.builder().chance(4.0);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.ENSOULED_BEAR_HEAD_13463)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(NpcCombatDropTable.CHANCE_COMMON);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.BEAR_RIBS)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(NpcCombatDropTable.CHANCE_ALWAYS);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.BONES)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.BEAR_FUR)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.RAW_BEAR_MEAT)));
        drop.table(dropTable.build());


        var combat = NpcCombatDefinition.builder();
        combat.id(NpcId.GRIZZLY_BEAR_21);
        combat.hitpoints(NpcCombatHitpoints.total(27));
        combat.stats(NpcCombatStats.builder().attackLevel(17).defenceLevel(15).bonus(CombatBonus.ATTACK_STAB, 1).bonus(CombatBonus.ATTACK_SLASH, 1).bonus(CombatBonus.ATTACK_CRUSH, 1).bonus(CombatBonus.ATTACK_MAGIC, 1).bonus(CombatBonus.ATTACK_RANGED, 1).bonus(CombatBonus.DEFENCE_SLASH, 1).bonus(CombatBonus.DEFENCE_CRUSH, 1).bonus(CombatBonus.DEFENCE_MAGIC, 1).bonus(CombatBonus.DEFENCE_RANGED, 1).build());
        combat.aggression(NpcCombatAggression.PLAYERS);
        combat.deathAnimation(4929).blockAnimation(4927);
        combat.drop(drop.build());

        var style = NpcCombatStyle.builder();
        style.type(NpcCombatStyleType.melee(CombatBonus.ATTACK_SLASH));
        style.damage(NpcCombatDamage.maximum(3));
        style.animation(4925).attackSpeed(4);
        style.projectile(NpcCombatProjectile.id(335));
        combat.style(style.build());


        return Arrays.asList(combat.build());
    }
}
