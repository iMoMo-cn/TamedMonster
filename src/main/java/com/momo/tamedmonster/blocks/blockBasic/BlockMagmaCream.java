package com.momo.tamedmonster.blocks.blockBasic;

import com.momo.tamedmonster.MoMoFramework;
import com.momo.tamedmonster.blocks.ModBlocks;
import com.momo.tamedmonster.init.ModCreativeTab;
import com.momo.tamedmonster.item.ModItems;
import com.momo.tamedmonster.util.IHasModel;
import net.minecraft.block.BlockSlime;
import net.minecraft.block.SoundType;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockMagmaCream extends BlockSlime implements IHasModel {
    public BlockMagmaCream(String name)
    {
        super();
        setUnlocalizedName(name);
        setRegistryName(name);

        setSoundType(SoundType.SLIME);
        setLightLevel(0.2F);
        setLightOpacity(255);
        setHarvestLevel("pickaxe", 0);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));

        setCreativeTab(ModCreativeTab.TAMED_MONSTER);
    }

    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
    {
        if (!entityIn.isImmuneToFire() && entityIn instanceof EntityLivingBase && !EnchantmentHelper.hasFrostWalkerEnchantment((EntityLivingBase)entityIn))
        {
            entityIn.attackEntityFrom(DamageSource.HOT_FLOOR, 0.5F);
        }

        super.onEntityWalk(worldIn, pos, entityIn);
    }


    @Override
    public void registerModels() {
        MoMoFramework.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
