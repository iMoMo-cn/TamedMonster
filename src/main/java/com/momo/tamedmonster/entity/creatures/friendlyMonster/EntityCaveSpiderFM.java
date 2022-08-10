package com.momo.tamedmonster.entity.creatures.friendlyMonster;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityCaveSpiderFM extends EntitySpiderFM {

    public EntityCaveSpiderFM(World worldIn)
    {
        super(worldIn);
        this.setSize(0.7F, 0.5F);
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0D);
    }

    public static void registerFixesCaveSpiderFM(DataFixer fixer) { EntityLiving.registerFixesMob(fixer, EntityCaveSpiderFM.class); }

    public float getEyeHeight() { return 0.45F; }

    @Nullable
    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return new EntityCaveSpiderFM(this.world);
    }
}
