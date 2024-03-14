package net.hynse.tpsr.tps;

import io.papermc.paper.threadedregions.TickRegionScheduler;

public class FoliaTps implements TpsProvider {
    @Override
    public double getTpsCurrent() {
        return TickRegionScheduler.getCurrentRegion().getData().getRegionSchedulingHandle().getCurrentTick();
    }

    @Override
    public double getTps15s() {
        return TickRegionScheduler.getCurrentRegion().getData().getRegionSchedulingHandle().getTickReport15s(System.nanoTime()).tpsData().segmentAll().average();
    }

    @Override
    public double getTps5s() {
        return TickRegionScheduler.getCurrentRegion().getData().getRegionSchedulingHandle().getTickReport5s(System.nanoTime()).tpsData().segmentAll().average();
    }
}
