package net.chronos.chronosproject.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ChronosProjectCommonConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> CAKE_HUST_AMPLIFIER;
    public static final ForgeConfigSpec.ConfigValue<Integer> CAKE_HUST_DURATION;
    public static final ForgeConfigSpec.ConfigValue<Integer> CAKE_SWIFTNESS_AMPLIFIER;
    public static final ForgeConfigSpec.ConfigValue<Integer> CAKE_SWIFTNESS_DURATION;
    public static final ForgeConfigSpec.ConfigValue<Boolean> CAKE_IS_CONSUMABLE;
    public static final ForgeConfigSpec.ConfigValue<Boolean> CAKE_SHOULD_SELL;
    public static final ForgeConfigSpec.ConfigValue<Integer> CAKE_PRICE;

    static{
        BUILDER.push("Configs for ChronosProject");

        CAKE_HUST_AMPLIFIER = BUILDER.comment("Amplifier for hust effect after eating slice of cake").define("Cake Hust Amplifier", 2);
        CAKE_HUST_DURATION = BUILDER.comment("Duration of hust effect after eating slice of cake (in ticks(1s=20tick))").define("Cake Hust Duration", 18000);
        CAKE_SWIFTNESS_AMPLIFIER = BUILDER.comment("Amplifier for swiftness effect after eating slice of cake").define("Cake Swiftness Amplifier", 1);
        CAKE_SWIFTNESS_DURATION = BUILDER.comment("Duration of Swiftness effect after eating slice of cake (in ticks(1s=20tick)").define("Cake Swiftness Duration", 18000);
        CAKE_IS_CONSUMABLE = BUILDER.comment("'False' for infinite cake").define("Is Cake Consumable", Boolean.FALSE);
        CAKE_SHOULD_SELL = BUILDER.comment("Whether or not a farmer sells a slice of cake").define("Cake for sale", Boolean.TRUE);
        CAKE_PRICE = BUILDER.comment("Price of a slice of cake (in emerald blocks)").define("Cake Price", 16);


        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
