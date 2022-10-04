package com.momo.tamedmonster.blocks.blockBasic;

import com.momo.tamedmonster.util.IHasModel;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class BlockString extends BlockBone implements IHasModel {
    public BlockString(String name) {
        super(name, Material.CLOTH, MapColor.CLOTH);

        setSoundType(SoundType.CLOTH);
    }
}
