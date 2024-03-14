package net.hynse.tpsr;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import net.hynse.tpsr.Tpsr;
import net.hynse.tpsr.tps.TpsProvider;
import org.bukkit.OfflinePlayer;

public class TpsrPlaceholders extends PlaceholderExpansion {

    private final TpsProvider tpsProvider;

    public TpsrPlaceholders(TpsProvider tpsProvider) {
        this.tpsProvider = tpsProvider;
    }

    @Override
    public boolean persist() {
        // Return true if you want these placeholders to persist through server restarts
        return true;
    }

    @Override
    public boolean canRegister() {
        // Return true if this expansion can be registered
        return true;
    }

    @Override
    public String getAuthor() {
        // Return the author of this expansion
        return "MidnightTale";
    }

    @Override
    public String getIdentifier() {
        // Return the unique identifier of this expansion
        return "tpsr";
    }

    @Override
    public String getVersion() {
        // Return the version of this expansion
        return "1.0";
    }

    @Override
    public String onRequest(OfflinePlayer player, String identifier) {
        // Check if the requested placeholder is one of ours
        if (identifier.equals("region")) {
            return String.valueOf(tpsProvider.getTpsCurrent());
        } else if (identifier.equals("region_15")) {
            return String.valueOf(tpsProvider.getTps15s());
        } else if (identifier.equals("region_5")) {
            return String.valueOf(tpsProvider.getTps5s());
        }

        return null;
    }
}
