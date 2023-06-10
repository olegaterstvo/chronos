package net.chronos.chronosproject.config;

import com.mojang.datafixers.util.Pair;
import net.chronos.chronosproject.ChronosProject;


public class ModConfigs {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;

    public static int CAKE_HUST_AMPLIFIER;
    public static int CAKE_HUST_DURATION;
    public static int CAKE_SWIFTNESS_AMPLIFIER;
    public static int CAKE_SWIFTNESS_DURATION;
    public static boolean CAKE_IS_CONSUMABLE;

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(ChronosProject.MOD_ID + "-config").provider(configs).request();

        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("cake.haste.amplifier", 2), "Amplifier for hust effect after eating slice of cake");
        configs.addKeyValuePair(new Pair<>("cake.haste.duration", 18000), "Duration of hust effect after eating slice of cake (in ticks(1s=20tick))");
        configs.addKeyValuePair(new Pair<>("cake.swiftness.amplifier", 1), "Amplifier for swiftness effect after eating slice of cake");
        configs.addKeyValuePair(new Pair<>("cake.swiftness.duration", 18000), "Duration of Swiftness effect after eating slice of cake (in ticks(1s=20tick)");
        configs.addKeyValuePair(new Pair<>("cake.is.consumable", Boolean.FALSE), "'False' for infinite cake");
    }

    private static void assignConfigs() {
        CAKE_HUST_AMPLIFIER = CONFIG.getOrDefault("cake.haste.amplifier",2);
        CAKE_HUST_DURATION = CONFIG.getOrDefault("cake.haste.duration", 18000);
        CAKE_SWIFTNESS_AMPLIFIER = CONFIG.getOrDefault("cake.swiftness.amplifier", 1);
        CAKE_SWIFTNESS_DURATION = CONFIG.getOrDefault("cake.swiftness.duration", 18000);
        CAKE_IS_CONSUMABLE = CONFIG.getOrDefault("cake.is.consumable", Boolean.FALSE);

        System.out.println("All " + configs.getConfigsList().size() + " have been set properly");
    }
}