package com.momo.tamedmonster.keys;

import com.momo.tamedmonster.MoMoFramework;
import com.momo.tamedmonster.proxy.ClientProxy;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.settings.IKeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;

//@SideOnly(Side.CLIENT)
public class ModKeyBinding extends KeyBinding {
    public ModKeyBinding(String description, IKeyConflictContext keyConflictContext, KeyModifier keyModifier, int keyCode, String category) {
        super(String.format("key.%s.%s", MoMoFramework.MODID, description), keyConflictContext, keyModifier, keyCode, category);
        ClientProxy.KEY_BINDINGS.add(this);
    }
}
