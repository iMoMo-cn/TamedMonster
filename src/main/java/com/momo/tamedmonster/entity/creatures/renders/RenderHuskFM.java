package com.momo.tamedmonster.entity.creatures.renders;

import com.momo.tamedmonster.entity.creatures.friendlyMonster.EntityZombieFM;
import com.momo.tamedmonster.util.Reference;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
    public class RenderHuskFM extends RenderZombieFM {

    private static final ResourceLocation HUSK_FM_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/zombie/husk_fm.png");

    public RenderHuskFM(RenderManager manager)
    {
        super(manager);
    }

    /**
     * Allows the render to do state modifications necessary before the model is rendered.
     */
    protected void preRenderCallback(EntityZombieFM entityIn, float partialTickTime)
    {
        GlStateManager.scale(1.0625F, 1.0625F, 1.0625F);
        super.preRenderCallback(entityIn, partialTickTime);
    }

    protected ResourceLocation getEntityTexture(EntityZombieFM entity)
    {
        return HUSK_FM_TEXTURE;
    }
}
