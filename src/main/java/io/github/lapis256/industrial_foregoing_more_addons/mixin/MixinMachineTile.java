package io.github.lapis256.industrial_foregoing_more_addons.mixin;

import com.hrznstudio.titanium.api.augment.IAugmentType;
import com.hrznstudio.titanium.block.tile.MachineTile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;


@Mixin(value = MachineTile.class, remap = false)
public abstract class MixinMachineTile {
    @Shadow
    public abstract boolean hasAugmentInstalled(IAugmentType augmentType);
}
