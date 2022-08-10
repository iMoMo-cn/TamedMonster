package com.momo.tamedmonster.blocks.blockBasic;

import com.momo.tamedmonster.blocks.BlockBase;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.Random;

public class BlockGeneralOrb extends BlockBase implements ITileEntityProvider {

	public Class<? extends TileEntity> tileEntity;

	public BlockGeneralOrb(String name, Material material, Class <? extends TileEntity> classEntity) {
		super(name, material);
		this.hasTileEntity = true;
		this.tileEntity = classEntity;
		setSoundType(SoundType.METAL);
		setHardness(5.0F);
		setResistance(1500.0F);
		setHarvestLevel("pickaxe", 3);
		setLightOpacity(1);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}

	//optional
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return super.getItemDropped(state, rand, fortune);
	}
	
	@Override
	public int quantityDropped(Random rand) {
//		int max = 4;
//		int min = 1;
//		return rand.nextInt(max) + min;
		
		return super.quantityDropped(rand);
	}

	/**
	 * Returns a new instance of a blockBush's tile entity class. Called on placing the blockBush.
	 */
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		try {
			return tileEntity.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
			return  null;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return  null;
		}
	}


}
