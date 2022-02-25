package io.github.domsim1.mc.mayhem.event;

import io.github.domsim1.mc.mayhem.Mayhem;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;

import java.util.HashMap;

public class MayhemLootTableExtension {
    private static final HashMap<Identifier, Identifier> LOOT_TABLE_MAP = new HashMap<>();

    private MayhemLootTableExtension() { }

    public static void register() {
        register(EntityType.VILLAGER.getLootTableId(), "fresh_flesh_on_death");
        register(EntityType.PILLAGER.getLootTableId(), "fresh_flesh_on_death");
        register(EntityType.WITCH.getLootTableId(), "fresh_flesh_on_death");
        register(EntityType.VINDICATOR.getLootTableId(), "fresh_flesh_on_death");
        register(EntityType.WANDERING_TRADER.getLootTableId(), "fresh_flesh_on_death");
        register(EntityType.EVOKER.getLootTableId(), "fresh_flesh_on_death");
        register(EntityType.ILLUSIONER.getLootTableId(), "fresh_flesh_on_death");
        register(EntityType.HORSE.getLootTableId(), "entities/horse");
        register(EntityType.PIGLIN.getLootTableId(), "entities/piglin");

        LootTableLoadingCallback.EVENT.register(((resourceManager, manager, id, supplier, setter) -> {
            Identifier tableToAdd = LOOT_TABLE_MAP.get(id);
            if (tableToAdd != null) {
                supplier.copyFrom(manager.getTable(tableToAdd));
            }
        }));
    }

    private static void register(Identifier tableToExtend, String tableToAdd) {
        LOOT_TABLE_MAP.put(tableToExtend, new Identifier(Mayhem.MOD_ID, tableToAdd));
    }
}
