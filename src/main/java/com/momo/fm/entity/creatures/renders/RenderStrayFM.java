package com.momo.fm.entity.creatures.renders;

import com.momo.fm.entity.creatures.friendlyMonster.EntitySkeletonFM;
import com.momo.fm.entity.creatures.renders.layers.LayerStrayFM;
import com.momo.fm.util.Reference;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
    public class RenderStrayFM extends RenderSkeletonFM {

    private static final ResourceLocation STRAY_FM_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/skeleton/stray_fm.png");

    public RenderStrayFM(RenderManager manager){
        super(manager);
        this.addLayer(new LayerStrayFM(this));
    }

    protected ResourceLocation getEntityTexture(EntitySkeletonFM entity) { return STRAY_FM_TEXTURE; }
}
