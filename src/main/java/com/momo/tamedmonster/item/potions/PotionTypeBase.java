package com.momo.tamedmonster.item.potions;

import com.momo.tamedmonster.item.ModItems;
import net.minecraft.init.PotionTypes;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;

import javax.annotation.Nullable;

public class PotionTypeBase extends PotionType {
    public PotionTypeBase(@Nullable String name, PotionEffect... potionEffects)
    {
        super(name, potionEffects);

        ModPotionType.POTION_TYPES.add(this);
    }

    public static void register()
    {
//        PotionHelper.addMix(PotionTypes.AWKWARD, ModItems.MATERIALS_NAME, POTION_TYPE_NAME);
//        PotionHelper.addMix(POTION_TYPE_NAME, Items.REDSTONE, POTION_TYPE_LONG_NAME);
//        PotionHelper.addMix(POTION_TYPE_NAME, Items.GLOWSTONE_DUST, POTION_TYPE_STRONG_NAME);
//        PotionHelper.addMix(POTION_TYPE_STRONG_NAME, Items.REDSTONE, POTION_TYPE_LONG_STRONG_NAME);
//        PotionHelper.addMix(POTION_TYPE_LONG_NAME, Items.GLOWSTONE_DUST, POTION_TYPE_LONG_STRONG_NAME);

        PotionHelper.addMix(PotionTypes.AWKWARD, ModItems.MONSTER_MIXTURE, ModPotionType.MONSTER_TAMING);
        PotionHelper.addMix(PotionTypes.AWKWARD, ModItems.NETHER_MIXTURE, ModPotionType.NETHER_TAMING);

        PotionHelper.addMix(ModPotionType.MONSTER_TAMING, ModItems.MONSTER_ESSENCE, ModPotionType.ADVANCED_MONSTER_TAMING);
        PotionHelper.addMix(ModPotionType.NETHER_TAMING, ModItems.MONSTER_ESSENCE, ModPotionType.ADVANCED_NETHER_TAMING);
    }
}
