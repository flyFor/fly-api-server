package com.github.flyfor.service;

import com.github.flyfor.config.ApiServerConfig;
import com.github.flyfor.model.ExternalApiResponse;
import com.github.flyfor.model.FlightParams;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created on 2017. 8. 26..
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApiServerConfig.class})
public class ExternalApiServiceTest {

    @Autowired
    ExternalApiService externalApiService;


    @Test
    public void getFlightInfoTest() {
        FlightParams flightParams = new FlightParams();
        flightParams.setAdult(1);
        flightParams.setChild(0);
        flightParams.setEndCity1("CJU");
        flightParams.setStartCity1("ICN, GMP");
        flightParams.setItinerary(FlightParams.Itinerary.oneway);
        flightParams.setStartDate1(20170830);
        ExternalApiResponse externalApiResponse = externalApiService.getFlightInfo(flightParams);
        System.out.println(externalApiResponse.getSearchResult().getMin().getMinArrFare());
        assertNotNull(externalApiService.getFlightInfo(flightParams));

    }
}
