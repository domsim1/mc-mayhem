package io.github.domsim1.mc.mayhem.item;

import net.minecraft.item.FoodComponent;

public class MayhemFoodComponents {
    public static final FoodComponent FRESH_FLESH = new FoodComponent.Builder().hunger(4).saturationModifier(2.4f).meat().build();
    public static final FoodComponent COOKED_FLESH = new FoodComponent.Builder().hunger(12).saturationModifier(19.2f).meat().build();
    public static final FoodComponent RAW_HORSE = new FoodComponent.Builder().hunger(3).saturationModifier(1.8f).meat().build();
    public static final FoodComponent COOKED_HORSE = new FoodComponent.Builder().hunger(8).saturationModifier(12.8f).meat().build();
    public static final FoodComponent BEEF_BURGER = new FoodComponent.Builder().hunger(13).saturationModifier(23.4f).meat().build();
    public static final FoodComponent BEETROOT_BURGER = new FoodComponent.Builder().hunger(11).saturationModifier(17.6f).meat().build();
    public static final FoodComponent CHICKEN_BURGER = new FoodComponent.Builder().hunger(11).saturationModifier(17.6f).meat().build();
    public static final FoodComponent COD_BURGER = new FoodComponent.Builder().hunger(10).saturationModifier(16.0f).meat().build();
    public static final FoodComponent FLESH_BURGER = new FoodComponent.Builder().hunger(17).saturationModifier(30.6f).meat().build();
    public static final FoodComponent HORSE_BURGER = new FoodComponent.Builder().hunger(13).saturationModifier(23.4f).meat().build();
    public static final FoodComponent MUTTON_BURGER = new FoodComponent.Builder().hunger(11).saturationModifier(19.8f).meat().build();
    public static final FoodComponent PORK_BURGER = new FoodComponent.Builder().hunger(13).saturationModifier(23.4f).meat().build();
    public static final FoodComponent RABBIT_BURGER = new FoodComponent.Builder().hunger(10).saturationModifier(16.0f).meat().build();
    public static final FoodComponent SALMON_BURGER = new FoodComponent.Builder().hunger(11).saturationModifier(19.8f).meat().build();
}
