package fr.minemobs.flowerdecay;

import net.minecraft.stats.IStatFormatter;
import net.minecraft.stats.StatType;
import net.minecraft.stats.Stats;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class StatsInit {

    public static final DeferredRegister<StatType<?>> STAT_TYPES = DeferredRegister.create(ForgeRegistries.STAT_TYPES, FlowerDecay.MOD_ID);

    //public static final RegistryObject<StatType<ResourceLocation>> MANA_GENERATED = STAT_TYPES.register("mana_generated", () -> new StatType<>(Registry.CUSTOM_STAT));
    public static final ResourceLocation MANA_GENERATED = registerCustom("mana_generated", IStatFormatter.DEFAULT);

    private static ResourceLocation registerCustom(String key, IStatFormatter formatter) {
        ResourceLocation resourcelocation = new ResourceLocation(FlowerDecay.MOD_ID, key);
        Registry.register(Registry.CUSTOM_STAT, key, resourcelocation);
        Stats.CUSTOM.get(resourcelocation, formatter);
        return resourcelocation;
    }
}
