package com.momo.fm.entity.creatures.renders;


import com.momo.fm.entity.creatures.friendlyMonster.EntityCaveSpiderFM;
import com.momo.fm.entity.creatures.friendlyMonster.EntitySpiderFM;
import com.momo.fm.entity.creatures.models.ModelSpiderFM;
import com.momo.fm.util.Reference;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
    public class RenderCaveSpiderFM extends RenderSpiderFM {

    private static final ResourceLocation CAVE_SPIDER_FM_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/spider/cave_spider_fm.png");

    public RenderCaveSpiderFM(RenderManager manager)
    {
        super(manager);
        this.shadowSize *= 0.7F;
    }

    /**
     * Allows the render to do state modifications necessary before the model is rendered.
     */
    protected void preRenderCallback(EntitySpiderFM entityIn, float partialTickTime)
    {
        GlStateManager.scale(0.7F, 0.7F, 0.7F);
    }

    protected ResourceLocation getEntityTexture(EntitySpiderFM entity) { return CAVE_SPIDER_FM_TEXTURE; }
}
