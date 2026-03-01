package frc.robot.util;

import java.util.TreeMap;
import java.util.Map;

public class Interplut {
    private TreeMap<Double, Double> table = new TreeMap<>();

    public void addPoint(double distance, double value) {
        table.put(distance, value);
    }

    public double getInterpolatedValue(double currentDistance) {

        if (table.containsKey(currentDistance)) return table.get(currentDistance);

        Map.Entry<Double, Double> floor = table.floorEntry(currentDistance);
        Map.Entry<Double, Double> ceiling = table.ceilingEntry(currentDistance);

        if (floor == null) return ceiling.getValue();
        if (ceiling == null) return floor.getValue();


        return floor.getValue() + (currentDistance - floor.getKey()) *
                (ceiling.getValue() - floor.getValue()) /
                (ceiling.getKey() - floor.getKey());
    }
}