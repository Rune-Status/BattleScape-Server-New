var entries = new ArrayList();
var title = "";
var lines = new ArrayList();
var actions = new ArrayList();

title = "Select an Option";
lines.add("View Shop");
actions.add("close|script");
lines.add("Exchange Mysterious Emblems");
actions.add("close|script");
lines.add("Options");
actions.add("dialogue=wilderness,1");
var obj0 = new DialogueEntry();
entries.add(obj0);
obj0.setSelection(title, Utils.toStringArray(lines, true), Utils.toStringArray(actions, true));

title = "Select an Option";
lines.add("Exchange Ancient Emblems");
actions.add("close|script");
lines.add("Nevermind");
actions.add("close");
var obj1 = new DialogueEntry();
entries.add(obj1);
obj1.setSelection(title, Utils.toStringArray(lines, true), Utils.toStringArray(actions, true));

instance = new DialogueScript() {
    execute: function(player, index, childId, slot) {
        if (player.isLocked()) {
            return;
        }
        if (index == 0) {
            if (slot == 0) {
                player.openShop("blood_money");
            } else if (slot == 1) {
                for (var i = 0; i < player.getInventory().size(); i++) {
                    var itemId = player.getInventory().getId(i);
                    var coinValue = BountyHunter.MysteriousEmblem.getValue(itemId);
                    if (itemId == ItemId.MYSTERIOUS_EMBLEM_NOTED || coinValue == 0) {
                        continue;
                    }
                    var bloodMoneyValue = BountyHunter.MysteriousEmblem.getBloodValue(itemId);
                    var inventoryAmount = player.getInventory().getAmount(i);
                    player.getInventory().deleteItem(itemId, inventoryAmount, i);
                    player.getInventory().addOrDropItem(ItemId.COINS, inventoryAmount * coinValue);
                    if (Main.isEconomy()) {
                        player.getInventory().addOrDropItem(ItemId.BLOOD_MONEY, inventoryAmount * bloodMoneyValue);
                    }
                    if (itemId == ItemId.MYSTERIOUS_EMBLEM_TIER_10) {
                        player.getInventory().addOrDropItem(ItemId.BLOODY_KEY_32304, inventoryAmount);
                    }
                }
            }
        } else if (index == 1) {
            if (slot == 0) {
                for (var i = 0; i < player.getInventory().size(); i++) {
                    var id = player.getInventory().getId(i);
                    var value = 0;
                    if (id == ItemId.ANCIENT_EMBLEM) {
                        value = 500000;
                    } else if (id == ItemId.ANCIENT_TOTEM) {
                        value = 1000000;
                    } else if (id == ItemId.ANCIENT_STATUETTE) {
                        value = 2000000;
                    } else if (id == ItemId.ANCIENT_MEDALLION) {
                        value = 4000000;
                    } else if (id == ItemId.ANCIENT_EFFIGY) {
                        value = 8000000;
                    } else if (id == ItemId.ANCIENT_RELIC) {
                        value = 16000000;
                    }
                    if (value == 0) {
                        continue;
                    }
                    var amount = player.getInventory().getAmount(i);
                    var toAmount = amount * value;
                    if (player.getInventory().canAddItem(ItemId.COINS, toAmount)) {
                        player.getInventory().deleteItem(id, amount, i);
                        player.getInventory().addItem(ItemId.COINS, toAmount);
                    }
                }
            }
        }
    },

    getDialogueEntries: function() {
        return entries;
    }
}
