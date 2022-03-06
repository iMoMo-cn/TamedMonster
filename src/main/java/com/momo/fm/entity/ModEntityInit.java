package com.momo.fm.entity;

import com.momo.fm.entity.creatures.friendlyMonster.*;
import com.momo.fm.util.Reference;
import com.momo.fm.MoMoFramework;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.datafix.DataFixer;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntityInit {
    private static int ENTITY_NEXT_ID = 1;
    public static void registerEntities()
    {
        registerEntity("zombie_fm", EntityZombieFM.class,44975, 7969893);
        registerEntity("skeleton_fm", EntitySkeletonFM.class,12698049, 4802889);
        registerEntity("spider_fm", EntitySpiderFM.class,3419431, 11013646);
        registerEntity("creeper_fm", EntityCreeperFM.class,894731, 0);
        registerEntity("husk_fm", EntityHuskFM.class, 7958625,15125652);
        registerEntity("stray_fm", EntityStrayFM.class, 6387319,14543594);
        registerEntity("cave_spider_fm", EntityCaveSpiderFM.class, 803406, 11013646);
        registerEntity("wither_skeleton_fm", EntityWitherSkeletonFM.class, 1315860, 4672845);
        registerEntity("enderman_fm", EntityEndermanFM.class, 1447446, 0);
        registerEntity("zombie_pigman_fm", EntityZombiePigmanFM.class, 15373203, 5009705);
        registerEntity("slime_fm", EntitySlimeFM.class, 5349438, 8306542);
        registerEntity("magma_cube_fm", EntityMagmaCubeFM.class, 3407872, 16579584);
        registerEntity("blaze_fm", EntityBlazeFM.class, 16167425, 16775294);

        DataFixer datafixer = new DataFixer(1343);
    }

    private static void registerEntity(String name, Class<? extends Entity> entity)
    {
        registerEntity(name, entity, ENTITY_NEXT_ID, 50, 0xff00ff, 0x000000);
    }

    private static void registerEntity(String name, Class<? extends Entity> entity, int eggPrimaryColor, int eggSecondaryColor)
    {
        registerEntity(name, entity, ENTITY_NEXT_ID, 50, eggPrimaryColor, eggSecondaryColor);
    }

    private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int eggPrimaryColor, int eggSecondaryColor)
    {
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name),
                entity, name, id, MoMoFramework.instance, range, 1, true, eggPrimaryColor, eggSecondaryColor);

        ENTITY_NEXT_ID++;
    }
}
