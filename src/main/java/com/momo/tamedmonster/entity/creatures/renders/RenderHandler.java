package com.momo.tamedmonster.entity.creatures.renders;

import com.momo.tamedmonster.entity.creatures.friendlyMonster.*;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {

    public static void registerEntityRenders() {

        RenderingRegistry.registerEntityRenderingHandler(EntityZombieFM.class, new IRenderFactory<EntityZombieFM>() {
            @Override
            public Render<? super EntityZombieFM> createRenderFor(RenderManager manager) {
                return new RenderZombieFM(manager);
            }
        });

        RenderingRegistry.registerEntityRenderingHandler(EntitySkeletonFM.class, new IRenderFactory<EntitySkeletonFM>() {
            @Override
            public Render<? super EntitySkeletonFM> createRenderFor(RenderManager manager) {
                return new RenderSkeletonFM(manager);
            }
        });

        RenderingRegistry.registerEntityRenderingHandler(EntitySpiderFM.class, new IRenderFactory<EntitySpiderFM>() {
            @Override
            public Render<? super EntitySpiderFM> createRenderFor(RenderManager manager) {
                return new RenderSpiderFM(manager);
            }
        });

        RenderingRegistry.registerEntityRenderingHandler(EntityCreeperFM.class, new IRenderFactory<EntityCreeperFM>() {
            @Override
            public Render<? super EntityCreeperFM> createRenderFor(RenderManager manager) {
                return new RenderCreeperFM(manager);
            }
        });

        RenderingRegistry.registerEntityRenderingHandler(EntityHuskFM.class, new IRenderFactory<EntityHuskFM>() {
            @Override
            public Render<? super EntityHuskFM> createRenderFor(RenderManager manager) {
                return new RenderHuskFM(manager);
            }
        });

        RenderingRegistry.registerEntityRenderingHandler(EntityStrayFM.class, new IRenderFactory<EntityStrayFM>() {
            @Override
            public Render<? super EntityStrayFM> createRenderFor(RenderManager manager) {
                return new RenderStrayFM(manager);
            }
        });

        RenderingRegistry.registerEntityRenderingHandler(EntityCaveSpiderFM.class, new IRenderFactory<EntityCaveSpiderFM>() {
            @Override
            public Render<? super EntityCaveSpiderFM> createRenderFor(RenderManager manager) {
                return new RenderCaveSpiderFM(manager);
            }
        });

        RenderingRegistry.registerEntityRenderingHandler(EntityWitherSkeletonFM.class, new IRenderFactory<EntityWitherSkeletonFM>() {
            @Override
            public Render<? super EntityWitherSkeletonFM> createRenderFor(RenderManager manager) {
                return new RenderWitherSkeletonFM(manager);
            }
        });

        RenderingRegistry.registerEntityRenderingHandler(EntityEndermanFM.class, new IRenderFactory<EntityEndermanFM>() {
            @Override
            public Render<? super EntityEndermanFM> createRenderFor(RenderManager manager) {
                return new RenderEndermanFM(manager);
            }
        });

        RenderingRegistry.registerEntityRenderingHandler(EntityZombiePigmanFM.class, new IRenderFactory<EntityZombiePigmanFM>() {
            @Override
            public Render<? super EntityZombiePigmanFM> createRenderFor(RenderManager manager) {
                return new RenderZombiePigmanFM(manager);
            }
        });

        RenderingRegistry.registerEntityRenderingHandler(EntitySlimeFM.class, new IRenderFactory<EntitySlimeFM>() {
            @Override
            public Render<? super EntitySlimeFM> createRenderFor(RenderManager manager) {
                return new RenderSlimeFM(manager);
            }
        });

        RenderingRegistry.registerEntityRenderingHandler(EntityMagmaCubeFM.class, new IRenderFactory<EntityMagmaCubeFM>() {
            @Override
            public Render<? super EntityMagmaCubeFM> createRenderFor(RenderManager manager) {
                return new RenderMagmaCubeFM(manager);
            }
        });

        RenderingRegistry.registerEntityRenderingHandler(EntityBlazeFM.class, new IRenderFactory<EntityBlazeFM>() {
            @Override
            public Render<? super EntityBlazeFM> createRenderFor(RenderManager manager) {
                return new RenderBlazeFM(manager);
            }
        });
    }
}
