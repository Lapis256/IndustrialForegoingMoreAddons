package io.github.lapis256.industrial_foregoing_more_addons.provider;

import io.github.lapis256.industrial_foregoing_more_addons.IndustrialForegoingMoreAddons;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;


public class IFMALanguageProvider extends LanguageProvider {
    public IFMALanguageProvider(PackOutput output, String modId, String locale) {
        super(output, modId, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemGroup." + IndustrialForegoingMoreAddons.MOD_ID, "Industrial Foregoing More Addons");

        add(IndustrialForegoingMoreAddons.tKey("force_biome_addon"), "Force Biome");
        add(IndustrialForegoingMoreAddons.tKey("force_lens_addon"), "Force Lens");
    }
}
