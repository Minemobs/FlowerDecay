package fr.minemobs.flowerdecay.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class DecayConfig {

    public static ForgeConfigSpec.IntValue ticks;

    public static void init(ForgeConfigSpec.Builder common) {
        common.comment("Decay Config");
        ticks = common
                .comment("Decay time")
                .defineInRange("decay.time", 1200,20, Integer.MAX_VALUE);
    }

}
