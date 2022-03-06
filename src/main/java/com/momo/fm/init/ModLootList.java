package com.momo.fm.init;

import com.google.common.collect.Sets;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.LootTableManager;

import java.io.File;
import java.util.Collections;
import java.util.Set;

import static com.momo.fm.util.Reference.MOD_ID;

public class ModLootList {

        private static final Set<ResourceLocation> LOOT_TABLES = Sets.<ResourceLocation>newHashSet();
        private static final Set<ResourceLocation> READ_ONLY_LOOT_TABLES = Collections.<ResourceLocation>unmodifiableSet(LOOT_TABLES);
        public static final ResourceLocation EMPTY = register("empty");

        //public static final ResourceLocation MOB = register("entities/mob");
        public static final ResourceLocation ENTITY_ZOMBIE_FM = register("entities/zombie_fm");
        public static final ResourceLocation ENTITY_SKELETON_FM = register("entities/skeleton_fm");
        public static final ResourceLocation ENTITY_SPIDER_FM = register("entities/spider_fm");
        public static final ResourceLocation ENTITY_CREEPER_FM = register("entities/creeper_fm");
        public static final ResourceLocation ENTITY_WITHER_SKELETON_FM = register("entities/wither_skeleton_fm");
        public static final ResourceLocation ENTITY_ENDERMAN_FM = register("entities/enderman_fm");
        public static final ResourceLocation ENTITY_ZOMBIE_PIG_FM = register("entities/pig_zombie_fm");
        public static final ResourceLocation ENTITY_SLIME_FM = register("entities/slime_fm");
        public static final ResourceLocation ENTITY_MAGMA_CUBE_FM = register("entities/magma_cube_fm");
        public static final ResourceLocation ENTITY_BLAZE_FM = register("entities/blaze_fm");


        private static ResourceLocation register(String id)
        {
            return register(new ResourceLocation(MOD_ID, id));
        }

        public static ResourceLocation register(ResourceLocation id)
        {
            if (LOOT_TABLES.add(id))
            {
                return id;
            }
            else
            {
                throw new IllegalArgumentException(id + " is already a registered modded loot table");
            }
        }

        /**
         * An unmodifiable set is returned
         */
        public static Set<ResourceLocation> getAll()
        {
            return READ_ONLY_LOOT_TABLES;
        }

        public static boolean test()
        {
            LootTableManager loottablemanager = new LootTableManager((File)null);

            for (ResourceLocation resourcelocation : READ_ONLY_LOOT_TABLES)
            {
                if (loottablemanager.getLootTableFromLocation(resourcelocation) == LootTable.EMPTY_LOOT_TABLE)
                {
                    return false;
                }
            }

            return true;
        }

}
