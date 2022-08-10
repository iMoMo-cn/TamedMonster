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

public class EntitySpiderFM extends EntityFriendlyMonster{

    public EntitySpiderFM(World worldIn)
    {
        super(worldIn);
        this.setSize(1.4F, 0.9F);
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
    }

    @Nullable
    protected ResourceLocation getLootTable()
    {
        return ModLootList.ENTITY_SPIDER_FM;
    }

    public static void registerFixesSpiderFM(DataFixer fixer) { EntityLiving.registerFixesMob(fixer, EntitySpiderFM.class); }

    public double getMountedYOffset()
    {
        return (double)(this.height * 0.5F);
    }

    protected SoundEvent getAmbientSound()
    {
        return SoundEvents.ENTITY_SPIDER_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return SoundEvents.ENTITY_SPIDER_HURT;
    }

    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_SPIDER_DEATH;
    }

    protected SoundEvent getStepSound()
    {
        return SoundEvents.ENTITY_SPIDER_STEP;
    }

    public void setInWeb() { }

    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }

    public float getEyeHeight() { return 0.65F; }

    public double getYOffset() { return 0.0D; }

    @Nullable
    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return new EntitySpiderFM(this.world);
    }
}
