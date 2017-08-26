package com.github.flyfor.model;

import java.util.List;

/**
 * Created on 2017. 8. 26..
 */
public class SearchResult {
    List<FlightInfo> arrives;
    List<FlightInfo> departures;
    Min min;

    public class Min {
        long minDepFare;

        public long getMinDepFare() {
            return minDepFare;
        }

        public void setMinDepFare(long minDepFare) {
            this.minDepFare = minDepFare;
        }

        public long getMinArrFare() {
            return minArrFare;
        }

        public void setMinArrFare(long minArrFare) {
            this.minArrFare = minArrFare;
        }

        long minArrFare;
    }

    public List<FlightInfo> getArrives() {
        return arrives;
    }

    public void setArrives(List<FlightInfo> arrives) {
        this.arrives = arrives;
    }

    public List<FlightInfo> getDepartures() {
        return departures;
    }

    public void setDepartures(List<FlightInfo> departures) {
        this.departures = departures;
    }

    public Min getMin() {
        return min;
    }

    public void setMin(Min min) {
        this.min = min;
    }
}
