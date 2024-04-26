package io.github.lapis256.industrial_foregoing_more_addons.item.addon;

import com.buuz135.industrial.item.addon.AddonItem;
import com.buuz135.industrial.module.ModuleCore;
import com.buuz135.industrial.recipe.DissolutionChamberRecipe;
import com.buuz135.industrial.utils.IndustrialTags;
import com.hrznstudio.titanium.api.ISpecialCreativeTabItem;
import com.hrznstudio.titanium.api.augment.IAugmentType;
import com.hrznstudio.titanium.item.AugmentWrapper;
import com.hrznstudio.titanium.tab.TitaniumTab;
import io.github.lapis256.industrial_foregoing_more_addons.IndustrialForegoingMoreAddons;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;


public class ForceBiomeAddonItem extends AddonItem implements ISpecialCreativeTabItem {
    public static final IAugmentType FORCE_BIOME = () -> "ForceBiome";

    public ForceBiomeAddonItem(TitaniumTab group) {
        super("force_biome_addon", group, new Properties().stacksTo(16));
    }

    @Override
    public void onCraftedBy(@NotNull ItemStack stack, @NotNull Level level, @NotNull Player player) {
        super.onCraftedBy(stack, level, player);
        AugmentWrapper.setType(stack, FORCE_BIOME, 1f);
    }

    @Override
    public void registerRecipe(Consumer<FinishedRecipe> consumer) {
        new DissolutionChamberRecipe(
                ForgeRegistries.ITEMS.getKey(this),
                new Ingredient.Value[]{
                        new Ingredient.ItemValue(new ItemStack(Items.NETHERITE_BLOCK)),
                        new Ingredient.ItemValue(new ItemStack(Items.NETHERITE_BLOCK)),
                        new Ingredient.ItemValue(new ItemStack(Items.REDSTONE)),
                        new Ingredient.ItemValue(new ItemStack(Items.GLASS_PANE)),
                        new Ingredient.TagValue(IndustrialTags.Items.GEAR_DIAMOND),
                        new Ingredient.TagValue(IndustrialTags.Items.GEAR_DIAMOND),
                        new Ingredient.ItemValue(new ItemStack(Items.NETHER_STAR)),
                        new Ingredient.ItemValue(new ItemStack(Items.NETHER_STAR))
                },
                new FluidStack(ModuleCore.ETHER.getSourceFluid().get(), 8000),
                200,
                new ItemStack(this),
                FluidStack.EMPTY
        );
    }

    @Override
    public @NotNull String getDescriptionId() {
        String prefix = Component.translatable("item.industrialforegoing.addon").getString();
        return prefix + Component.translatable(IndustrialForegoingMoreAddons.tKey("force_biome_addon")).getString();
    }

    @Override
    public void addToTab(BuildCreativeModeTabContentsEvent event) {
        ItemStack stack = new ItemStack(this);
        AugmentWrapper.setType(stack, FORCE_BIOME, 1f);
        event.accept(stack);
    }
}
