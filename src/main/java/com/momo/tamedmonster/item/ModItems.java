package com.momo.tamedmonster.item;

import com.momo.tamedmonster.init.ModCreativeTab;
import com.momo.tamedmonster.item.food.ItemFoodBase;
import net.minecraft.item.*;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

	public static final List<Item> ITEMS = new ArrayList<Item>();

	//public static final Item ITEM_NAME = new ItemBase("item_name").setCreativeTab(ModCreativeTab.CREATIVE_TAB);
	public static final Item MONSTER_MIXTURE = new ItemBase("monster_mixture").setCreativeTab(ModCreativeTab.TAMED_MONSTER);
	public static final Item MONSTER_STEW = new ItemFoodBase("monster_stew", 3, 1.6F, false).setCreativeTab(ModCreativeTab.TAMED_MONSTER);
	public static final Item NETHER_MIXTURE = new ItemBase("nether_mixture").setCreativeTab(ModCreativeTab.TAMED_MONSTER);
	public static final Item NETHER_STEW = new ItemFoodBase("nether_stew", 4, 2.5F, false).setAlwaysEdible().setCreativeTab(ModCreativeTab.TAMED_MONSTER);
	public static final Item MONSTER_ESSENCE = new ItemBase("monster_essence").setCreativeTab(ModCreativeTab.TAMED_MONSTER);

	public static final Item ARROW_BUNDLE = new ItemBase("arrow_bundle").setCreativeTab(ModCreativeTab.TAMED_MONSTER);
	public static final Item HUGE_SPIDER_EYE = new ItemBase("huge_spider_eye").setCreativeTab(ModCreativeTab.TAMED_MONSTER);

}
