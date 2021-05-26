package fr.minemobs.flowerdecay;

import net.minecraft.stats.StatType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class StatsInit {

    public static final DeferredRegister<StatType<?>> STAT_TYPES = DeferredRegister.create(ForgeRegistries.STAT_TYPES, FlowerDecay.MOD_ID);

    public static final RegistryObject<StatType<ResourceLocation>> MANA_GENERATED = STAT_TYPES.register("mana_generated", () -> new StatType<>(Registry.CUSTOM_STAT));
}
