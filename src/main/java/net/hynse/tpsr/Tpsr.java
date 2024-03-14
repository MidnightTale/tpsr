package net.hynse.tpsr;

import org.bukkit.plugin.java.JavaPlugin;
import net.hynse.tpsr.tps.TpsProvider;
import net.hynse.tpsr.tps.FoliaTps;

public final class Tpsr extends JavaPlugin {

    private TpsProvider tpsProvider;

    @Override
    public void onEnable() {
        if (isFoliaAvailable()) {
            getLogger().info("Using Folia TPS provider.");
            tpsProvider = new FoliaTps();
            if (isPapiAvailable()) {
                getLogger().info("PlaceholderAPI is installed. Registering placeholders.");
                new TpsrPlaceholders(tpsProvider).register();
            } else {
                getLogger().warning("PlaceholderAPI is not installed. Placeholders will not be registered.");
            }
        } else {
            getLogger().info("Folia is not available. Using default TPS provider.");
            tpsProvider = TpsProvider.DEFAULT;
        }

        // Plugin startup logic
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private boolean isFoliaAvailable() {
        try {
            Class.forName("io.papermc.paper.threadedregions.RegionizedServer");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    private boolean isPapiAvailable() {
        return getServer().getPluginManager().getPlugin("PlaceholderAPI") != null;
    }
}
