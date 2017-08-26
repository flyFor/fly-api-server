package com.github.flyfor.service;

import com.github.flyfor.model.ExternalApiResponse;
import com.github.flyfor.model.FlightParams;

/**
 * Created on 2017. 8. 26..
 */
public interface ExternalApiService {
    ExternalApiResponse getFlightInfo(FlightParams flightParams);
}
