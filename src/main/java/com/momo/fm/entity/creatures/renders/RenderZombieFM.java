package com.momo.fm.entity.creatures.renders;

import com.momo.fm.entity.creatures.friendlyMonster.EntityZombieFM;
import com.momo.fm.entity.creatures.models.ModelZombieFM;
import com.momo.fm.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

    @SideOnly(Side.CLIENT)
        public class RenderZombieFM extends RenderLiving<EntityZombieFM> {

        private static final ResourceLocation ZOMBIE_FM_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/zombie/zombie_fm.png");

        public RenderZombieFM(RenderManager manager){ super(manager, new ModelZombieFM(), 0.7f); }

        protected ResourceLocation getEntityTexture(EntityZombieFM entity)
        {
            return ZOMBIE_FM_TEXTURE;
        }
    }
