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

public class EntityWitherSkeletonFM extends EntityNetherFriendlyMonster{

    public EntityWitherSkeletonFM(World worldIn)
    {
        super(worldIn);
        this.setSize(0.7F, 2.4F);
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
    }

    @Nullable
    protected ResourceLocation getLootTable()
    {
        return ModLootList.ENTITY_WITHER_SKELETON_FM;
    }

    public static void registerFixesSkeletonFM(DataFixer fixer) { EntityLiving.registerFixesMob(fixer, EntityWitherSkeletonFM.class); }

    protected SoundEvent getAmbientSound()
    {
        return SoundEvents.ENTITY_WITHER_SKELETON_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return SoundEvents.ENTITY_WITHER_SKELETON_HURT;
    }

    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_WITHER_SKELETON_DEATH;
    }

    protected SoundEvent getStepSound()
    {
        return SoundEvents.ENTITY_WITHER_SKELETON_STEP;
    }

    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }

    public float getEyeHeight() { return 2.1F; }

    public double getYOffset() { return -0.6D; }

    @Nullable
    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return new EntityWitherSkeletonFM(this.world);
    }
}
