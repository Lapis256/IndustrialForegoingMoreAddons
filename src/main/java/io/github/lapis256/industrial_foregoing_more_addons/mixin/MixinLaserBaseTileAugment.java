package io.github.lapis256.industrial_foregoing_more_addons.mixin;

import com.buuz135.industrial.block.resourceproduction.tile.OreLaserBaseTile;
import com.hrznstudio.titanium.api.augment.IAugmentType;
import com.hrznstudio.titanium.item.AugmentWrapper;
import io.github.lapis256.industrial_foregoing_more_addons.item.addon.ForceBiomeAddonItem;
import io.github.lapis256.industrial_foregoing_more_addons.item.addon.ForceLensAddonItem;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(value = OreLaserBaseTile.class, remap = false)
public abstract class MixinLaserBaseTileAugment extends MixinMachineTile {
    @Unique
    private boolean industrialForegoingMoreAddons$checkAugment(ItemStack augment, IAugmentType augmentType) {
        return AugmentWrapper.hasType(augment, augmentType) && hasAugmentInstalled(augmentType);
    }

    @Inject(method = "canAcceptAugment", at = @At("HEAD"), cancellable = true)
    public void injectCanAcceptAugment(ItemStack augment, CallbackInfoReturnable<Boolean> cir) {
        if(
                industrialForegoingMoreAddons$checkAugment(augment, ForceLensAddonItem.FORCE_LENS) ||
                industrialForegoingMoreAddons$checkAugment(augment, ForceBiomeAddonItem.FORCE_BIOME)
        ) {
            cir.setReturnValue(true);
        }
    }
}
