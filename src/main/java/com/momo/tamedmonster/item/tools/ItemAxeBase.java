package com.momo.tamedmonster.item.tools;

import com.momo.tamedmonster.MoMoFramework;
import com.momo.tamedmonster.item.ModItems;
import com.momo.tamedmonster.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;

public class ItemAxeBase extends ItemAxe implements IHasModel {

    /*
    MATERIALS      {WOOD, STONE, IRON, DIAMOND, GOLD}
    ATTACK_DAMAGES {6.0F, 8.0F, 8.0F, 8.0F, 6.0F}
    ATTACK_SPEEDS  { -3.2F, -3.2F, -3.1F, -3.0F, -3.0F}
    */

    public ItemAxeBase(String name, ToolMaterial material, CreativeTabs creativeTabs, Float damage, Float speed)
    {
        super(material, damage, speed);
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
