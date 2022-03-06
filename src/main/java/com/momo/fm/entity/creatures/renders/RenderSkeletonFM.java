package com.momo.fm.entity.creatures.renders;

import com.momo.fm.entity.creatures.friendlyMonster.EntitySkeletonFM;
import com.momo.fm.entity.creatures.models.ModelSkeletonFM;
import com.momo.fm.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

    @SideOnly(Side.CLIENT)
        public class RenderSkeletonFM extends RenderLiving<EntitySkeletonFM> {

        private static final ResourceLocation SKELETON_FM_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/skeleton/skeleton_fm.png");

        public RenderSkeletonFM(RenderManager manager){ super(manager, new ModelSkeletonFM(), 0.7f); }

        protected ResourceLocation getEntityTexture(EntitySkeletonFM entity) { return SKELETON_FM_TEXTURE; }
}
