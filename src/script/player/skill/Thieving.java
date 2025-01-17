package script.player.skill;

import java.util.ArrayList;
import java.util.List;
import com.palidino.osrs.Main;
import com.palidino.osrs.io.cache.ItemId;
import com.palidino.osrs.io.cache.NpcId;
import com.palidino.osrs.model.Hit;
import com.palidino.osrs.model.item.Item;
import com.palidino.osrs.model.item.RandomItem;
import com.palidino.osrs.model.map.MapObject;
import com.palidino.osrs.model.npc.Npc;
import com.palidino.osrs.model.player.Player;
import com.palidino.osrs.model.player.Skills;
import com.palidino.osrs.model.player.skill.SkillContainer;
import com.palidino.osrs.model.player.skill.SkillEntry;
import com.palidino.osrs.model.player.skill.SkillModel;
import com.palidino.osrs.model.player.skill.SkillNpcProtector;
import com.palidino.osrs.model.player.skill.SkillPet;
import com.palidino.osrs.model.player.skill.SkillTemporaryMapObject;
import com.palidino.util.Utils;
import com.palidino.util.event.Event;
import lombok.var;

public class Thieving extends SkillContainer {
    private static List<SkillEntry> entries = new ArrayList<>();

    @Override
    public int getSkillId() {
        return Skills.THIEVING;
    }

    @Override
    public List<SkillEntry> getEntries() {
        return entries;
    }

    @Override
    public int getDefaultMakeAmount() {
        return 1;
    }

    @Override
    public void actionSuccess(Player player, Event event, Npc npc, MapObject mapObject, SkillEntry entry) {
        if (npc != null) {
            player.getGameEncoder().sendMessage("You pick the " + npc.getName() + "'s pocket.");
        } else if (mapObject != null) {
            player.getGameEncoder().sendMessage("You steal from the " + mapObject.getName() + ".");
            setTemporaryMapObject(player, mapObject, entry);
        }
    }

    @Override
    public Item createHook(Player player, Item item, Npc npc, MapObject mapObject, SkillEntry entry) {
        if (player.getEquipment().wearingRogueOutfit() && Utils.randomE(10) == 0) {
            item = new Item(item.getId(), item.getAmount() + 1);
        }
        return item;
    }

    @Override
    public int experienceHook(Player player, int experience, Npc npc, MapObject mapObject, SkillEntry entry) {
        if (player.getEquipment().wearingRogueOutfit()) {
            experience *= 1.1;
        }
        return experience;
    }

    @Override
    public boolean failedActionHook(Player player, Event event, Npc npc, MapObject mapObject, SkillEntry entry) {
        var power = player.getSkills().getLevel(getSkillId()) + 8;
        var failure = entry.getLevel() + 2;
        var chance = 0.0;
        if (power > failure) {
            chance = 1 - (failure + 2) / ((power + 1) * 2.0);
        } else {
            chance = power / ((failure + 1) * 2.0);
        }
        if (player.inArdougne() && player.hasItem(ItemId.ARDOUGNE_CLOAK_2) || player.hasItem(ItemId.ARDOUGNE_CLOAK_3)
                || player.hasItem(ItemId.ARDOUGNE_CLOAK_4) || player.hasItem(ItemId.ARDOUGNE_MAX_CAPE)) {
            chance = Math.min(Utils.addDoubles(chance, 0.1), 1.0);
        }
        if (player.getEquipment().wearingRogueOutfit()) {
            chance = Math.min(Utils.addDoubles(chance, 0.1), 1.0);
        }
        if (player.getEquipment().wearingAccomplishmentCape(getSkillId())) {
            chance = Math.min(Utils.addDoubles(chance, 0.1), 1.0);
        }
        if (player.getGoldMember()) {
            chance = Math.min(Utils.addDoubles(chance, 0.05), 1.0);
        }
        if (player.hasVoted()) {
            chance = Math.min(Utils.addDoubles(chance, 0.05), 1.0);
        }
        if (player.getController().inWilderness()) {
            chance = Math.min(Utils.addDoubles(chance, 0.1), 1.0);
        }
        if (npc != null && Utils.randomI(100) < Math.max(0.01, 1 - chance) * 100) {
            npc.setForceMessage("What do you think you're doing?");
            npc.setAnimation(npc.getDef().getAttackAnimation());
            npc.setFaceTile(player);
            player.setAnimation(player.getCombat().getBlockAnimation());
            player.setGraphic(80, 100);
            player.getGameEncoder().sendMessage("You've been stunned!");
            player.setLock(8);
            return true;
        }
        return false;
    }

