package com.momo.fm.entity.creatures.friendlyMonster;

import com.momo.fm.init.ModLootList;
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

public class EntityZombiePigmanFM extends EntityNetherFriendlyMonster{

    public EntityZombiePigmanFM(World worldIn) {
        super(worldIn);
        this.setSize(0.6F, 1.95F);
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23D);
    }

    @Nullable
    protected ResourceLocation getLootTable() { return ModLootList.ENTITY_ZOMBIE_PIG_FM; }

    public static void registerFixesZombieFM(DataFixer fixer) { EntityLiving.registerFixesMob(fixer, EntityZombiePigmanFM.class); }

    protected SoundEvent getAmbientSound() { return SoundEvents.ENTITY_ZOMBIE_PIG_AMBIENT; }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) { return SoundEvents.ENTITY_ZOMBIE_PIG_HURT; }

    protected SoundEvent getDeathSound() { return SoundEvents.ENTITY_ZOMBIE_PIG_DEATH; }

    public float getEyeHeight() { return 1.74F; }

    public double getYOffset() { return -0.45D; }

    @Nullable
    @Override
    public EntityAgeable createChild(EntityAgeable ageable) { return new EntityZombiePigmanFM(this.world); }
}
