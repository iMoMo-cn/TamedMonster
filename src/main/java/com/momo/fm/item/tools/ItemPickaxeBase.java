package com.momo.fm.item.tools;

import com.momo.fm.MoMoFramework;
import com.momo.fm.item.ModItems;
import com.momo.fm.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;

public class ItemPickaxeBase extends ItemPickaxe implements IHasModel
{
    public ItemPickaxeBase(String name, Item.ToolMaterial material, CreativeTabs creativeTabs)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        ModItems.ITEMS.add(this);
        setCreativeTab(creativeTabs);
    }

    @Override
    public void registerModels()
    {
        MoMoFramework.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
