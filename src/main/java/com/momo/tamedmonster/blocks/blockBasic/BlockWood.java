package com.momo.tamedmonster.blocks.blockBasic;

import com.momo.tamedmonster.MoMoFramework;
import com.momo.tamedmonster.blocks.ModBlocks;
import com.momo.tamedmonster.init.ModCreativeTab;
import com.momo.tamedmonster.item.ModItems;
import com.momo.tamedmonster.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockWood extends Block implements IHasModel {
    public BlockWood(String name, Material material, MapColor mapColor){
        super(material, mapColor);
        setUnlocalizedName(name);
        setRegistryName(name);

        setSoundType(SoundType.WOOD);
        setHarvestLevel("axe", 0);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));

        setCreativeTab(ModCreativeTab.TAMED_MONSTER);
    }

    @Override
    public void registerModels() {
        MoMoFramework.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
