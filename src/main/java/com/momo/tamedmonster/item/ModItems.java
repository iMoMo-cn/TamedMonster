package com.momo.fm.item;

import com.momo.fm.init.ModCreativeTab;
import com.momo.fm.item.food.ItemFoodBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.MobEffects;
import net.minecraft.item.*;
import net.minecraft.potion.PotionEffect;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

	public static final List<Item> ITEMS = new ArrayList<Item>();

	//public static final Item ITEM_NAME = new ItemBase("item_name").setCreativeTab(ModCreativeTab.CREATIVE_TAB);
	public static final Item MONSTER_MIXTURE = new ItemBase("monster_mixture").setCreativeTab(CreativeTabs.BREWING);
	public static final Item MONSTER_STEW = new ItemFoodBase("monster_stew", 3, 1.6F, false).setCreativeTab(CreativeTabs.FOOD);
	public static final Item NETHER_MIXTURE = new ItemBase("nether_mixture").setCreativeTab(CreativeTabs.BREWING);
	public static final Item NETHER_STEW = new ItemFoodBase("nether_stew", 4, 2.5F, false).setAlwaysEdible().setCreativeTab(CreativeTabs.FOOD);
	public static final Item MONSTER_ESSENCE = new ItemBase("monster_essence").setCreativeTab(CreativeTabs.BREWING);


}
