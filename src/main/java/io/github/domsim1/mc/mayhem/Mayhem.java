package io.github.domsim1.mc.mayhem;

import io.github.domsim1.mc.mayhem.entity.DynamiteEntity;
import io.github.domsim1.mc.mayhem.event.MayhemLootTableExtension;
import io.github.domsim1.mc.mayhem.item.MayhemItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.ProjectileDispenserBehavior;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Util;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;

public class Mayhem implements ModInitializer {
    public static final String MOD_ID = "mayhem";

    @Override
    public void onInitialize() {
        MayhemLootTableExtension.register();

        DispenserBlock.registerBehavior(MayhemItems.DYNAMITE, new ProjectileDispenserBehavior(){
            @Override
            protected ProjectileEntity createProjectile(World world, Position position, ItemStack stack) {
                return Util.make(new DynamiteEntity(world, position.getX(), position.getY(), position.getZ()), entity -> entity.setItem(stack));
            }
        });
    }
}
