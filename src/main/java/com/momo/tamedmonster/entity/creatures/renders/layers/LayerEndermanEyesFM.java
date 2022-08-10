package com.momo.tamedmonster.entity.creatures.renders.layers;

import com.momo.tamedmonster.entity.creatures.friendlyMonster.EntityEndermanFM;
import com.momo.tamedmonster.entity.creatures.renders.RenderEndermanFM;
import com.momo.tamedmonster.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerEndermanEyesFM implements LayerRenderer<EntityEndermanFM>
{
    private static final ResourceLocation RES_ENDERMAN_EYES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/enderman/enderman_eyes.png");
    private final RenderEndermanFM endermanRenderer;

    public LayerEndermanEyesFM(RenderEndermanFM endermanRendererIn)
    {
        this.endermanRenderer = endermanRendererIn;
    }

    public void doRenderLayer(EntityEndermanFM entityIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        this.endermanRenderer.bindTexture(RES_ENDERMAN_EYES);
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
        GlStateManager.disableLighting();
        GlStateManager.depthMask(!entityIn.isInvisible());
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 61680.0F, 0.0F);
        GlStateManager.enableLighting();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        Minecraft.getMinecraft().entityRenderer.setupFogColor(true);
        this.endermanRenderer.getMainModel().render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        Minecraft.getMinecraft().entityRenderer.setupFogColor(false);
        this.endermanRenderer.setLightmap(entityIn);
        GlStateManager.depthMask(true);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
    }

    public boolean shouldCombineTextures()
    {
        return false;
    }
}