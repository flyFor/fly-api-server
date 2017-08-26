package com.github.flyfor.util;

import org.apache.commons.io.IOUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created on 2017. 8. 26..
 */
public class HttpClientProxy {

    private static final Logger LOG = Logger.getLogger(HttpClientProxy.class);

    private static final int MAX_TOTAL_CONNECTIONS = 100;
    private static final int MAX_HOST_CONNECTIONS = 50;

    public static PoolingHttpClientConnectionManager cm;
    public static CloseableHttpClient httpclient;

    public HttpClientProxy() {
        cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(MAX_TOTAL_CONNECTIONS);
        cm.setDefaultMaxPerRoute(MAX_HOST_CONNECTIONS);

        httpclient = HttpClients
                .custom()
                .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36")
                .setConnectionManager(cm)
                .disableCookieManagement()
                .build();
    }

    public static void closeAll() {
        try {
            httpclient.close();
            cm.close();
        } catch (Exception e) {
            LOG.error("", e);
        }
    }

    public String get(String url, List<NameValuePair> headers, List<NameValuePair> parameters) {

        try {
            String paramString = URLEncodedUtils.format(parameters, "utf-8");

            url += "?" + paramString;

            HttpGet method = new HttpGet(url);

            for (NameValuePair keyAndValue : headers) {
                method.setHeader(keyAndValue.getName(), keyAndValue.getValue());
            }

            return handleResponseToString(method);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    public String post(String url, List<NameValuePair> headers, List<NameValuePair> parameters) {
        try {
            HttpPost method = new HttpPost(url);

            for (NameValuePair keyAndValue : headers) {
                method.setHeader(keyAndValue.getName(), keyAndValue.getValue());
            }

            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(parameters);
            entity.setContentType("application/json;charset=UTF-8");
            method.setEntity(entity);

            return handleResponseToString(method);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private String handleResponseToString(HttpUriRequest request) {
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(request);


            try (InputStream content = response.getEntity().getContent()) {
                String text = IOUtils.toString(content, "UTF-8");
                return text;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(response);
        }

    }
}
