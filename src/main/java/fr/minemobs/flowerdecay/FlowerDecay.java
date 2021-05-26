package fr.minemobs.flowerdecay;

import fr.minemobs.flowerdecay.config.Config;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("flowerdecay")
public class FlowerDecay {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "flowerdecay";

    public FlowerDecay() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        StatsInit.STAT_TYPES.register(modEventBus);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.common_config);
        Config.loadConfig(Config.common_config, FMLPaths.CONFIGDIR.get().resolve(MOD_ID + "-common.toml").toString());
    }

}
