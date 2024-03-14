package net.hynse.tpsr.tps;

import org.bukkit.Bukkit;

public interface TpsProvider {
    TpsProvider DEFAULT = () -> {
        double[] tps = Bukkit.getTPS();
        return tps[0];
    };

    double getTpsCurrent();

    default double getTps15s() {
        return 0.0;
    }

    default double getTps5s() {
        return 0.0;
    }
}
