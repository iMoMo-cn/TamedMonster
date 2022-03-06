package com.momo.fm.entity.creatures.renders;

import com.momo.fm.entity.creatures.friendlyMonster.EntityEndermanFM;
import com.momo.fm.entity.creatures.models.ModelEndermanFM;
import com.momo.fm.entity.creatures.renders.layers.LayerEndermanEyesFM;
import com.momo.fm.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
    public class RenderEndermanFM extends RenderLiving<EntityEndermanFM> {

    private static final ResourceLocation ENDERMAN_FM_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/enderman/enderman_fm.png");

    public RenderEndermanFM(RenderManager manager){
        super(manager, new ModelEndermanFM(0.0F), 0.5f);
        this.addLayer(new LayerEndermanEyesFM(this));
    }

    /**
     * Renders the desired {@code T} type Entity.
     */
    public void doRender(EntityEndermanFM entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    public ModelEndermanFM getMainModel()
    {
        return (ModelEndermanFM) super.getMainModel();
    }

    protected ResourceLocation getEntityTexture(EntityEndermanFM entity)
    {
        return ENDERMAN_FM_TEXTURE;
    }
}
