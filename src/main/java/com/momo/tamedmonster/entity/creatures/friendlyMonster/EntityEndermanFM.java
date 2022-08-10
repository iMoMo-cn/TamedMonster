package com.momo.tamedmonster.entity.creatures.friendlyMonster;

import com.momo.tamedmonster.init.ModLootList;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.SoundEvents;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityEndermanFM extends EntityFriendlyMonster{

    public EntityEndermanFM(World worldIn) {
        super(worldIn);
        this.setSize(0.6F, 2.9F);
        this.stepHeight = 1.0F;
        this.setPathPriority(PathNodeType.WATER, -1.0F);
    }

    public void onLivingUpdate()
    {
        if (this.world.isRemote)
        {
            for (int i = 0; i < 2; ++i)
            {
                this.world.spawnParticle(EnumParticleTypes.PORTAL, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height - 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, (this.rand.nextDouble() - 0.5D) * 2.0D, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5D) * 2.0D);
            }
        }

        this.isJumping = false;
        super.onLivingUpdate();
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
    }

    @Nullable
    protected ResourceLocation getLootTable() { return ModLootList.ENTITY_ENDERMAN_FM; }

    public static void registerFixesEndermanFM(DataFixer fixer) { EntityLiving.registerFixesMob(fixer, EntityEndermanFM.class); }

    protected SoundEvent getAmbientSound() { return SoundEvents.ENTITY_ENDERMEN_AMBIENT; }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) { return SoundEvents.ENTITY_ENDERMEN_HURT; }

    protected SoundEvent getDeathSound() { return SoundEvents.ENTITY_ENDERMEN_DEATH; }

    public float getEyeHeight() { return 2.55F; }

    public double getYOffset() { return 0.0D; }

    @Nullable
    @Override
    public EntityAgeable createChild(EntityAgeable ageable) { return new EntityEndermanFM(this.world); }
}
