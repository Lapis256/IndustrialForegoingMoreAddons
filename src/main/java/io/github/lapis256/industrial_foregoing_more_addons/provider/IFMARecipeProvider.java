package io.github.lapis256.industrial_foregoing_more_addons.provider;

import com.hrznstudio.titanium.api.IRecipeProvider;
import com.hrznstudio.titanium.recipe.generator.TitaniumRecipeProvider;
import io.github.lapis256.industrial_foregoing_more_addons.module.CoreModule;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Consumer;


public class IFMARecipeProvider extends TitaniumRecipeProvider {
    public IFMARecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    private void registerRecipe(Consumer<FinishedRecipe> consumer, RegistryObject<?> item) {
        ((IRecipeProvider)item.get()).registerRecipe(consumer);
    }

    @Override
    public void register(Consumer<FinishedRecipe> consumer) {
        registerRecipe(consumer, CoreModule.FORCE_BIOME_ADDON);
        registerRecipe(consumer, CoreModule.FORCE_LENS_ADDON);

        registerRecipe(consumer, CoreModule.SPEED_ADDON_3);
        registerRecipe(consumer, CoreModule.SPEED_ADDON_4);
        registerRecipe(consumer, CoreModule.SPEED_ADDON_5);
        registerRecipe(consumer, CoreModule.SPEED_ADDON_6);

        registerRecipe(consumer, CoreModule.EFFICIENCY_ADDON_3);
        registerRecipe(consumer, CoreModule.EFFICIENCY_ADDON_4);
        registerRecipe(consumer, CoreModule.EFFICIENCY_ADDON_5);
        registerRecipe(consumer, CoreModule.EFFICIENCY_ADDON_6);

        registerRecipe(consumer, CoreModule.PROCESSING_ADDON_3);
        registerRecipe(consumer, CoreModule.PROCESSING_ADDON_4);
        registerRecipe(consumer, CoreModule.PROCESSING_ADDON_5);
        registerRecipe(consumer, CoreModule.PROCESSING_ADDON_6);
    }
}
