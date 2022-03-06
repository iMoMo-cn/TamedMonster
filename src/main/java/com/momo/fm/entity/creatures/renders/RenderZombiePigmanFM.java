package com.momo.fm.entity.creatures.renders;

import com.momo.fm.entity.creatures.friendlyMonster.EntityZombieFM;
import com.momo.fm.entity.creatures.friendlyMonster.EntityZombiePigmanFM;
import com.momo.fm.entity.creatures.models.ModelZombieFM;
import com.momo.fm.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
    public class RenderZombiePigmanFM extends RenderLiving<EntityZombiePigmanFM> {

    private static final ResourceLocation ZOMBIE_PIG_FM_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/zombie/zombie_pig_fm.png");

    public RenderZombiePigmanFM(RenderManager manager){ super(manager, new ModelZombieFM(), 0.5f); }

    protected ResourceLocation getEntityTexture(EntityZombiePigmanFM entity)
    {
        return ZOMBIE_PIG_FM_TEXTURE;
    }
}
