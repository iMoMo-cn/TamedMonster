package com.momo.fm.events;

import com.momo.fm.item.ModItems;
import com.momo.fm.potion.ModPotion;
import com.momo.fm.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;



@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class TameInteract {
    @SubscribeEvent
    public static void tryTame(PlayerInteractEvent.EntityInteract evt){

        Entity targetIn = evt.getTarget();
        EntityPlayer player = evt.getEntityPlayer();

        if(targetIn instanceof EntityLivingBase){
            EntityLivingBase target = (EntityLivingBase)targetIn;
            if(target.isPotionActive(ModPotion.TAMING))
            {
                int i = MonsterTame.getMonsterLevel(target);
                final Item temptItem;

                if(i == 1 || i == 2)
                {
                    temptItem = ModItems.MONSTER_STEW;
                    if(isTampt(player, temptItem))
                    {
                        isTame(target);
                    }
                }
                else if(i == 3 || i == 4)
                {
                    temptItem = ModItems.NETHER_STEW;
                    if(isTampt(player, temptItem))
                    {
                        isTame(target);
                    }
                }

            }
        }
    }

    private static void isTame(EntityLivingBase target){
        Random rand = new Random();
        if (rand.nextInt(5) == 0)
        {
            MonsterTame.SpawnFM(target);
        }
        else TameEffect(false, target);
    }

    private static Boolean isTampt(EntityPlayer playerIn, Item temptItem){
        ItemStack item1 = playerIn.getHeldItemMainhand();
        ItemStack item2 = playerIn.getHeldItemOffhand();

        if(temptItem == item1.getItem()) {
            if (!playerIn.capabilities.isCreativeMode)
            {
                item1.shrink(1);
            }
            return true;
        }
        else if(temptItem == item2.getItem()) {
            if (!playerIn.capabilities.isCreativeMode)
            {
                item2.shrink(1);
            }
            return true;
        }
        return false;
    }

    public static void TameEffect(boolean play, EntityLivingBase target)
    {
        Random rand = new Random();

        EnumParticleTypes enumparticletypes = EnumParticleTypes.VILLAGER_HAPPY;

        if (!play)
        {
            enumparticletypes = EnumParticleTypes.SMOKE_NORMAL;
        }

        WorldServer worldServer = (WorldServer) target.world;

        for (int i = 0; i < 7; ++i)
        {
            double d0 = rand.nextGaussian() * 0.02D;
            double d1 = rand.nextGaussian() * 0.02D;
            double d2 = rand.nextGaussian() * 0.02D;
            worldServer.spawnParticle(enumparticletypes, target.posX + (double)(rand.nextFloat() * target.width * 2.0F) - (double)target.width, target.posY + 0.5D + (double)(rand.nextFloat() * target.height), target.posZ + (double)(rand.nextFloat() * target.width * 2.0F) - (double)target.width, 1, d0, d1, d2, 0.0D);
        }
    }
}
