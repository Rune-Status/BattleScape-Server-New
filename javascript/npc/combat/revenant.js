var ANCIENT_WARRIOR_DROP_TABLE = [
    new RandomItem(ItemId.VESTAS_LONGSWORD_32254, 1),
    new RandomItem(ItemId.STATIUSS_WARHAMMER_32256, 1),
    new RandomItem(ItemId.VESTAS_SPEAR_32258, 1),
    new RandomItem(ItemId.MORRIGANS_JAVELIN_32260, 50),
    new RandomItem(ItemId.MORRIGANS_THROWING_AXE_32261, 50),
    new RandomItem(ItemId.ZURIELS_STAFF_32262, 1)
];
var ANCIENT_WARRIOR_DROP_TABLE_SPAWN = [
    new RandomItem(ItemId.VESTAS_LONGSWORD, 1),
    new RandomItem(ItemId.STATIUSS_WARHAMMER, 1),
    new RandomItem(ItemId.VESTAS_SPEAR, 1),
    new RandomItem(ItemId.MORRIGANS_JAVELIN, 50),
    new RandomItem(ItemId.MORRIGANS_THROWING_AXE, 50),
    new RandomItem(ItemId.ZURIELS_STAFF, 1)
];
var UNIQUE_DROP_TABLE = [
    new RandomItem(ItemId.VIGGORAS_CHAINMACE_U, 1).setWeight(1),
    new RandomItem(ItemId.CRAWS_BOW_U, 1).setWeight(1),
    new RandomItem(ItemId.THAMMARONS_SCEPTRE_U, 1).setWeight(1),
    new RandomItem(ItemId.AMULET_OF_AVARICE, 1).setWeight(2)
];
var MEDIOCRE_DROP_TABLE = [
    new RandomItem(ItemId.DRAGON_PLATELEGS, 1).setWeight(1),
    new RandomItem(ItemId.DRAGON_PLATESKIRT, 1).setWeight(1),
    new RandomItem(ItemId.RUNE_FULL_HELM, 1).setWeight(2),
    new RandomItem(ItemId.RUNE_PLATEBODY, 1).setWeight(2),
    new RandomItem(ItemId.RUNE_PLATELEGS, 1).setWeight(2),
    new RandomItem(ItemId.RUNE_KITESHIELD, 1).setWeight(2),
    new RandomItem(ItemId.RUNE_WARHAMMER, 1).setWeight(2),
    new RandomItem(ItemId.DRAGON_LONGSWORD, 1).setWeight(1),
    new RandomItem(ItemId.DRAGON_DAGGER, 1).setWeight(1),
    new RandomItem(ItemId.SUPER_RESTORE_4_NOTED, 3, 5).setWeight(4),
    new RandomItem(ItemId.ONYX_BOLT_TIPS, 5, 10).setWeight(4),
    new RandomItem(ItemId.DRAGONSTONE_BOLT_TIPS, 40, 70).setWeight(4),
    new RandomItem(ItemId.UNCUT_DRAGONSTONE_NOTED, 5, 7).setWeight(1),
    new RandomItem(ItemId.DEATH_RUNE, 60, 100).setWeight(3),
    new RandomItem(ItemId.BLOOD_RUNE, 60, 100).setWeight(3),
    new RandomItem(ItemId.LAW_RUNE, 80, 120).setWeight(3),
    new RandomItem(ItemId.RUNITE_ORE_NOTED, 3, 6).setWeight(6),
    new RandomItem(ItemId.ADAMANTITE_BAR_NOTED, 8, 12).setWeight(6),
    new RandomItem(ItemId.COAL_NOTED, 50, 100).setWeight(6),
    new RandomItem(ItemId.BATTLESTAFF_NOTED, 3).setWeight(5),
    new RandomItem(ItemId.BLACK_DRAGONHIDE_NOTED, 10, 15).setWeight(6),
    new RandomItem(ItemId.MAHOGANY_PLANK_NOTED, 15, 25).setWeight(5),
    new RandomItem(ItemId.MAGIC_LOGS_NOTED, 15, 25).setWeight(2),
    new RandomItem(ItemId.YEW_LOGS_NOTED, 60, 100).setWeight(3),
    new RandomItem(ItemId.MANTA_RAY_NOTED, 30, 50).setWeight(3),
    new RandomItem(ItemId.RUNITE_BAR_NOTED, 3, 5).setWeight(6),
    new RandomItem(ItemId.REVENANT_CAVE_TELEPORT, 1).setWeight(7),
    new RandomItem(ItemId.BRACELET_OF_ETHEREUM_UNCHARGED, 1).setWeight(15),
];

var npc = null;

