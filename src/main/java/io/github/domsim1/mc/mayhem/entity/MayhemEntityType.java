package io.github.domsim1.mc.mayhem.entity;

import io.github.domsim1.mc.mayhem.Mayhem;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MayhemEntityType {
    public static final EntityType<DynamiteEntity> DynamiteEntityType = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(Mayhem.MOD_ID, "dynamite"),
            FabricEntityTypeBuilder.<DynamiteEntity>create(SpawnGroup.MISC, DynamiteEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build()
    );

    public static void registerEntityRenders() {
        EntityRendererRegistry.register(MayhemEntityType.DynamiteEntityType, FlyingItemEntityRenderer::new);
    }
}
