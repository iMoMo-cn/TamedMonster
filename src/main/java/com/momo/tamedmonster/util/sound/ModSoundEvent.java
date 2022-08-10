package com.momo.tamedmonster.util.sound;

import com.momo.tamedmonster.util.ModSoundHandler;
import com.momo.tamedmonster.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class ModSoundEvent extends SoundEvent {
    public ModSoundEvent(String path) {
        super(new ResourceLocation(Reference.MOD_ID, path));
        ModSoundHandler.SOUNDS.add(this);
        setRegistryName(path);
    }
}
