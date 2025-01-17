package script.npc.combat;

import java.util.Arrays;
import java.util.List;
import com.palidino.osrs.io.cache.ItemId;
import com.palidino.osrs.io.cache.NpcId;
import com.palidino.osrs.model.CombatBonus;
import com.palidino.osrs.model.item.RandomItem;
import com.palidino.osrs.model.npc.combat.NpcCombatDefinition;
import com.palidino.osrs.model.npc.combat.NpcCombatDrop;
import com.palidino.osrs.model.npc.combat.NpcCombatDropTable;
import com.palidino.osrs.model.npc.combat.NpcCombatDropTableDrop;
import com.palidino.osrs.model.npc.combat.NpcCombatStats;
import com.palidino.osrs.model.npc.combat.style.NpcCombatDamage;
import com.palidino.osrs.model.npc.combat.style.NpcCombatProjectile;
import com.palidino.osrs.model.npc.combat.style.NpcCombatStyle;
import com.palidino.osrs.model.npc.combatscript.NCombatScript;
import lombok.var;

public class HeroCombat extends NCombatScript {
    @Override
    public List<NpcCombatDefinition> getCombatDefs() {
        var drop = NpcCombatDrop.builder();
        var dropTable = NpcCombatDropTable.builder().chance(NpcCombatDropTable.CHANCE_UNCOMMON);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.DEATH_RUNE, 2)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.BLOOD_RUNE)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.GOLD_ORE)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.JUG_OF_WINE)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.FIRE_ORB)));
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.DIAMOND)));
        drop.table(dropTable.build());
        dropTable = NpcCombatDropTable.builder().chance(NpcCombatDropTable.CHANCE_ALWAYS);
        dropTable.drop(NpcCombatDropTableDrop.items(new RandomItem(ItemId.BONES)));
        drop.table(dropTable.build());


        var combat = NpcCombatDefinition.builder();
        combat.id(NpcId.HERO_69);
        combat.stats(NpcCombatStats.builder().attackLevel(54).defenceLevel(54).bonus(CombatBonus.MELEE_ATTACK, 20)
                .bonus(CombatBonus.DEFENCE_STAB, 87).bonus(CombatBonus.DEFENCE_SLASH, 84)
                .bonus(CombatBonus.DEFENCE_CRUSH, 76).bonus(CombatBonus.DEFENCE_MAGIC, -10)
                .bonus(CombatBonus.DEFENCE_RANGED, 79).build());
        combat.drop(drop.build());

        var style = NpcCombatStyle.builder();
        style.damage(NpcCombatDamage.maximum(10));
        style.animation(451).attackSpeed(5);
        style.projectile(NpcCombatProjectile.id(335));
        combat.style(style.build());


        return Arrays.asList(combat.build());
    }
}
