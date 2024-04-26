package io.github.lapis256.industrial_foregoing_more_addons.provider;

import com.buuz135.industrial.module.ModuleCore;
import io.github.lapis256.industrial_foregoing_more_addons.IFMATags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;


public class IFMATagsProvider {
    public static class Blocks extends BlockTagsProvider {
        public Blocks(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, lookupProvider, modId, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.@NotNull Provider provider) {}
    }

    public static class Items extends ItemTagsProvider {
        public Items(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, String modId, ExistingFileHelper existingFileHelper) {
            super(pOutput, pLookupProvider, pBlockTags, modId, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.@NotNull Provider provider) {
            var lensTag = tag(IFMATags.LENS);
            for (var lens : ModuleCore.LASER_LENS) {
                lensTag.add(lens.get());
            }
        }
    }
}
