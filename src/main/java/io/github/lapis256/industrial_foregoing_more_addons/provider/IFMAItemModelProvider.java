package io.github.lapis256.industrial_foregoing_more_addons.provider;

import io.github.lapis256.industrial_foregoing_more_addons.module.CoreModule;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;


public class IFMAItemModelProvider extends ItemModelProvider {
    public IFMAItemModelProvider(PackOutput output, String modId, ExistingFileHelper existingFileHelper) {
        super(output, modId, existingFileHelper);
    }

    public ItemModelBuilder basicItem(RegistryObject<Item> item) {
        return super.basicItem(item.get());
    }

    @Override
    protected void registerModels() {
        basicItem(CoreModule.FORCE_BIOME_ADDON);
        basicItem(CoreModule.FORCE_LENS_ADDON);

        basicItem(CoreModule.SPEED_ADDON_3);
        basicItem(CoreModule.SPEED_ADDON_4);
        basicItem(CoreModule.SPEED_ADDON_5);
        basicItem(CoreModule.SPEED_ADDON_6);

        basicItem(CoreModule.EFFICIENCY_ADDON_3);
        basicItem(CoreModule.EFFICIENCY_ADDON_4);
        basicItem(CoreModule.EFFICIENCY_ADDON_5);
        basicItem(CoreModule.EFFICIENCY_ADDON_6);

        basicItem(CoreModule.PROCESSING_ADDON_3);
        basicItem(CoreModule.PROCESSING_ADDON_4);
        basicItem(CoreModule.PROCESSING_ADDON_5);
        basicItem(CoreModule.PROCESSING_ADDON_6);
    }
}
