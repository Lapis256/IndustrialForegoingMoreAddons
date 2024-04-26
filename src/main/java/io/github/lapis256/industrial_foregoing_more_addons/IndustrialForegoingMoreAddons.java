package io.github.lapis256.industrial_foregoing_more_addons;

import com.hrznstudio.titanium.module.ModuleController;
import io.github.lapis256.industrial_foregoing_more_addons.module.CoreModule;
import io.github.lapis256.industrial_foregoing_more_addons.provider.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Mod(IndustrialForegoingMoreAddons.MOD_ID)
public class IndustrialForegoingMoreAddons extends ModuleController {
    public static final String MOD_ID = "industrial_foregoing_more_addons";
    public static final String MOD_NAME = "Industrial Foregoing More Addons";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

    public static ResourceLocation rl(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    public static String tKey(String key) {
        return MOD_ID + "." + key;
    }

    @Override
    public void initModules() {
        new CoreModule().generateFeatures(this.getRegistries());

        this.addCreativeTab("tab", () -> new ItemStack(CoreModule.FORCE_BIOME_ADDON.get()), MOD_ID, CoreModule.TAB);
    }

    @Override
    public void addDataProvider(GatherDataEvent event) {
        super.addDataProvider(event);
        var generator = event.getGenerator();
        var output = generator.getPackOutput();
        var lookupProvider = event.getLookupProvider();
        var fileHelper = event.getExistingFileHelper();

        var blockTagsProvider = new IFMATagsProvider.Blocks(output, lookupProvider, MOD_ID, fileHelper);
        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(event.includeServer(), new IFMATagsProvider.Items(output, lookupProvider, blockTagsProvider.contentsGetter(), MOD_ID, fileHelper));
        generator.addProvider(event.includeServer(), new IFMARecipeProvider(generator));
        generator.addProvider(event.includeServer(), new IFMASerializableProvider(generator, MOD_ID));
        generator.addProvider(event.includeServer(), new IFMALanguageProvider(output, MOD_ID, "en_us"));

        generator.addProvider(event.includeClient(), new IFMAItemModelProvider(output, MOD_ID, fileHelper));
    }
}
