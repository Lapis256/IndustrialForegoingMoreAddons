package io.github.lapis256.industrial_foregoing_more_addons.item.addon;

import com.buuz135.industrial.item.addon.EfficiencyAddonItem;
import com.buuz135.industrial.recipe.DissolutionChamberRecipe;
import com.hrznstudio.titanium.tab.TitaniumTab;
import io.github.lapis256.industrial_foregoing_more_addons.module.CoreModule;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Consumer;


public class ExtraEfficiencyAddonItem extends EfficiencyAddonItem {
    private final int tier;

    public ExtraEfficiencyAddonItem(int tier, TitaniumTab group) {
        super(tier, group);
        this.tier = tier;
    }

    @Override
    public void registerRecipe(Consumer<FinishedRecipe> consumer) {
        var tierMaterial = CoreModule.getGearFromAddonTier(tier);
        var fluid = CoreModule.getFluidFromAddonTier(tier);

        new DissolutionChamberRecipe(
                ForgeRegistries.ITEMS.getKey(this),
                new Ingredient.Value[]{
                        new Ingredient.ItemValue(new ItemStack(net.minecraft.world.item.Items.REDSTONE)),
                        new Ingredient.ItemValue(new ItemStack(net.minecraft.world.item.Items.REDSTONE)),
                        new Ingredient.ItemValue(new ItemStack(net.minecraft.world.item.Items.GLASS_PANE)),
                        new Ingredient.ItemValue(new ItemStack(net.minecraft.world.item.Items.GLASS_PANE)),
                        new Ingredient.TagValue(tierMaterial),
                        new Ingredient.TagValue(tierMaterial),
                        new Ingredient.ItemValue(new ItemStack(net.minecraft.world.item.Items.BLAZE_ROD)),
                        new Ingredient.ItemValue(new ItemStack(net.minecraft.world.item.Items.BLAZE_ROD))
                },
                new FluidStack(fluid.getSourceFluid().get(), 1000),
                200,
                new ItemStack(this),
                FluidStack.EMPTY
        );
    }
}
