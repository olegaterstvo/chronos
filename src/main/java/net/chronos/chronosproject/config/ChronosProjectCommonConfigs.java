package net.chronos.chronosproject.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ChronosProjectCommonConfigs {
    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;

    public static final ModConfigSpec.ConfigValue<Integer> CAKE_HUST_AMPLIFIER;
    public static final ModConfigSpec.ConfigValue<Integer> CAKE_HUST_DURATION;
    public static final ModConfigSpec.ConfigValue<Integer> CAKE_SWIFTNESS_AMPLIFIER;
    public static final ModConfigSpec.ConfigValue<Integer> CAKE_SWIFTNESS_DURATION;
    public static final ModConfigSpec.ConfigValue<Boolean> CAKE_IS_CONSUMABLE;
    public static final ModConfigSpec.ConfigValue<Boolean> CAKE_SHOULD_SELL;
    public static final ModConfigSpec.ConfigValue<Integer> CAKE_PRICE;
//    public static final ModConfigSpec.ConfigValue<Integer> PICKAXE_DURABILITY;
//    public static final ModConfigSpec.ConfigValue<Float> PICKAXE_MINING_SPEED;

    static{
        BUILDER.push("Configs for ChronosProject");

        CAKE_HUST_AMPLIFIER = BUILDER.comment("Amplifier for hust effect after eating slice of cake").define("cakeHustAmplifier", 2);
        CAKE_HUST_DURATION = BUILDER.comment("Duration of hust effect after eating slice of cake (in ticks(1s=20tick))").define("cakeHustDuration", 18000);
        CAKE_SWIFTNESS_AMPLIFIER = BUILDER.comment("Amplifier for swiftness effect after eating slice of cake").define("cakeSwiftnessAmplifier", 1);
        CAKE_SWIFTNESS_DURATION = BUILDER.comment("Duration of Swiftness effect after eating slice of cake (in ticks(1s=20tick)").define("cakeSwiftnessDuration", 18000);
        CAKE_IS_CONSUMABLE = BUILDER.comment("'False' for infinite cake").define("Is Cake Consumable", Boolean.FALSE);
        CAKE_SHOULD_SELL = BUILDER.comment("Whether or not a farmer sells a slice of cake").define("cakeForSale", Boolean.TRUE);
        CAKE_PRICE = BUILDER.comment("Price of a slice of cake (in emerald blocks)").define("cakePrice", 16);

//        PICKAXE_DURABILITY = BUILDER.comment("Pickaxe Durability").define("pickaxeDurability", 10000);
//        PICKAXE_MINING_SPEED = BUILDER.comment("Pickaxe Durability").define("pickaxeMiningSpeed", 32f);


        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
