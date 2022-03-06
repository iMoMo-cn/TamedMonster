package com.momo.fm.entity.creatures.renders.layers;

import com.momo.fm.entity.creatures.friendlyMonster.EntityStrayFM;
import com.momo.fm.entity.creatures.models.ModelSkeletonFM;
import com.momo.fm.util.Reference;
import net.minecraft.client.model.ModelSkeleton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerStrayFM implements LayerRenderer<EntityStrayFM> {
    private static final ResourceLocation STRAY_CLOTHES_TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/skeleton/stray_overlay.png");
    private final RenderLivingBase<?> renderer;
    private final ModelSkeletonFM layerModel = new ModelSkeletonFM(0.25F, true);

    public LayerStrayFM(RenderLivingBase<?> renderer)
    {
        this.renderer = renderer;
    }

    public void doRenderLayer(EntityStrayFM entityIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        this.layerModel.setModelAttributes(this.renderer.getMainModel());
        this.layerModel.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTicks);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.renderer.bindTexture(STRAY_CLOTHES_TEXTURES);
        this.layerModel.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
    }

    public boolean shouldCombineTextures()
    {
        return true;
    }
}
