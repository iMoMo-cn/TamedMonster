package com.momo.tamedmonster.entity.creatures.friendlyMonster;


import com.momo.tamedmonster.item.ModItems;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityNetherFriendlyMonster extends EntityFriendlyMonster {

    public EntityNetherFriendlyMonster(World worldIn)
    {
        super(worldIn);
        this.isImmuneToFire = true;
    }

    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.25D, ModItems.NETHER_STEW, false));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
        this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
    }

    public Item getTamptItem()
    {
        return ModItems.NETHER_STEW;
    }

    public boolean isBreedingItem(ItemStack stack)
    {
        return stack.getItem() == ModItems.NETHER_STEW;
    }

    @Nullable
    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return null;
    }
}
