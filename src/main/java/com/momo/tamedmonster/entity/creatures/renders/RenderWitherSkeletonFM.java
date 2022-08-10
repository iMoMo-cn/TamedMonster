package com.momo.tamedmonster.entity.creatures.renders;

import com.momo.tamedmonster.entity.creatures.friendlyMonster.EntityWitherSkeletonFM;
import com.momo.tamedmonster.entity.creatures.models.ModelSkeletonFM;
import com.momo.tamedmonster.util.Reference;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderWitherSkeletonFM extends RenderLiving<EntityWitherSkeletonFM> {

    private static final ResourceLocation WITHER_SKELETON_FM_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/skeleton/wither_skeleton_fm.png");

    public RenderWitherSkeletonFM(RenderManager manager){ super(manager, new ModelSkeletonFM(), 0.7f); }
    /**
     * Allows the render to do state modifications necessary before the model is rendered.
     */
    protected void preRenderCallback(EntityWitherSkeletonFM entityIn, float partialTickTime)
    {
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
    }

    protected ResourceLocation getEntityTexture(EntityWitherSkeletonFM entity) { return WITHER_SKELETON_FM_TEXTURE; }
}
