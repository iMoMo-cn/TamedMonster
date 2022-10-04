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
import net.minecraft.item.ItemStack;

public class BlockBlaze extends Block implements IHasModel {
    public BlockBlaze(String name, int burnTime, Material material, MapColor mapColor){
        super(material, mapColor);
        setUnlocalizedName(name);
        setRegistryName(name);

        setSoundType(SoundType.STONE);
        setHarvestLevel("pickaxe", 0);
        setLightLevel(1.0F);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this){
            @Override
            public int getItemBurnTime(ItemStack itemStack)
            {
                return burnTime;
            }
        }.setRegistryName(this.getRegistryName()));

        setCreativeTab(ModCreativeTab.TAMED_MONSTER);
    }

    public BlockBlaze(String name, int burnTime, Material material){
        this(name, burnTime, material, material.getMaterialMapColor());
    }



    @Override
    public void registerModels() {
        MoMoFramework.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
