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

public class EntitySkeletonFM extends EntityFriendlyMonster{

    public EntitySkeletonFM(World worldIn)
    {
        super(worldIn);
        this.setSize(0.6F, 1.99F);
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
    }

    @Nullable
    protected ResourceLocation getLootTable()
    {
        return ModLootList.ENTITY_SKELETON_FM;
    }

    public static void registerFixesSkeletonFM(DataFixer fixer) { EntityLiving.registerFixesMob(fixer, EntitySkeletonFM.class); }

    protected SoundEvent getAmbientSound()
    {
        return SoundEvents.ENTITY_SKELETON_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return SoundEvents.ENTITY_SKELETON_HURT;
    }

    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_SKELETON_DEATH;
    }

    protected SoundEvent getStepSound()
    {
        return SoundEvents.ENTITY_SKELETON_STEP;
    }

    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }

    public float getEyeHeight() { return 1.74F; }

    public double getYOffset() { return -0.6D; }

    @Nullable
    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return new EntitySkeletonFM(this.world);
    }
}
