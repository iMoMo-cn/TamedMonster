package com.momo.tamedmonster.entity.creatures.renders;

import com.momo.tamedmonster.entity.creatures.friendlyMonster.EntityCreeperFM;
import com.momo.tamedmonster.entity.creatures.models.ModelCreeperFM;
import com.momo.tamedmonster.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
    public class RenderCreeperFM extends RenderLiving<EntityCreeperFM> {

    private static final ResourceLocation CREEPER_FM_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/creeper/creeper_fm.png");

    public RenderCreeperFM(RenderManager manager){ super(manager, new ModelCreeperFM(), 0.5f); }

    protected ResourceLocation getEntityTexture(EntityCreeperFM entity) { return CREEPER_FM_TEXTURE; }
}
