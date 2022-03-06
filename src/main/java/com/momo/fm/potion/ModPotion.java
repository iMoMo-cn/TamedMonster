package com.momo.fm.potion;

import net.minecraft.potion.Potion;

import java.util.ArrayList;
import java.util.List;

public class ModPotion {

    public static final List<Potion> POTIONS = new ArrayList<>();

//    public static final Potion NEW_INSTANT_POTION = new InstantPotion("name", false , 0xFFF8DC);
//    public static final Potion NEW_POTION = new PotionBase("name", true, 0x66CCFF);
    public static final Potion MONSTER_TAMING = new InstantPotion("monster_taming", false, 0x1E89BB);
    public static final Potion NETHER_TAMING = new InstantPotion("nether_taming", false, 0x7C0F30);
    public static final Potion TAMING = new PotionBase("taming", false, 0x1E89BB);
}
