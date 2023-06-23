package com.github.x3r.synchroma.common.entity;

import com.github.x3r.synchroma.common.item.bullets.SynchromaBullet;
import com.github.x3r.synchroma.common.item.guns.SynchromaGun;
import com.github.x3r.synchroma.common.registry.EntityRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.world.damagesource.IndirectEntityDamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BulletEntity extends Projectile implements ItemSupplier {
    private SynchromaGun gun;
    private SynchromaBullet bullet;

    private float health;

    public BulletEntity(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public BulletEntity(Level pLevel, Entity owner, SynchromaGun gun, SynchromaBullet bullet) {
        super(EntityRegistry.BULLET_PROJECTILE.get(), pLevel);
        this.gun = gun;
        this.bullet = bullet;
        setOwner(owner);
    }

    public void shoot() {
        Entity owner = getOwner();
        this.setPos(owner.getPosition(0).add(0, owner.getBbHeight() * 0.8, 0).add(owner.getLookAngle().scale(0.5)));
        this.setRot(owner.yRotO, owner.xRotO);
        this.setDeltaMovement(moveVec());
    }

    @Override
    public void tick() {
        super.tick();
        this.setPos(this.position().add(this.getDeltaMovement()));
        if(this.gun == null || this.bullet == null) {
            return;
        }
        handleEntityCollision();
        handleBlockCollision();

    }
    private void handleEntityCollision() {
        //add headshot detection
        this.level.getEntities(this, this.getBoundingBox()).stream().filter(LivingEntity.class::isInstance).map(LivingEntity.class::cast).forEach(livingEntity -> {
            livingEntity.hurt(new IndirectEntityDamageSource("bullet", this, this.getOwner()), bullet.getDamage());
            if(bullet.getEffect() != null) {
                livingEntity.addEffect(bullet.getEffect(), getOwner());
            }
        });
    }

    private void handleBlockCollision() {
        BlockState state = this.level.getBlockState(this.blockPosition());
        VoxelShape shape = state.getCollisionShape(this.level, this.blockPosition());
        if(!shape.isEmpty()) {
//            state.isCollisionShapeFullBlock();
        }
    }

    private Vec3 moveVec() {
        float sp = bullet.getSpeed();
        double d = getLookAngle().length();
        return new Vec3((sp*getLookAngle().x)/d, (sp*getLookAngle().y)/d, (sp*getLookAngle().z)/d);
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this);
    }

    @Override
    public ItemStack getItem() {
        return Items.BLUE_ICE.getDefaultInstance();
    }
}