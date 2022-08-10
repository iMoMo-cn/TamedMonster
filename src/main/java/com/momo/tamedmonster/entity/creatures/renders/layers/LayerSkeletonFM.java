package com.momo.tamedmonster.entity.creatures.renders.layers;

import com.momo.tamedmonster.entity.creatures.friendlyMonster.EntitySkeletonFM;
import com.momo.tamedmonster.entity.creatures.models.ModelSkeletonFM;
import com.momo.tamedmonster.util.Reference;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerSkeletonFM implements LayerRenderer<EntitySkeletonFM> {
    private static final ResourceLocation SKELETON_CLOTHES_TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/skeleton/skeleton_overlay.png");
    private final RenderLivingBase<?> renderer;
    private final ModelSkeletonFM layerModel = new ModelSkeletonFM(0.25F, true);

    public LayerSkeletonFM(RenderLivingBase<?> renderer)
    {
        this.renderer = renderer;
    }

    public void doRenderLayer(EntitySkeletonFM entityIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        this.layerModel.setModelAttributes(this.renderer.getMainModel());
        this.layerModel.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTicks);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.renderer.bindTexture(SKELETON_CLOTHES_TEXTURES);
        this.layerModel.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
    }

    public boolean shouldCombineTextures()
    {
        return true;
    }
}
