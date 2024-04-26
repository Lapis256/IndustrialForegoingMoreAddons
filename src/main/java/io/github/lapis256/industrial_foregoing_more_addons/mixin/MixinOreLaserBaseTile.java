package io.github.lapis256.industrial_foregoing_more_addons.mixin;

import com.buuz135.industrial.block.resourceproduction.tile.OreLaserBaseTile;
import com.buuz135.industrial.recipe.LaserDrillOreRecipe;
import com.buuz135.industrial.recipe.LaserDrillRarity;
import com.hrznstudio.titanium.component.inventory.SidedInventoryComponent;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import io.github.lapis256.industrial_foregoing_more_addons.item.addon.ForceBiomeAddonItem;
import io.github.lapis256.industrial_foregoing_more_addons.item.addon.ForceLensAddonItem;
import it.unimi.dsi.fastutil.objects.ObjectIntPair;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

import javax.annotation.Nullable;
import java.util.Arrays;


@Mixin(value = OreLaserBaseTile.class, remap = false)
public abstract class MixinOreLaserBaseTile extends MixinMachineTile {
    @Shadow
    private SidedInventoryComponent<OreLaserBaseTile> lens;

    @ModifyReturnValue(method = "lambda$onWork$8", at = @At("RETURN"))
    private @Nullable ObjectIntPair<LaserDrillOreRecipe> injectForceLens(
            @Nullable ObjectIntPair<LaserDrillOreRecipe> original,
            @Local(ordinal = 0, argsOnly = true) LaserDrillOreRecipe recipe,
            @Nullable @Local(ordinal = 0) LaserDrillRarity recipeRarity
    ) {
        if(recipeRarity == null || !hasAugmentInstalled(ForceLensAddonItem.FORCE_LENS)) {
            return original;
        }

        for (int i = 0; i < lens.getSlots(); i++) {
            if (recipe.catalyst.test(lens.getStackInSlot(i))) {
                return ObjectIntPair.of(recipe, recipeRarity.weight);
            }
        }
        return null;
    }

    @ModifyReturnValue(method = "lambda$onWork$8", at = @At("RETURN"))
    private @Nullable ObjectIntPair<LaserDrillOreRecipe> injectForceWhitelist(
            @Nullable ObjectIntPair<LaserDrillOreRecipe> original,
            @Local(ordinal = 0, argsOnly = true) LaserDrillOreRecipe recipe,
            @Local(ordinal = 0, argsOnly = true) ResourceKey<Biome> biomeResourceKey,
            @Nullable @Local(ordinal = 0) LaserDrillRarity recipeRarity
    ) {
        if (recipeRarity == null || !hasAugmentInstalled(ForceBiomeAddonItem.FORCE_BIOME)) {
            return original;
        }

        if(Arrays.asList(recipeRarity.whitelist).contains(biomeResourceKey)) {
            return original;
        }

        return null;
    }
}