cs = new NCombatScript() {
    setNpcHook: function(n) {
        npc = n;
    },

    tick: function() {
        if (!npc.isLocked() && npc.getHitpoints() < npc.getMaxHitpoints() / 2 && npc.getHitDelay() == 0
                && Utils.randomE(4) == 0) {
            npc.adjustHitpoints(npc.getMaxHitpoints() * 0.2, 0);
            npc.setHitDelay(npc.getHitDelay() + 2);
            npc.setGraphic(1221);
        }
    },

    damageInflictedHook: function(combatStyle, damage, entity) {
        if (entity instanceof Player) {
            if (entity.getCharges().degradeItems(false, ItemId.BRACELET_OF_ETHEREUM, false)) {
                damage = 0;
            }
        }
        return damage;
    },

    canBeAggressiveHook: function(entity) {
        return !(entity instanceof Player) || entity.getEquipment().getHandId() != ItemId.BRACELET_OF_ETHEREUM;
    },

    dropItemHook: function(player, dropTile, dropForIndex, hasRoWICharge) {
        var item = null;
        var logDrop = false;
        var clampedLevel = Math.min(Math.max(1, npc.getDef().getCombatLevel()), 144);
        var chanceA = 2200 / Math.sqrt(clampedLevel);
        var chanceB = 15 + (Math.pow(npc.getDef().getCombatLevel() + 60, 2) / 200);
        var multiplier = Main.isSpawn() ? 8 : 4;
        chanceA = chanceA / multiplier / player.getCombat().getDropRateMultiplier(-1, npc.getDef());
        var selectedChanceA = Utils.randomE(chanceA);
        if (selectedChanceA == 1) {
            logDrop = true;
            var roll = Utils.randomI(player.getCombat().getPKSkullDelay() > 0 ? 13 : 39);
            if (roll == 0) {
                item = RandomItem.getItem(UNIQUE_DROP_TABLE);
            } else if (roll == 1) {
                item = new Item(ItemId.ANCIENT_RELIC, 1);
            } else if (roll == 2) {
                item = new Item(ItemId.ANCIENT_EFFIGY, 1);
            } else if (roll >= 3 && roll <= 4) {
                item = new Item(ItemId.ANCIENT_MEDALLION, 1);
            } else if (roll >= 5 && roll <= 8) {
                item = new Item(ItemId.ANCIENT_STATUETTE, 1);
            } else if (roll >= 9 && roll <= 12) {
                item = new Item(ItemId.MAGIC_SEED, 5 + Utils.randomI(4));
            } else if (roll >= 13 && roll <= 15) {
                item = new Item(ItemId.ANCIENT_CRYSTAL, 1);
            } else if (roll >= 16 && roll <= 20) {
                item = new Item(ItemId.ANCIENT_TOTEM, 1);
            } else if (roll >= 21 && roll <= 26) {
                item = new Item(ItemId.ANCIENT_EMBLEM, 1);
            } else if (roll >= 27 && roll <= 39) {
                item = new Item(ItemId.DRAGON_MED_HELM, 1);
            }
        } else if (selectedChanceA < chanceB) {
            item = RandomItem.getItem(MEDIOCRE_DROP_TABLE);
        } else if (selectedChanceA < 3000) {
            item = new Item(ItemId.COINS, 10000 + Utils.randomI(90000));
        }
        if (Main.isSpawn()) {
            if (Utils.inRange(1, 108 * 50)) {
                npc.getController().addMapItem(new Item(ItemId.DIAMOND_KEY_32309), dropTile, player);
            } else if (Utils.inRange(1, 36 * 50)) {
                npc.getController().addMapItem(new Item(ItemId.GOLD_KEY_32308), dropTile, player);
            } else if (Utils.inRange(1, 12 * 50)) {
                npc.getController().addMapItem(new Item(ItemId.SILVER_KEY_32307), dropTile, player);
            } else if (Utils.inRange(1, 4 * 50)) {
                npc.getController().addMapItem(new Item(ItemId.BRONZE_KEY_32306), dropTile, player);
            }
        }
        if (item != null) {
            npc.getController().addMapItem(item, dropTile, player);
            if (logDrop) {
                player.getCombat().logNPCItem(npc.getDef().getKillCountName(), item.getId(), item.getAmount());
                npc.getWorld().sendRevenantCavesMessage("<col=005500>" + player.getUsername()
                        + " received a drop: " + (item.getAmount() > 1 ? item.getAmount() + " x " : "")
                        + item.getName());
            }
        }
        if (Utils.randomE(32768 / Math.sqrt(clampedLevel)) == 0) {
            var pvpItem = RandomItem.getItem(Main.isSpawn() ? ANCIENT_WARRIOR_DROP_TABLE_SPAWN
                    : ANCIENT_WARRIOR_DROP_TABLE);
            npc.getController().addMapItem(pvpItem, dropTile, player);
            player.getCombat().logNPCItem(npc.getDef().getKillCountName(), pvpItem.getId(), pvpItem.getAmount());
            npc.getWorld().sendItemDropNews(player, pvpItem.getId(), " a revenant");
        }
        var etherCount = (1 + Utils.randomE(Math.sqrt(clampedLevel))) * 2;
        if (player.getCharges().getEthereumAutoAbsorb()
                && (player.getEquipment().getHandId() == ItemId.BRACELET_OF_ETHEREUM
                || player.getEquipment().getHandId() == ItemId.BRACELET_OF_ETHEREUM_UNCHARGED)) {
            etherCount -= player.getCharges().charge(ItemId.BRACELET_OF_ETHEREUM,
                    Equipment.Slot.HAND.ordinal() + 65536, etherCount, new Item(ItemId.REVENANT_ETHER, 1), 1);
        }
        var globalItem = NpcDef.getRandomGlobalDrop();
        if (globalItem != null) {
            npc.getController().addMapItem(globalItem, dropTile, player);
        }
        if (etherCount > 0) {
            npc.getController().addMapItem(new Item(ItemId.REVENANT_ETHER, etherCount), dropTile, player);
        }
    }
};
