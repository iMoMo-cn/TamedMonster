package com.momo.tamedmonster.init;

import com.momo.tamedmonster.item.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModCreativeTab {
    public static final CreativeTabs TAMED_MONSTER = new CreativeTabs(CreativeTabs.getNextID(), "tamed_monster")
    {
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() { return new ItemStack(ModItems.MONSTER_STEW); }
    };

}
