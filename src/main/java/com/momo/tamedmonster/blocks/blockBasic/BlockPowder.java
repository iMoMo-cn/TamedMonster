package com.momo.tamedmonster.blocks.blockBasic;

import com.momo.tamedmonster.MoMoFramework;
import com.momo.tamedmonster.blocks.ModBlocks;
import com.momo.tamedmonster.init.ModCreativeTab;
import com.momo.tamedmonster.item.ModItems;
import com.momo.tamedmonster.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockPowder extends BlockFalling implements IHasModel {
    public BlockPowder(String name, Material material){
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);

        setSoundType(SoundType.GROUND);
        setHarvestLevel("shovel", 0);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));

        setCreativeTab(ModCreativeTab.TAMED_MONSTER);
    }

    @Override
    public void registerModels() { MoMoFramework.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory"); }

    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        return MapColor.STONE;
    }

    @SideOnly(Side.CLIENT)
    public int getDustColor(IBlockState state)
    {
        return -8356741;
    }
}
