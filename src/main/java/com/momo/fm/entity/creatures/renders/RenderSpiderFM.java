package com.momo.fm.entity.creatures.renders;


import com.momo.fm.entity.creatures.friendlyMonster.EntitySpiderFM;
import com.momo.fm.entity.creatures.models.ModelSpiderFM;
import com.momo.fm.entity.creatures.renders.layers.LayerSpiderEyesFM;
import com.momo.fm.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
    public class RenderSpiderFM extends RenderLiving<EntitySpiderFM> {

    private static final ResourceLocation SPIDER_FM_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/spider/spider_fm.png");

    public RenderSpiderFM(RenderManager manager) {
        super(manager, new ModelSpiderFM(), 1.0f);
        this.addLayer(new LayerSpiderEyesFM<>(this));
    }

    /**
     * Allows the render to do state modifications necessary before the model is rendered.
     */
    protected void preRenderCallback(EntitySpiderFM entityIn, float partialTickTime) { }

    protected ResourceLocation getEntityTexture(EntitySpiderFM entity) { return SPIDER_FM_TEXTURE; }
}
