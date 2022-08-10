package com.momo.tamedmonster.potion;

import com.momo.tamedmonster.MoMoFramework;
import com.momo.tamedmonster.events.MonsterTame;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class PotionBase extends Potion{
    public PotionBase(String name, boolean isBadEffect, int color) {
        super(isBadEffect, color);
        this.setRegistryName(name);
        this.setPotionName("effect." + name);

        ModPotion.POTIONS.add(this);
    }

    public boolean hasEffect(EntityLivingBase entity) {
        return hasEffect(entity, this);
    }

    public boolean hasEffect(EntityLivingBase entity, Potion potion) {
        return entity.getActivePotionEffect(potion) != null;
    }

    //continuousPotion Time trigger
    public boolean isReady(int duration, int amplifier)
    {
        return true;
    }


    public void affectEntity(@Nullable Entity source, @Nullable Entity indirectSource, EntityLivingBase entityLivingBaseIn, int amplifier, double health)
    {
        if(this == ModPotion.MONSTER_TAMING)
        {
            if(amplifier > 0){
                if(MonsterTame.getMonsterLevel(entityLivingBaseIn) == 1 || MonsterTame.getMonsterLevel(entityLivingBaseIn) == 2)
                {
                    entityLivingBaseIn.addPotionEffect(new PotionEffect(ModPotion.TAMING, 1200));
                }
            }
            else{
                if(MonsterTame.getMonsterLevel(entityLivingBaseIn) == 1)
                {
                    entityLivingBaseIn.addPotionEffect(new PotionEffect(ModPotion.TAMING, 1200));
                }
            }
        }

        else if(this == ModPotion.NETHER_TAMING)
        {
            if(amplifier > 0){
                if(MonsterTame.getMonsterLevel(entityLivingBaseIn) == 3 || MonsterTame.getMonsterLevel(entityLivingBaseIn) == 4)
                {
                    entityLivingBaseIn.addPotionEffect(new PotionEffect(ModPotion.TAMING, 1200));
                }
            }
            else{
                if(MonsterTame.getMonsterLevel(entityLivingBaseIn) == 3)
                {
                    entityLivingBaseIn.addPotionEffect(new PotionEffect(ModPotion.TAMING, 1200));
                }
            }
        }
    }


    //tipped arrow effect
    public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier)
    {
        if(this == ModPotion.MONSTER_TAMING)
        {
            if(amplifier > 0){
                if(MonsterTame.getMonsterLevel(entityLivingBaseIn) == 1 || MonsterTame.getMonsterLevel(entityLivingBaseIn) == 2)
                {
                    if(entityLivingBaseIn.getHealth() > 0)
                    {
                        MonsterTame.SpawnFM(entityLivingBaseIn);
                    }
                }
            }
            else{
                if(MonsterTame.getMonsterLevel(entityLivingBaseIn) == 1)
                {
                    if(entityLivingBaseIn.getHealth() > 0)
                    {
                        MonsterTame.SpawnFM(entityLivingBaseIn);
                    }
                }
            }
        }

        else if(this == ModPotion.NETHER_TAMING)
        {
            if(amplifier > 0){
                if(MonsterTame.getMonsterLevel(entityLivingBaseIn) == 3 || MonsterTame.getMonsterLevel(entityLivingBaseIn) == 4)
                {
                    if(entityLivingBaseIn.getHealth() > 0)
                    {
                        MonsterTame.SpawnFM(entityLivingBaseIn);
                    }
                }
            }

            else{
                if(MonsterTame.getMonsterLevel(entityLivingBaseIn) == 3)
                {
                    if(entityLivingBaseIn.getHealth() > 0)
                    {
                        MonsterTame.SpawnFM(entityLivingBaseIn);
                    }
                }
            }
        }
    }

    private static final ResourceLocation TEXTURE = new ResourceLocation(MoMoFramework.MODID + ":textures/gui/potion.png");

    @Override
    public void renderInventoryEffect(int x, int y, PotionEffect e, Minecraft mc){
        mc.getTextureManager().bindTexture(TEXTURE);
        if(mc.currentScreen != null) {
//          if(this == ModPotion.NEW_POTION) mc.currentScreen.drawTexturedModalRect(x + 6, y + 7, 0, 0, 18, 18);
//          else if(this == ModPotion.NEW_INSTANT_POTION) mc.currentScreen.drawTexturedModalRect(x + 6, y + 7, 18, 0, 18, 18);
            if (this == ModPotion.TAMING) mc.currentScreen.drawTexturedModalRect(x + 6, y + 7, 0, 0, 18, 18);
        }
    }

    @Override
    public void renderHUDEffect(int x, int y, PotionEffect e, Minecraft mc, float alpha){
        mc.getTextureManager().bindTexture(TEXTURE);
        if(mc.currentScreen != null) {
//          if(this == ModPotion.NEW_POTION) mc.currentScreen.drawTexturedModalRect(x + 3, y + 3, 0, 0, 18, 18);
//          else if(this == ModPotion.NEW_INSTANT_POTION) mc.currentScreen.drawTexturedModalRect(x + 3, y + 3, 18, 0, 18, 18);
            if (this == ModPotion.TAMING) mc.currentScreen.drawTexturedModalRect(x + 3, y + 3, 0, 0, 18, 18);
        }
   }
}
