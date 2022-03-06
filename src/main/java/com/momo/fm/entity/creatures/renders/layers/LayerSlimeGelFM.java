package com.momo.fm.entity.creatures.renders.layers;

import com.momo.fm.entity.creatures.friendlyMonster.EntitySlimeFM;
import com.momo.fm.entity.creatures.models.ModelSlimeFM;
import com.momo.fm.entity.creatures.renders.RenderSlimeFM;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;

public class LayerSlimeGelFM implements LayerRenderer<EntitySlimeFM>
{
    private final RenderSlimeFM slimeRenderer;
    private final ModelBase slimeModel = new ModelSlimeFM(0);

    public LayerSlimeGelFM(RenderSlimeFM slimeRendererIn)
    {
        this.slimeRenderer = slimeRendererIn;
    }

    public void doRenderLayer(EntitySlimeFM entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        if (!entitylivingbaseIn.isInvisible())
        {
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.enableNormalize();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            this.slimeModel.setModelAttributes(this.slimeRenderer.getMainModel());
            this.slimeModel.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
            GlStateManager.disableBlend();
            GlStateManager.disableNormalize();
        }
    }

    public boolean shouldCombineTextures()
    {
        return true;
    }
}
