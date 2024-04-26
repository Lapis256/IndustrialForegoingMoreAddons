package io.github.lapis256.industrial_foregoing_more_addons.provider;

import com.buuz135.industrial.recipe.DissolutionChamberRecipe;
import com.hrznstudio.titanium.recipe.generator.IJSONGenerator;
import com.hrznstudio.titanium.recipe.generator.IJsonFile;
import com.hrznstudio.titanium.recipe.generator.TitaniumSerializableProvider;
import net.minecraft.data.DataGenerator;

import java.util.Map;


public class IFMASerializableProvider extends TitaniumSerializableProvider {
    public IFMASerializableProvider(DataGenerator generatorIn, String modId) {
        super(generatorIn, modId);
    }

    @Override
    public void add(Map<IJsonFile, IJSONGenerator> map) {
        DissolutionChamberRecipe.RECIPES.forEach((key) -> map.put(key, key));
    }
}
