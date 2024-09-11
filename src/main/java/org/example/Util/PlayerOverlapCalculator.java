package org.example.Util;


import org.example.Entity.RecordE;

public class PlayerOverlapCalculator {

    public static int calculateOverlap(RecordE recordA, RecordE recordB) {
        int fromMinutesA = recordA.getFromMinutes();
        Integer toMinutesA = recordA.getToMinutes();
        if (toMinutesA == null) {
            toMinutesA = 90;
        }

        int fromMinutesB = recordB.getFromMinutes();
        Integer toMinutesB = recordB.getToMinutes();
        if (toMinutesB == null) {
            toMinutesB = 90;
        }

        int overlapStart = Math.max(fromMinutesA, fromMinutesB);
        int overlapEnd = Math.min(toMinutesA, toMinutesB);

        int overlapMinutes = 0;
        if (overlapEnd > overlapStart) {
            overlapMinutes = overlapEnd - overlapStart;
        }
        return overlapMinutes;
    }
}
