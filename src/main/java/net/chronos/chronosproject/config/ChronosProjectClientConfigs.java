package net.chronos.chronosproject.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ChronosProjectClientConfigs {
    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;

    static{
        BUILDER.push("Configs for ChronosProject");



        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
