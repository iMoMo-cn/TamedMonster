package com.momo.tamedmonster.entity.creatures.renders;

import com.momo.tamedmonster.entity.creatures.friendlyMonster.EntitySkeletonFM;
import com.momo.tamedmonster.entity.creatures.models.ModelSkeletonFM;
import com.momo.tamedmonster.entity.creatures.renders.layers.LayerSkeletonFM;
import com.momo.tamedmonster.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

    @SideOnly(Side.CLIENT)
        public class RenderSkeletonFM extends RenderLiving<EntitySkeletonFM> {

        private static final ResourceLocation SKELETON_FM_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/skeleton/skeleton_fm.png");

        public RenderSkeletonFM(RenderManager manager){
            super(manager, new ModelSkeletonFM(), 0.7f);
            if(!(this instanceof RenderStrayFM))this.addLayer(new LayerSkeletonFM(this));
        }

        protected ResourceLocation getEntityTexture(EntitySkeletonFM entity) { return SKELETON_FM_TEXTURE; }
}
