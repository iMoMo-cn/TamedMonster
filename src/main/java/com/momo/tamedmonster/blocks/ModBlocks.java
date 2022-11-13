package com.momo.tamedmonster.blocks;

import com.momo.tamedmonster.blocks.blockBasic.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
	public static final List<Block> BLOCKS = new ArrayList<Block>();

	/*
	 * To add a blockBush, put a line here,
	 * -Create a json at assets.eo.blockstates
	 * -Create a json at assets.eo.models.blockBush
	 * -Create a json at assets.eo.models.item
	 * -Add corresponding texture png
	 */

	public static final Block ROTTEN_BLOCK = new BlockBase("rotten_block", Material.GRASS, MapColor.RED).setHardness(1.0F);
	public static final Block SKELETON_BLOCK = new BlockBone("skeleton_block", Material.ROCK, MapColor.SAND).setHardness(2.0F);
	public static final Block GUNPOWDER_BLOCK = new BlockPowder("gunpowder_block", Material.SAND).setHardness(1.0F);
	public static final Block STRING_BLOCK = new BlockString("string_block").setHardness(0.8F);

	public static final Block BLAZE_BLOCK = new BlockBlaze("blaze_block", 12000, Material.ROCK, MapColor.YELLOW).setHardness(2.0F);
	public static final Block BLAZE_NET = new BlockBlaze("blaze_net", 24000, Material.ROCK, MapColor.YELLOW).setHardness(2.0F);
	public static final Block MAGMA_CREAM_BLOCK = new BlockMagmaCream("magma_cream_block").setHardness(0.1F);

	public static final Block ENDER_PEARL_BLOCK = new BlockRock("ender_pearl_block", Material.ROCK, MapColor.LIME).setHardness(1.5F).setResistance(10.0F);
}
