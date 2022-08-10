package com.momo.tamedmonster.item.potions;

import com.momo.tamedmonster.potion.ModPotion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;

import java.util.ArrayList;
import java.util.List;

public class ModPotionType {
    public static final List<PotionType> POTION_TYPES = new ArrayList<>();

//    public static final PotionType POTION_TYPE_NEW = new PotionTypeBase("name", new PotionEffect(NEW_POTION, 1)).setRegistryName("name");
//    public static final PotionType POTION_TYPE_LONG_NAME = new PotionTypeBase("name", new PotionEffect(NEW_POTION, 1, 1)).setRegistryName("long_name");
    public static final PotionType MONSTER_TAMING = new PotionTypeBase("monster_taming",
        new PotionEffect(ModPotion.MONSTER_TAMING, 1)).setRegistryName("monster_taming");

    public static final PotionType ADVANCED_MONSTER_TAMING = new PotionTypeBase("monster_taming",
            new PotionEffect(ModPotion.MONSTER_TAMING, 1, 1)).setRegistryName("advanced_monster_taming");

    public static final PotionType NETHER_TAMING = new PotionTypeBase("nether_taming",
            new PotionEffect(ModPotion.NETHER_TAMING, 1)).setRegistryName("nether_taming");

    public static final PotionType ADVANCED_NETHER_TAMING = new PotionTypeBase("nether_taming",
            new PotionEffect(ModPotion.NETHER_TAMING,1, 1)).setRegistryName("advanced_nether_taming");
}
