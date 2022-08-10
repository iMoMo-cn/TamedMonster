package com.momo.tamedmonster.entity.creatures.renders;

import com.momo.tamedmonster.entity.creatures.friendlyMonster.EntityMagmaCubeFM;
import com.momo.tamedmonster.entity.creatures.models.ModelMagmaCubeFM;
import com.momo.tamedmonster.util.Reference;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderMagmaCubeFM extends RenderLiving<EntityMagmaCubeFM> {
    private static final ResourceLocation MAGMA_CUBE_FM_TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/slime/magmacube_fm.png");

    public RenderMagmaCubeFM(RenderManager renderManagerIn) { super(renderManagerIn, new ModelMagmaCubeFM(), 0.25F); }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityMagmaCubeFM entity)
    {
        return MAGMA_CUBE_FM_TEXTURES;
    }

    /**
     * Renders the desired {@code T} type Entity.
     */
    public void doRender(EntityMagmaCubeFM entityIn, double x, double y, double z, float entityYaw, float partialTicks)
    {
        this.shadowSize = 0.5F;
        super.doRender(entityIn, x, y, z, entityYaw, partialTicks);
    }

    /**
     * Allows the render to do state modifications necessary before the model is rendered.
     */
    protected void preRenderCallback(EntityMagmaCubeFM entitylivingbaseIn, float partialTickTime)
    {
        float i= entitylivingbaseIn.isChild()? 1.0F : 2.0F;
        float f = (entitylivingbaseIn.prevSquishFactor + (entitylivingbaseIn.squishFactor - entitylivingbaseIn.prevSquishFactor) * partialTickTime) / ((float)i * 0.5F + 1.0F);
        float f1 = 1.0F / (f + 1.0F);
        GlStateManager.scale(f1 * i, 1.0F / f1 * i, f1 * i);
    }
}
