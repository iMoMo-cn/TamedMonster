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

public class EntityHuskFM extends EntityZombieFM{

    public EntityHuskFM(World worldIn) {
        super(worldIn);
        this.setSize(0.6F, 1.95F);
    }

    @Nullable
    protected ResourceLocation getLootTable() { return ModLootList.ENTITY_ZOMBIE_FM; }

    public static void registerFixesHuskFM(DataFixer fixer) { EntityLiving.registerFixesMob(fixer, EntityHuskFM.class); }

    protected SoundEvent getAmbientSound() { return SoundEvents.ENTITY_HUSK_AMBIENT; }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) { return SoundEvents.ENTITY_HUSK_HURT; }

    protected SoundEvent getDeathSound() { return SoundEvents.ENTITY_HUSK_DEATH; }

    protected SoundEvent getStepSound() { return SoundEvents.ENTITY_HUSK_STEP; }

    @Nullable
    @Override
    public EntityAgeable createChild(EntityAgeable ageable) { return new EntityHuskFM(this.world); }
}
