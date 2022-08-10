package com.momo.tamedmonster.entity.creatures.renders;

import com.momo.tamedmonster.entity.creatures.friendlyMonster.EntitySlimeFM;
import com.momo.tamedmonster.entity.creatures.models.ModelSlimeFM;
import com.momo.tamedmonster.entity.creatures.renders.layers.LayerSlimeGelFM;
import com.momo.tamedmonster.util.Reference;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
    public class RenderSlimeFM extends RenderLiving<EntitySlimeFM> {

    private static final ResourceLocation SLIME_FM_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/slime/slime_fm.png");

    public RenderSlimeFM(RenderManager manager) {
        super(manager, new ModelSlimeFM(16), 0.25F);
        this.addLayer(new LayerSlimeGelFM(this));
    }

    /**
     * Renders the desired {@code T} type Entity.
     */
    public void doRender(EntitySlimeFM entityIn, double x, double y, double z, float entityYaw, float partialTicks)
    {
        this.shadowSize = 0.5F;
        super.doRender(entityIn, x, y, z, entityYaw, partialTicks);
    }

    /**
     * Allows the render to do state modifications necessary before the model is rendered.
     */
    protected void preRenderCallback(EntitySlimeFM entitylivingbaseIn, float partialTickTime)
    {

        if(entitylivingbaseIn.isChild())
        {
            GlStateManager.scale(1.0F, 1.0F, 1.0F);
        }
        else{
            GlStateManager.scale(2.0F, 2.0F, 2.0F);
        }

        float f1 = 1.0F;
        float f2 = (entitylivingbaseIn.prevSquishFactor + (entitylivingbaseIn.squishFactor - entitylivingbaseIn.prevSquishFactor) * partialTickTime) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        GlStateManager.scale(f3 * f1, 1.0F / f3 * f1, f3 * f1);
        super.preRenderCallback(entitylivingbaseIn, partialTickTime);
    }

    protected ResourceLocation getEntityTexture(EntitySlimeFM entity)
    {
        return SLIME_FM_TEXTURE;
    }
}
