package net.chronos.chronosproject.config;

import net.minecraftforge.common.ForgeConfig;
import net.minecraftforge.common.ForgeConfigSpec;

public class ChronosProjectClientConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    static{
        BUILDER.push("Configs for ChronosProject");



        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
