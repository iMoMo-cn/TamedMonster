package com.momo.tamedmonster.item.tools;

import com.momo.tamedmonster.MoMoFramework;
import com.momo.tamedmonster.item.ModItems;
import com.momo.tamedmonster.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class ItemSwordBase extends ItemSword implements IHasModel
{
    public ItemSwordBase(String name, ToolMaterial material, CreativeTabs creativeTabs)
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
