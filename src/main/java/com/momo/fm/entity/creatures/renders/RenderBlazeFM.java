package com.momo.fm.entity.creatures.renders;

import com.momo.fm.entity.creatures.friendlyMonster.EntityBlazeFM;
import com.momo.fm.entity.creatures.models.ModelBlazeFM;
import com.momo.fm.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderBlazeFM extends RenderLiving<EntityBlazeFM>
{
    private static final ResourceLocation BLAZE_FM_TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/blaze/blaze_fm.png");

    public RenderBlazeFM(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelBlazeFM(), 0.5F);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityBlazeFM entity)
    {
        return BLAZE_FM_TEXTURES;
    }
}