    @Override
    public String deathReasonHook(Player player, Event event, Npc npc, MapObject mapObject, SkillEntry entry) {
        if (npc != null) {
            return "pickpocketing a " + npc.getName();
        }
        return "thieving";
    }

    static {
        entries.add(SkillEntry.builder().level(1).experience(8).animation(881).delay(2)
                .npc(new SkillModel(NpcId.MAN_2_3078, 2)).npc(new SkillModel(NpcId.MAN_2_3079, 2))
                .npc(new SkillModel(NpcId.MAN_2_3080, 2)).npc(new SkillModel(NpcId.MAN_2_3081, 2))
                .npc(new SkillModel(NpcId.MAN_2_3082, 2)).npc(new SkillModel(NpcId.WOMAN_2_3083, 2))
                .npc(new SkillModel(NpcId.WOMAN_2_3084, 2)).npc(new SkillModel(NpcId.WOMAN_2_3085, 2))
                .npc(new SkillModel(NpcId.MAN_2_3264, 2)).npc(new SkillModel(NpcId.MAN_2_3265, 2))
                .npc(new SkillModel(NpcId.MAN_2_3266, 2)).npc(new SkillModel(NpcId.WOMAN_2_3267, 2))
                .npc(new SkillModel(NpcId.WOMAN_2_3268, 2)).create(new RandomItem(ItemId.BRONZE_SCIMITAR))
                .pet(new SkillPet(ItemId.ROCKY, 257211)).failedHit(new Hit(1)).build());
        entries.add(SkillEntry.builder().level(25).experience(26).animation(881).delay(2)
                .npc(new SkillModel(NpcId.WARRIOR_WOMAN_24, 2)).npc(new SkillModel(NpcId.AL_KHARID_WARRIOR_9, 2))
                .create(new RandomItem(ItemId.IRON_SCIMITAR)).pet(new SkillPet(ItemId.ROCKY, 225000))
                .failedHit(new Hit(2)).build());
        entries.add(SkillEntry.builder().level(38).experience(43).animation(881).delay(2)
                .npc(new SkillModel(NpcId.MASTER_FARMER, 2)).npc(new SkillModel(NpcId.MASTER_FARMER_3258, 2))
                .npc(new SkillModel(NpcId.MARTIN_THE_MASTER_GARDENER, 2))
                .randomCreate(new RandomItem(ItemId.POTATO_SEED, 1, 4).setWeight(17857))
                .randomCreate(new RandomItem(ItemId.ONION_SEED, 1, 3).setWeight(13386))
                .randomCreate(new RandomItem(ItemId.CABBAGE_SEED, 1, 3).setWeight(6993))
                .randomCreate(new RandomItem(ItemId.TOMATO_SEED, 1, 2).setWeight(6410))
                .randomCreate(new RandomItem(ItemId.SWEETCORN_SEED, 1, 2).setWeight(2232))
                .randomCreate(new RandomItem(ItemId.STRAWBERRY_SEED).setWeight(1212))
                .randomCreate(new RandomItem(ItemId.WATERMELON_SEED).setWeight(534))
                .randomCreate(new RandomItem(ItemId.BARLEY_SEED, 1, 4).setWeight(5555))
                .randomCreate(new RandomItem(ItemId.HAMMERSTONE_SEED, 1, 3).setWeight(5555))
                .randomCreate(new RandomItem(ItemId.ASGARNIAN_SEED, 1, 2).setWeight(4184))
                .randomCreate(new RandomItem(ItemId.JUTE_SEED, 1, 3).setWeight(4149))
                .randomCreate(new RandomItem(ItemId.YANILLIAN_SEED, 1, 4).setWeight(2770))
                .randomCreate(new RandomItem(ItemId.KRANDORIAN_SEED).setWeight(1312))
                .randomCreate(new RandomItem(ItemId.WILDBLOOD_SEED).setWeight(704))
                .randomCreate(new RandomItem(ItemId.MARIGOLD_SEED).setWeight(4587))
                .randomCreate(new RandomItem(ItemId.NASTURTIUM_SEED).setWeight(3039))
                .randomCreate(new RandomItem(ItemId.ROSEMARY_SEED).setWeight(19))
                .randomCreate(new RandomItem(ItemId.WOAD_SEED).setWeight(1451))
                .randomCreate(new RandomItem(ItemId.LIMPWURT_SEED).setWeight(1158))
                .randomCreate(new RandomItem(ItemId.REDBERRY_SEED).setWeight(3875))
                .randomCreate(new RandomItem(ItemId.CADAVABERRY_SEED).setWeight(2717))
                .randomCreate(new RandomItem(ItemId.DWELLBERRY_SEED).setWeight(1941))
                .randomCreate(new RandomItem(ItemId.JANGERBERRY_SEED).setWeight(775))
                .randomCreate(new RandomItem(ItemId.WHITEBERRY_SEED).setWeight(281))
                .randomCreate(new RandomItem(ItemId.POISON_IVY_SEED).setWeight(106))
                .randomCreate(new RandomItem(ItemId.GUAM_SEED).setWeight(6144))
                .randomCreate(new RandomItem(ItemId.MARRENTILL_SEED).setWeight(4184))
                .randomCreate(new RandomItem(ItemId.TARROMIN_SEED).setWeight(2856))
                .randomCreate(new RandomItem(ItemId.HARRALANDER_SEED).setWeight(1940))
                .randomCreate(new RandomItem(ItemId.RANARR_SEED).setWeight(1324))
                .randomCreate(new RandomItem(ItemId.TOADFLAX_SEED).setWeight(900))
                .randomCreate(new RandomItem(ItemId.IRIT_SEED).setWeight(612))
                .randomCreate(new RandomItem(ItemId.AVANTOE_SEED).setWeight(420))
                .randomCreate(new RandomItem(ItemId.KWUARM_SEED).setWeight(284))
                .randomCreate(new RandomItem(ItemId.SNAPDRAGON_SEED).setWeight(192))
                .randomCreate(new RandomItem(ItemId.CADANTINE_SEED).setWeight(132))
                .randomCreate(new RandomItem(ItemId.LANTADYME_SEED).setWeight(92))
                .randomCreate(new RandomItem(ItemId.DWARF_WEED_SEED).setWeight(56))
                .randomCreate(new RandomItem(ItemId.TORSTOL_SEED).setWeight(36))
                .randomCreate(new RandomItem(ItemId.MUSHROOM_SPORE).setWeight(250))
                .randomCreate(new RandomItem(ItemId.BELLADONNA_SEED).setWeight(149))
                .randomCreate(new RandomItem(ItemId.CACTUS_SEED).setWeight(100)).pet(new SkillPet(ItemId.ROCKY, 257211))
                .failedHit(new Hit(2)).build());
        entries.add(SkillEntry.builder().level(40).experience(47).animation(881).delay(2)
                .npc(new SkillModel(NpcId.GUARD_21_3010, 2)).npc(new SkillModel(NpcId.GUARD_21_3094, 2))
                .npc(new SkillModel(NpcId.GUARD_20, 2)).npc(new SkillModel(NpcId.GUARD_21_3269, 2))
                .npc(new SkillModel(NpcId.GUARD_22_3270, 2)).npc(new SkillModel(NpcId.GUARD_19, 2))
                .npc(new SkillModel(NpcId.GUARD_22_3272, 2)).npc(new SkillModel(NpcId.GUARD_22_3273, 2))
                .npc(new SkillModel(NpcId.GUARD_22_3274, 2)).create(new RandomItem(ItemId.BLACK_DAGGER))
                .pet(new SkillPet(ItemId.ROCKY, 200000)).failedHit(new Hit(2)).build());
        entries.add(SkillEntry.builder().level(55).experience(85).animation(881).delay(2)
                .npc(new SkillModel(NpcId.KNIGHT_OF_ARDOUGNE_46, 2))
                .npc(new SkillModel(NpcId.KNIGHT_OF_ARDOUGNE_46_3111, 2))
                .create(new RandomItem(ItemId.MITHRIL_SCIMITAR)).pet(new SkillPet(ItemId.ROCKY, 154625))
                .failedHit(new Hit(3)).build());
        entries.add(SkillEntry.builder().level(70).experience(152).animation(881).delay(2)
                .npc(new SkillModel(NpcId.PALADIN_62, 2)).npc(new SkillModel(NpcId.PALADIN_62_3105, 2))
                .create(new RandomItem(ItemId.MITHRIL_LONGSWORD)).pet(new SkillPet(ItemId.ROCKY, 127056))
                .failedHit(new Hit(3)).build());
        entries.add(SkillEntry.builder().level(80).experience(275).animation(881).delay(2)
                .npc(new SkillModel(NpcId.HERO_69, 2)).create(new RandomItem(ItemId.MITHRIL_FULL_HELM))
                .pet(new SkillPet(ItemId.ROCKY, 99175)).failedHit(new Hit(4)).build());
        entries.add(SkillEntry.builder().level(85).experience(353).animation(881).delay(2)
                .npc(new SkillModel(NpcId.GOREU, 2)).npc(new SkillModel(NpcId.YSGAWYN, 2))
                .npc(new SkillModel(NpcId.ARVEL, 2)).npc(new SkillModel(NpcId.MAWRTH, 2))
                .npc(new SkillModel(NpcId.KELYN, 2)).npc(new SkillModel(NpcId.GOREU, 2))
                .create(new RandomItem(ItemId.BLACK_KITESHIELD)).pet(new SkillPet(ItemId.ROCKY, 99175))
                .failedHit(new Hit(5)).build());
        entries.add(
                SkillEntry.builder().level(1).experience(8).animation(881).delay(6).mapObject(new SkillModel(4874, 1))
                        .create(new RandomItem(ItemId.GOLDEN_NEEDLE)).pet(new SkillPet(ItemId.ROCKY, 257211)).build());
        entries.add(
                SkillEntry.builder().level(20).experience(26).animation(881).delay(6).mapObject(new SkillModel(4875, 1))
                        .create(new RandomItem(ItemId.GOLDEN_POT)).pet(new SkillPet(ItemId.ROCKY, 225000)).build());
        entries.add(SkillEntry.builder().level(40).experience(47).animation(881).delay(6)
                .mapObject(new SkillModel(4876, 1)).create(new RandomItem(ItemId.GOLDEN_TINDERBOX))
                .pet(new SkillPet(ItemId.ROCKY, 200000)).build());
        entries.add(
                SkillEntry.builder().level(60).experience(85).animation(881).delay(6).mapObject(new SkillModel(4877, 1))
                        .create(new RandomItem(ItemId.GOLDEN_CANDLE)).pet(new SkillPet(ItemId.ROCKY, 154625)).build());
        entries.add(SkillEntry.builder().level(80).experience(152).animation(881).delay(6)
                .mapObject(new SkillModel(4878, 1)).create(new RandomItem(ItemId.GOLDEN_HAMMER))
                .pet(new SkillPet(ItemId.ROCKY, 127056)).build());
        entries.add(SkillEntry.builder().level(84).experience(100).animation(881).delay(6)
                .mapObject(new SkillModel(26757, 1))
                .create(new RandomItem(Main.isSpawn() ? ItemId.COINS : ItemId.BLOOD_MONEY, 10, 50))
                .randomCreate(new RandomItem(ItemId.DRAGONSTONE).setWeight(1))
                .randomCreate(new RandomItem(ItemId.RUNE_SCIMITAR).setWeight(31))
                .temporaryMapObject(new SkillTemporaryMapObject(26758, 50, 0))
                .npcProtector(new SkillNpcProtector(NpcId.ROGUE_135, 2, "Someone's stealing from us, get them!"))
                .build());
    }
}
