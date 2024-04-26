package io.github.lapis256.industrial_foregoing_more_addons.module;

import com.buuz135.industrial.module.IModule;
import com.buuz135.industrial.module.ModuleCore;
import com.buuz135.industrial.utils.IndustrialTags;
import com.hrznstudio.titanium.fluid.TitaniumFluidInstance;
import com.hrznstudio.titanium.module.DeferredRegistryHelper;
import com.hrznstudio.titanium.tab.TitaniumTab;
import io.github.lapis256.industrial_foregoing_more_addons.IndustrialForegoingMoreAddons;
import io.github.lapis256.industrial_foregoing_more_addons.item.addon.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;


public class CoreModule implements IModule {
    public static final TitaniumTab TAB = new TitaniumTab(IndustrialForegoingMoreAddons.rl("tab"));
    public static final List<RegistryObject<Item>> ITEM_LIST = new ArrayList<>();

    public static RegistryObject<Item> FORCE_LENS_ADDON;
    public static RegistryObject<Item> FORCE_BIOME_ADDON;

    public static RegistryObject<Item> SPEED_ADDON_3;
    public static RegistryObject<Item> SPEED_ADDON_4;
    public static RegistryObject<Item> SPEED_ADDON_5;
    public static RegistryObject<Item> SPEED_ADDON_6;

    public static RegistryObject<Item> EFFICIENCY_ADDON_3;
    public static RegistryObject<Item> EFFICIENCY_ADDON_4;
    public static RegistryObject<Item> EFFICIENCY_ADDON_5;
    public static RegistryObject<Item> EFFICIENCY_ADDON_6;

    public static RegistryObject<Item> PROCESSING_ADDON_3;
    public static RegistryObject<Item> PROCESSING_ADDON_4;
    public static RegistryObject<Item> PROCESSING_ADDON_5;
    public static RegistryObject<Item> PROCESSING_ADDON_6;

    @Override
    public void generateFeatures(DeferredRegistryHelper helper) {
        FORCE_LENS_ADDON = registerItem(helper, "force_lens_addon", () -> new ForceLensAddonItem(TAB));
        FORCE_BIOME_ADDON = registerItem(helper, "force_biome_addon", () -> new ForceBiomeAddonItem(TAB));

        SPEED_ADDON_3 = registerItem(helper, "speed_addon_3", () -> new ExtraSpeedAddonItem(3, TAB));
        SPEED_ADDON_4 = registerItem(helper, "speed_addon_4", () -> new ExtraSpeedAddonItem(4, TAB));
        SPEED_ADDON_5 = registerItem(helper, "speed_addon_5", () -> new ExtraSpeedAddonItem(5, TAB));
        SPEED_ADDON_6 = registerItem(helper, "speed_addon_6", () -> new ExtraSpeedAddonItem(6, TAB));

        EFFICIENCY_ADDON_3 = registerItem(helper, "efficiency_addon_3", () -> new ExtraEfficiencyAddonItem(3, TAB));
        EFFICIENCY_ADDON_4 = registerItem(helper, "efficiency_addon_4", () -> new ExtraEfficiencyAddonItem(4, TAB));
        EFFICIENCY_ADDON_5 = registerItem(helper, "efficiency_addon_5", () -> new ExtraEfficiencyAddonItem(5, TAB));
        EFFICIENCY_ADDON_6 = registerItem(helper, "efficiency_addon_6", () -> new ExtraEfficiencyAddonItem(6, TAB));

        PROCESSING_ADDON_3 = registerItem(helper, "processing_addon_3", () -> new ExtraProcessingAddonItem(3, TAB));
        PROCESSING_ADDON_4 = registerItem(helper, "processing_addon_4", () -> new ExtraProcessingAddonItem(4, TAB));
        PROCESSING_ADDON_5 = registerItem(helper, "processing_addon_5", () -> new ExtraProcessingAddonItem(5, TAB));
        PROCESSING_ADDON_6 = registerItem(helper, "processing_addon_6", () -> new ExtraProcessingAddonItem(6, TAB));
    }

    private RegistryObject<Item> registerItem(DeferredRegistryHelper helper, String etherIngot, Supplier<Item> etherIngot1) {
        RegistryObject<Item> item = helper.registerGeneric(ForgeRegistries.ITEMS.getRegistryKey(), etherIngot, etherIngot1);
        ITEM_LIST.add(item);
        return item;
    }

    public static TagKey<Item> getGearFromAddonTier(int tier) {
        return tier % 2 == 0 ? IndustrialTags.Items.GEAR_DIAMOND : IndustrialTags.Items.GEAR_GOLD;
    }

    public static TitaniumFluidInstance getFluidFromAddonTier(int tier) {
        return switch ((tier + 1) / 2) {
            case 1 -> ModuleCore.LATEX;
            case 2 -> ModuleCore.PINK_SLIME;
            case 3 -> ModuleCore.ETHER;
            default -> throw new IllegalArgumentException("Invalid tier: " + tier);
        };
    }
}
