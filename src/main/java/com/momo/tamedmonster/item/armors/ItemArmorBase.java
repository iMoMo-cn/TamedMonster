package com.momo.tamedmonster.item.armors;

import com.momo.tamedmonster.MoMoFramework;
import com.momo.tamedmonster.item.ModItems;
import com.momo.tamedmonster.util.IHasModel;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ItemArmorBase extends ItemArmor implements IHasModel {
    public ItemArmorBase(String name, ItemArmor.ArmorMaterial materialIn, EntityEquipmentSlot equipmentSlotIn)
    {
        super(materialIn, 0, equipmentSlotIn);
        setUnlocalizedName(name);
        setRegistryName(name);
        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        MoMoFramework.proxy.registerItemRenderer(this, 0, "inventory"); }
}
