package com.github.flyfor.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created on 2017. 8. 26..
 */
@Data
public class FlightParams {

    //편도 or 왕복
    public enum Itinerary {
        round,
        oneway
    }

    private Itinerary itinerary;

    // 가는 여정 출발 도시
    private String startCity1;

    // 가는 여정 도착 도시
    private String startCity2;

    // 돌아오는 여정 출발 도시
    private String endCity1;

    // 돌아오는 여정 도착 도시
    private String endCity2;

    // 가는 여정 날짜
    private long startDate1;

    // 오는 여정 날짜
    private long startDate2;

    // 어른 수
    private long adult;

    // 아이 수
    private long child;
}
