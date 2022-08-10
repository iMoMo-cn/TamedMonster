package com.momo.tamedmonster.entity.creatures.friendlyMonster;

import com.momo.tamedmonster.init.ModLootList;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityZombieFM extends EntityFriendlyMonster{

    public EntityZombieFM(World worldIn) {
        super(worldIn);
        this.setSize(0.6F, 1.95F);
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23D);
    }

    @Nullable
    protected ResourceLocation getLootTable() { return ModLootList.ENTITY_ZOMBIE_FM; }

    public static void registerFixesZombieFM(DataFixer fixer) { EntityLiving.registerFixesMob(fixer, EntityZombieFM.class); }

    protected SoundEvent getAmbientSound() { return SoundEvents.ENTITY_ZOMBIE_AMBIENT; }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) { return SoundEvents.ENTITY_ZOMBIE_HURT; }

    protected SoundEvent getDeathSound() { return SoundEvents.ENTITY_ZOMBIE_DEATH; }

    protected SoundEvent getStepSound() { return SoundEvents.ENTITY_ZOMBIE_STEP; }

    protected void playStepSound(BlockPos pos, Block blockIn) { this.playSound(this.getStepSound(), 0.15F, 1.0F); }

    public float getEyeHeight() { return 1.74F; }

    public double getYOffset() { return -0.45D; }

    @Nullable
    @Override
    public EntityAgeable createChild(EntityAgeable ageable) { return new EntityZombieFM(this.world); }
}
