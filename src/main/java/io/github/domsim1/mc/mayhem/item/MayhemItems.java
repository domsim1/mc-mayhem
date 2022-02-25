package io.github.domsim1.mc.mayhem.item;

import io.github.domsim1.mc.mayhem.Mayhem;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Optional;

public class MayhemItems {
    public static final Item FRESH_FLESH = MayhemItems.register("fresh_flesh", new Item(new Item.Settings().group(ItemGroup.FOOD).food(MayhemFoodComponents.FRESH_FLESH)));
    public static final Item COOKED_FLESH = MayhemItems.register("cooked_flesh", new Item(new Item.Settings().group(ItemGroup.FOOD).food(MayhemFoodComponents.COOKED_FLESH)));
    public static final Item RAW_HORSE = MayhemItems.register("raw_horse", new Item(new Item.Settings().group(ItemGroup.FOOD).food(MayhemFoodComponents.RAW_HORSE)));
    public static final Item COOKED_HORSE = MayhemItems.register("cooked_horse", new Item(new Item.Settings().group(ItemGroup.FOOD).food(MayhemFoodComponents.COOKED_HORSE)));
    public static final Item BEEF_BURGER = MayhemItems.register("beef_burger", new Item(new Item.Settings().group(ItemGroup.FOOD).food(MayhemFoodComponents.BEEF_BURGER)));
    public static final Item BEETROOT_BURGER = MayhemItems.register("beetroot_burger", new Item(new Item.Settings().group(ItemGroup.FOOD).food(MayhemFoodComponents.BEETROOT_BURGER)));
    public static final Item COD_BURGER = MayhemItems.register("cod_burger", new Item(new Item.Settings().group(ItemGroup.FOOD).food(MayhemFoodComponents.COD_BURGER)));
    public static final Item CHICKEN_BURGER = MayhemItems.register("chicken_burger", new Item(new Item.Settings().group(ItemGroup.FOOD).food(MayhemFoodComponents.CHICKEN_BURGER)));
    public static final Item FLESH_BURGER = MayhemItems.register("flesh_burger", new Item(new Item.Settings().group(ItemGroup.FOOD).food(MayhemFoodComponents.FLESH_BURGER)));
    public static final Item HORSE_BURGER = MayhemItems.register("horse_burger", new Item(new Item.Settings().group(ItemGroup.FOOD).food(MayhemFoodComponents.HORSE_BURGER)));
    public static final Item MUTTON_BURGER = MayhemItems.register("mutton_burger", new Item(new Item.Settings().group(ItemGroup.FOOD).food(MayhemFoodComponents.MUTTON_BURGER)));
    public static final Item PORK_BURGER = MayhemItems.register("pork_burger", new Item(new Item.Settings().group(ItemGroup.FOOD).food(MayhemFoodComponents.PORK_BURGER)));
    public static final Item RABBIT_BURGER = MayhemItems.register("rabbit_burger", new Item(new Item.Settings().group(ItemGroup.FOOD).food(MayhemFoodComponents.RABBIT_BURGER)));
    public static final Item SALMON_BURGER = MayhemItems.register("salmon_burger", new Item(new Item.Settings().group(ItemGroup.FOOD).food(MayhemFoodComponents.SALMON_BURGER)));

    public static final Item DYNAMITE = MayhemItems.register("dynamite", new DynamiteItem(new Item.Settings().maxCount(16).group(ItemGroup.MISC)));

    private static Item register(Block block) {
        return MayhemItems.register(new BlockItem(block, new Item.Settings()));
    }

    private static Item register(Block block, ItemGroup group) {
        return MayhemItems.register(new BlockItem(block, new Item.Settings().group(group)));
    }

    private static Item register(Block block, Optional<ItemGroup> group2) {
        return group2.map(group -> MayhemItems.register(block, group)).orElseGet(() -> MayhemItems.register(block));
    }

    private static Item register(Block block, ItemGroup group, Block ... blocks) {
        BlockItem blockItem = new BlockItem(block, new Item.Settings().group(group));
        for (Block block2 : blocks) {
            Item.BLOCK_ITEMS.put(block2, blockItem);
        }
        return MayhemItems.register(blockItem);
    }

    private static Item register(BlockItem item) {
        return MayhemItems.register(item.getBlock(), item);
    }

    protected static Item register(Block block, Item item) {
        return MayhemItems.register(Registry.BLOCK.getId(block), item);
    }

    private static Item register(String id, Item item) {
        return MayhemItems.register(new Identifier(Mayhem.MOD_ID, id), item);
    }

    private static Item register(Identifier id, Item item) {
        if (item instanceof BlockItem) {
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }
        return Registry.register(Registry.ITEM, id, item);
    }
}
