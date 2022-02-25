package io.github.domsim1.mc.mayhem.entity;

import io.github.domsim1.mc.mayhem.item.MayhemItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class DynamiteEntity extends ThrownItemEntity {

    public DynamiteEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public DynamiteEntity(World world, LivingEntity owner) {
        super(MayhemEntityType.DynamiteEntityType, owner, world);
    }

    public DynamiteEntity(World world, double x, double y, double z) {
        super(MayhemEntityType.DynamiteEntityType, x, y, z, world);
    }

    @Override
    protected Item getDefaultItem() {
        return MayhemItems.DYNAMITE;
    }

    private ParticleEffect explosionEmitter() {
        ItemStack itemStack = this.getItem();
        return itemStack.isEmpty() ? ParticleTypes.EXPLOSION_EMITTER : new ItemStackParticleEffect(ParticleTypes.ITEM, itemStack);
    }


    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        entity.damage(DamageSource.thrownProjectile(this, this.getOwner()), 1);
    }

    private void explode() {
        this.world.createExplosion(this, this.getX(), this.getBodyY(0.0625), this.getZ(), 3.0f, Explosion.DestructionType.BREAK);
        this.world.addParticle(this.explosionEmitter(), this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.world.isClient) {
            this.world.sendEntityStatus(this, (byte)3);
            this.explode();
            this.discard();
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (this.world.isClient) {
            this.world.addParticle(ParticleTypes.SMOKE, this.getX(),  this.getBodyY(1), this.getZ(), 0.0, 0.0, 0.0);
        }
    }
}
