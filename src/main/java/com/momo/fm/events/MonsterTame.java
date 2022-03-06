package com.momo.fm.events;

import com.momo.fm.entity.creatures.friendlyMonster.*;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.*;
import net.minecraft.world.World;

public class MonsterTame {
    public MonsterTame()
    {

    }

    public static int getMonsterLevel(EntityLivingBase e)
    {
        if((e instanceof EntityZombie && !(e instanceof EntityPigZombie))|| e instanceof EntitySkeleton || e instanceof EntityStray || e instanceof EntitySpider || e instanceof EntityCreeper){ return 1; }
        if(e instanceof EntityEnderman || (e instanceof EntitySlime && !(e instanceof EntityMagmaCube))){ return 2;}
        if(e instanceof EntityPigZombie || e instanceof EntityMagmaCube){ return 3;}
        if(e instanceof EntityWitherSkeleton || e instanceof EntityBlaze){ return 4;}
        else return 0;
    }

    public static void SpawnFM(EntityLivingBase entityLivingBaseIn)
    {
        double PosX = entityLivingBaseIn.posX;
        double PosY = entityLivingBaseIn.posY;
        double PosZ = entityLivingBaseIn.posZ;
        float rotationYaw = entityLivingBaseIn.rotationYaw;
        float rotationPitch = entityLivingBaseIn.rotationPitch;
        float renderYawOffset = entityLivingBaseIn.renderYawOffset;

        EntityFriendlyMonster entityFM = getMonsterFM(entityLivingBaseIn);

        entityLivingBaseIn.world.removeEntity(entityLivingBaseIn);
        entityFM.setLocationAndAngles(PosX, PosY, PosZ, rotationYaw, rotationPitch);
        entityFM.renderYawOffset = renderYawOffset;

        if (entityLivingBaseIn.hasCustomName())
        {
            entityFM.setCustomNameTag(entityLivingBaseIn.getCustomNameTag());
        }

        TameInteract.TameEffect(true, entityLivingBaseIn);

        if(!entityLivingBaseIn.world.isRemote)
        {
            entityLivingBaseIn.world.spawnEntity(entityFM);
        }

    }

    public static EntityFriendlyMonster getMonsterFM(EntityLivingBase entityLivingBaseIn){
        World world = entityLivingBaseIn.world;
        if(entityLivingBaseIn instanceof EntityZombie){
            if (entityLivingBaseIn instanceof EntityHusk) return new EntityHuskFM(world);
            else if (entityLivingBaseIn instanceof EntityPigZombie) return new EntityZombiePigmanFM(world);
            return new EntityZombieFM(world);
        }
        else if(entityLivingBaseIn instanceof AbstractSkeleton){
            if(entityLivingBaseIn instanceof EntityWitherSkeleton) return new EntityWitherSkeletonFM(world);
            else if(entityLivingBaseIn instanceof EntityStray) return new EntityStrayFM(world);
            return new EntitySkeletonFM(world);
        }
        else if(entityLivingBaseIn instanceof EntitySpider){
            if(entityLivingBaseIn instanceof EntityCaveSpider) return new EntityCaveSpiderFM(world);
            return new EntitySpiderFM(world);
        }
        else if(entityLivingBaseIn instanceof EntitySlime){
            if(entityLivingBaseIn instanceof EntityMagmaCube) return new EntityMagmaCubeFM(world);
            return new EntitySlimeFM(world);
        }
        else if(entityLivingBaseIn instanceof EntityEnderman) return new EntityEndermanFM(world);
        else if(entityLivingBaseIn instanceof EntityCreeper) return new EntityCreeperFM(world);
        else if(entityLivingBaseIn instanceof EntityBlaze) return new EntityBlazeFM(world);
        return new EntityZombieFM(world);
    }
}
