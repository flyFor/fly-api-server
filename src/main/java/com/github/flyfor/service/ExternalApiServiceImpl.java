package com.github.flyfor.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.flyfor.model.ExternalApiResponse;
import com.github.flyfor.model.FlightParams;
import com.github.flyfor.util.HttpClientProxy;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.http.converter.json.JsonbHttpMessageConverter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2017. 8. 26..
 */
public class ExternalApiServiceImpl implements ExternalApiService {

    private String externalApiHost;
    private String externalApiToken;
    private HttpClientProxy httpClientProxy;

    public void setExternalApiHost(String externalApiHost) {
        this.externalApiHost = externalApiHost;
    }

    public void setExternalApiToken(String externalApiToken) {
        this.externalApiToken = externalApiToken;
    }

    public void setHttpClientProxy(HttpClientProxy httpClientProxy) {
        this.httpClientProxy = httpClientProxy;
    }

    @Override
    public ExternalApiResponse getFlightInfo(FlightParams flightParams) {
        List<NameValuePair> header = new ArrayList<>();
        header.add(new BasicNameValuePair("Authorization", "Basic " + externalApiToken));

        List<NameValuePair> params = convertToExternalApiParams(flightParams);

        String res = httpClientProxy.get(externalApiHost, header, params);
        ObjectMapper mapper = new ObjectMapper();

        try {
            // Convert JSON string from file to Object
            ExternalApiResponse externalApiResponse = mapper.readValue(res, ExternalApiResponse.class);

            return externalApiResponse;
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    ;

    private List<NameValuePair> convertToExternalApiParams(FlightParams flightParams) {
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("Adt", String.valueOf(flightParams.getAdult())));
        params.add(new BasicNameValuePair("Chd", String.valueOf(flightParams.getChild())));
        params.add(new BasicNameValuePair("ECITY1", flightParams.getEndCity1()));
        params.add(new BasicNameValuePair("SCITY1", flightParams.getStartCity1()));
        params.add(new BasicNameValuePair("SDATE1", String.valueOf(flightParams.getStartDate2())));


        if (flightParams.getItinerary() == FlightParams.Itinerary.round) {
            params.add(new BasicNameValuePair("ECITY2", flightParams.getEndCity2()));
            params.add(new BasicNameValuePair("SCITY2", flightParams.getStartCity2()));
            params.add(new BasicNameValuePair("SDATE2", String.valueOf(flightParams.getStartDate2())));
            params.add(new BasicNameValuePair("TRIP", "RT"));
        } else {
            params.add(new BasicNameValuePair("TRIP", "OW"));
        }


        params.add(new BasicNameValuePair("where", "pc"));
        params.add(new BasicNameValuePair("FareType", "YC"));
        params.add(new BasicNameValuePair("Inf", "0"));

        return params;
    }
}
