package com.momo.fm.entity.creatures.friendlyMonster;


import com.google.common.collect.Sets;
import com.momo.fm.init.ModLootList;
import com.momo.fm.item.ModItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.stats.StatList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class EntitySlimeFM extends EntityFriendlyMonster{
    public float squishAmount;
    public float squishFactor;
    public float prevSquishFactor;
    private boolean wasOnGround;

    public EntitySlimeFM(World worldIn) {
        super(worldIn);
        this.setSize(1.0F, 1.0F);
        moveHelper = new SlimeMoveHelper(this);
    }

    protected void initEntityAI()
    {
        this.tasks.addTask(0, new AISlimeFloat(this));
        this.tasks.addTask(1, new AISlimeMate(this));
        this.tasks.addTask(2, new AISlimeTempt(this, ModItems.MONSTER_STEW, false));
        this.tasks.addTask(4, new AISlimeFaceRandom(this));
        this.tasks.addTask(5, new AISlimeHop(this));
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.15D);
    }

    public static void registerFixesSlimeFM(DataFixer fixer) { EntityLiving.registerFixesMob(fixer, EntitySlimeFM.class); }

    public void onUpdate()
    {
        this.squishFactor += (this.squishAmount - this.squishFactor) * 0.5F;
        this.prevSquishFactor = this.squishFactor;
        super.onUpdate();

        if (this.onGround && !this.wasOnGround)
        {
            int i = 1;
            for (int j = 0; j < i * 8; ++j)
            {
                float f = this.rand.nextFloat() * ((float)Math.PI * 2F);
                float f1 = this.rand.nextFloat() * 0.5F + 0.5F;
                float f2 = MathHelper.sin(f) * (float)i * 0.5F * f1;
                float f3 = MathHelper.cos(f) * (float)i * 0.5F * f1;
                World world = this.world;
                double d0 = this.posX + (double)f2;
                double d1 = this.posZ + (double)f3;
                world.spawnParticle(EnumParticleTypes.SLIME, d0, this.getEntityBoundingBox().minY, d1, 0.0D, 0.0D, 0.0D);
            }

            this.playSound(getSquishSound(), this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) / 0.8F);
            this.squishAmount = -0.5F;
        }
        else if (!this.onGround && this.wasOnGround)
        {
            this.squishAmount = 1.0F;
        }

        this.wasOnGround = this.onGround;
        this.squishAmount *= 0.6F;
    }

    public float getEyeHeight()
    {
        return 0.625F * this.height;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) { return SoundEvents.ENTITY_SLIME_HURT; }

    protected SoundEvent getDeathSound() { return SoundEvents.ENTITY_SLIME_DEATH; }

    protected SoundEvent getSquishSound() { return SoundEvents.ENTITY_SLIME_SQUISH; }

    protected SoundEvent getJumpSound() { return SoundEvents.ENTITY_SLIME_JUMP; }

    @Nullable
    protected ResourceLocation getLootTable() { return ModLootList.ENTITY_SLIME_FM; }

    protected float getSoundVolume() { return 0.8F; }

    /**
     * The speed it takes to move the entityliving's rotationPitch through the faceEntity method. This is only currently
     * use in wolves.
     */
    public int getVerticalFaceSpeed()
    {
        return 0;
    }

    protected void jump()
    {
        this.motionY = 0.41999998688697815D;
        this.isAirBorne = true;
    }

    protected int getJumpDelay()
    {
        return this.rand.nextInt(20) + 10;
    }

    @Nullable
    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return new EntitySlimeFM(this.world);
    }

    public EntityMoveHelper getMoveHelper(){
        return this.moveHelper;
    }


    /* ======================================== FORGE START =====================================*/
    /**
     * Called when the slime spawns particles on landing, see onUpdate.
     * Return true to prevent the spawning of the default particles.
     */
    /* ======================================== FORGE END   =====================================*/
    class AISlimeMate extends EntityAIBase {
        private final EntityAnimal animal;
        private final Class<? extends EntityAnimal> mateClass;
        World world;
        private EntityAnimal targetMate;
        /**
         * Delay preventing a baby from spawning immediately when two mate-able animals find each other.
         */
        int spawnBabyDelay;

        public AISlimeMate(EntityAnimal animal) {
            this(animal, animal.getClass());
        }

        public AISlimeMate(EntityAnimal p_i47306_1_, Class<? extends EntityAnimal> p_i47306_4_) {
            this.animal = p_i47306_1_;
            this.world = p_i47306_1_.world;
            this.mateClass = p_i47306_4_;
            this.setMutexBits(2);
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute() {
            if (!this.animal.isInLove()) {
                return false;
            } else {
                this.targetMate = this.getNearbyMate();
                return this.targetMate != null;
            }
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean shouldContinueExecuting() {
            return this.targetMate.isEntityAlive() && this.targetMate.isInLove() && this.spawnBabyDelay < 60;
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void resetTask() {
            this.targetMate = null;
            this.spawnBabyDelay = 0;
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void updateTask() {
            this.animal.faceEntity(this.targetMate, 10.0F, 10.0F);
            ((SlimeMoveHelper) this.animal.getMoveHelper()).setDirection(this.animal.rotationYaw, true);
            ((SlimeMoveHelper) this.animal.getMoveHelper()).setSpeed(1.2D);

            ++this.spawnBabyDelay;

            if (this.spawnBabyDelay >= 60 && this.animal.getDistanceSq(this.targetMate) < 9.0D) {
                this.spawnBaby();
            }
        }

        /**
         * Loops through nearby animals and finds another animal of the same type that can be mated with. Returns the first
         * valid mate found.
         */
        private EntityAnimal getNearbyMate() {
            List<EntityAnimal> list = this.world.<EntityAnimal>getEntitiesWithinAABB(this.mateClass, this.animal.getEntityBoundingBox().grow(8.0D));
            double d0 = Double.MAX_VALUE;
            EntityAnimal entityanimal = null;

            for (EntityAnimal entityanimal1 : list) {
                if (this.animal.canMateWith(entityanimal1) && this.animal.getDistanceSq(entityanimal1) < d0) {
                    entityanimal = entityanimal1;
                    d0 = this.animal.getDistanceSq(entityanimal1);
                }
            }

            return entityanimal;
        }

        /**
         * Spawns a baby animal of the same type.
         */
        private void spawnBaby() {
            EntityAgeable entityageable = this.animal.createChild(this.targetMate);

            final net.minecraftforge.event.entity.living.BabyEntitySpawnEvent event = new net.minecraftforge.event.entity.living.BabyEntitySpawnEvent(animal, targetMate, entityageable);
            final boolean cancelled = net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event);
            entityageable = event.getChild();
            if (cancelled) {
                //Reset the "inLove" state for the animals
                this.animal.setGrowingAge(6000);
                this.targetMate.setGrowingAge(6000);
                this.animal.resetInLove();
                this.targetMate.resetInLove();
                return;
            }

            if (entityageable != null) {
                EntityPlayerMP entityplayermp = this.animal.getLoveCause();

                if (entityplayermp == null && this.targetMate.getLoveCause() != null) {
                    entityplayermp = this.targetMate.getLoveCause();
                }

                if (entityplayermp != null) {
                    entityplayermp.addStat(StatList.ANIMALS_BRED);
                    CriteriaTriggers.BRED_ANIMALS.trigger(entityplayermp, this.animal, this.targetMate, entityageable);
                }

                this.animal.setGrowingAge(6000);
                this.targetMate.setGrowingAge(6000);
                this.animal.resetInLove();
                this.targetMate.resetInLove();
                entityageable.setGrowingAge(-24000);
                entityageable.setLocationAndAngles(this.animal.posX, this.animal.posY, this.animal.posZ, 0.0F, 0.0F);
                this.world.spawnEntity(entityageable);
                Random random = this.animal.getRNG();

                for (int i = 0; i < 7; ++i) {
                    double d0 = random.nextGaussian() * 0.02D;
                    double d1 = random.nextGaussian() * 0.02D;
                    double d2 = random.nextGaussian() * 0.02D;
                    double d3 = random.nextDouble() * (double) this.animal.width * 2.0D - (double) this.animal.width;
                    double d4 = 0.5D + random.nextDouble() * (double) this.animal.height;
                    double d5 = random.nextDouble() * (double) this.animal.width * 2.0D - (double) this.animal.width;
                    this.world.spawnParticle(EnumParticleTypes.HEART, this.animal.posX + d3, this.animal.posY + d4, this.animal.posZ + d5, d0, d1, d2);
                }

                if (this.world.getGameRules().getBoolean("doMobLoot")) {
                    this.world.spawnEntity(new EntityXPOrb(this.world, this.animal.posX, this.animal.posY, this.animal.posZ, random.nextInt(7) + 1));
                }
            }
        }
    }

    static class AISlimeTempt extends EntityAIBase
    {
        private final EntityLiving temptedEntity;
        /** X position of player tempting this mob */
        private double targetX;
        /** Y position of player tempting this mob */
        private double targetY;
        /** Z position of player tempting this mob */
        private double targetZ;
        /** Tempting player's pitch */
        private double pitch;
        /** Tempting player's yaw */
        private double yaw;
        /** The player that is tempting the entity that is using this AI. */
        private EntityPlayer temptingPlayer;
        /**
         * A counter that is decremented each time the shouldExecute method is called. The shouldExecute method will always
         * return false if delayTemptCounter is greater than 0.
         */
        private int delayTemptCounter;
        private final Set<Item> temptItem;
        /** Whether the entity using this AI will be scared by the tempter's sudden movement. */
        private final boolean scaredByPlayerMovement;

        public AISlimeTempt(EntityLiving temptedEntityIn, Item temptItemIn, boolean scaredByPlayerMovementIn)
        {
            this(temptedEntityIn, scaredByPlayerMovementIn, Sets.newHashSet(temptItemIn));
        }

        public AISlimeTempt(EntityLiving temptedEntityIn, boolean scaredByPlayerMovementIn, Set<Item> temptItemIn)
        {
            this.temptedEntity = temptedEntityIn;
            this.temptItem = temptItemIn;
            this.scaredByPlayerMovement = scaredByPlayerMovementIn;
            this.setMutexBits(2);

            if (!(temptedEntityIn.getNavigator() instanceof PathNavigateGround))
            {
                throw new IllegalArgumentException("Unsupported mob type for TemptGoal");
            }
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            if (this.delayTemptCounter > 0)
            {
                --this.delayTemptCounter;
                return false;
            }
            else
            {
                this.temptingPlayer = this.temptedEntity.world.getClosestPlayerToEntity(this.temptedEntity, 10.0D);

                if (this.temptingPlayer == null)
                {
                    return false;
                }
                else
                {
                    return this.isTempting(this.temptingPlayer.getHeldItemMainhand()) || this.isTempting(this.temptingPlayer.getHeldItemOffhand());
                }
            }
        }

        protected boolean isTempting(ItemStack stack)
        {
            return this.temptItem.contains(stack.getItem());
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean shouldContinueExecuting()
        {
            if(this.temptingPlayer == null)
            {
                return false;
            }
            else if (this.scaredByPlayerMovement)
            {
                if (this.temptedEntity.getDistanceSq(this.temptingPlayer) < 36.0D)
                {
                    if (this.temptingPlayer.getDistanceSq(this.targetX, this.targetY, this.targetZ) > 0.010000000000000002D)
                    {
                        return false;
                    }

                    if (Math.abs((double)this.temptingPlayer.rotationPitch - this.pitch) > 5.0D || Math.abs((double)this.temptingPlayer.rotationYaw - this.yaw) > 5.0D)
                    {
                        return false;
                    }
                }
                else
                {
                    this.targetX = this.temptingPlayer.posX;
                    this.targetY = this.temptingPlayer.posY;
                    this.targetZ = this.temptingPlayer.posZ;
                }

                this.pitch = (double)this.temptingPlayer.rotationPitch;
                this.yaw = (double)this.temptingPlayer.rotationYaw;
            }
            return this.shouldExecute();
        }

        public void startExecuting()
        {
            this.targetX = this.temptingPlayer.posX;
            this.targetY = this.temptingPlayer.posY;
            this.targetZ = this.temptingPlayer.posZ;
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void resetTask()
        {
            this.temptingPlayer = null;
            this.temptedEntity.getNavigator().clearPath();
            this.delayTemptCounter = 100;
        }
        /**
         * Keep ticking a continuous task that has already been started
         */
        public void updateTask()
        {
            this.temptedEntity.getLookHelper().setLookPositionWithEntity(this.temptingPlayer, (float)(this.temptedEntity.getHorizontalFaceSpeed() + 20), (float)this.temptedEntity.getVerticalFaceSpeed());

            if (this.temptedEntity.getDistanceSq(this.temptingPlayer) < 6.25D)
            {
                this.temptedEntity.getNavigator().clearPath();
                ((SlimeMoveHelper)this.temptedEntity.getMoveHelper()).action = EntityMoveHelper.Action.WAIT;
            }
            else {
                this.temptedEntity.faceEntity(this.temptingPlayer, 10.0F, 10.0F);
                ((SlimeMoveHelper)this.temptedEntity.getMoveHelper()).setDirection(this.temptedEntity.rotationYaw, true);
                ((SlimeMoveHelper)this.temptedEntity.getMoveHelper()).setSpeed(3.0D);
            }
        }
    }

    static class AISlimeFaceRandom extends EntityAIBase
    {
        private final EntitySlimeFM slime;
        private float chosenDegrees;
        private int nextRandomizeTime;

        public AISlimeFaceRandom(EntitySlimeFM slimeIn)
        {
            this.slime = slimeIn;
            setMutexBits(2);
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            return (this.slime.onGround || this.slime.isInWater() || this.slime.isInLava() || this.slime.isPotionActive(MobEffects.LEVITATION));
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void updateTask()
        {
            if (--this.nextRandomizeTime <= 0)
            {
                this.nextRandomizeTime = 40 + this.slime.getRNG().nextInt(60);
                this.chosenDegrees = (float)this.slime.getRNG().nextInt(360);
            }

            ((SlimeMoveHelper)this.slime.getMoveHelper()).setDirection(this.chosenDegrees, false);
        }
    }

    static class AISlimeFloat extends EntityAIBase
    {
        private final EntitySlimeFM slime;

        public AISlimeFloat(EntitySlimeFM slimeIn)
        {
            this.slime = slimeIn;
            ((PathNavigateGround)slimeIn.getNavigator()).setCanSwim(true);
            setMutexBits(5);
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            return this.slime.isInWater() || this.slime.isInLava();
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void updateTask()
        {
            if (this.slime.getRNG().nextFloat() < 0.8F)
            {
                this.slime.getJumpHelper().setJumping();
            }

            ((SlimeMoveHelper)this.slime.getMoveHelper()).setSpeed(1.2D);
        }
    }

    static class AISlimeHop extends EntityAIBase
    {
        private final EntitySlimeFM slime;

        public AISlimeHop(EntitySlimeFM slimeIn)
        {
            this.slime = slimeIn;
            setMutexBits(5);
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            return true;
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void updateTask()
        {
            ((EntitySlimeFM.SlimeMoveHelper)this.slime.getMoveHelper()).setSpeed(2.0D);
        }
    }

    static class SlimeMoveHelper extends EntityMoveHelper
    {
        private float yRot;
        private int jumpDelay;
        private final EntitySlimeFM slime;
        private boolean isAggressive;

        public SlimeMoveHelper(EntitySlimeFM slimeIn)
        {
            super(slimeIn);
            this.slime = slimeIn;
            this.yRot = 180.0F * slimeIn.rotationYaw / (float)Math.PI;
        }

        public void setDirection(float p_179920_1_, boolean p_179920_2_)
        {
            this.yRot = p_179920_1_;
            this.isAggressive = p_179920_2_;
        }

        public void setSpeed(double speedIn)
        {
            this.speed = speedIn;
            this.action = EntityMoveHelper.Action.MOVE_TO;
        }

        public void onUpdateMoveHelper()
        {
            this.entity.rotationYaw = this.limitAngle(this.entity.rotationYaw, this.yRot, 90.0F);
            this.entity.rotationYawHead = this.entity.rotationYaw;
            this.entity.renderYawOffset = this.entity.rotationYaw;

            if (this.action != EntityMoveHelper.Action.MOVE_TO)
            {
                this.entity.setMoveForward(0.0F);
            }
            else
            {
                this.action = EntityMoveHelper.Action.WAIT;

                if (this.entity.onGround)
                {
                    this.entity.setAIMoveSpeed((float)(this.speed * this.entity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue()));

                    if (this.jumpDelay-- <= 0)
                    {
                        this.jumpDelay = this.slime.getJumpDelay();

                        if (this.isAggressive)
                        {
                            this.jumpDelay /= 3;
                        }

                        this.slime.getJumpHelper().setJumping();

                        this.slime.playSound(this.slime.getJumpSound(), this.slime.getSoundVolume(), ((this.slime.getRNG().nextFloat() - this.slime.getRNG().nextFloat()) * 0.2F + 1.0F) * 0.8F);
                    }
                    else
                    {
                        this.slime.moveStrafing = 0.0F;
                        this.slime.moveForward = 0.0F;
                        this.entity.setAIMoveSpeed(0.0F);
                    }
                }
                else
                {
                    this.entity.setAIMoveSpeed((float)(this.speed * this.entity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue()));
                }
            }
        }
    }
}
