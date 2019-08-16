package com.herculis.http;

import com.herculis.http.exception.HttpResponseException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractHttpCall {

    private static final Logger LOGGER = Logger.getLogger(AbstractHttpCall.class.getName());

    private static final int DEFAULT_CONNECTION_TIMEOUT = 5000;

    private static final int DEFAULT_READ_TIMEOUT = 5000;

    public HttpResponse doAction(String url, HttpMethod httpMethod, HttpRequest httpRequest){
        return this.doAction(url, httpMethod, httpRequest, DEFAULT_CONNECTION_TIMEOUT, DEFAULT_READ_TIMEOUT);
    }

    public HttpResponse doAction(String url, HttpMethod httpMethod, HttpRequest httpRequest, int connectionTimeout, int readTimeout){
        DataOutputStream dataOutputStream = null;
        HttpURLConnection urlConnection = null;

        HttpResponse response = null;
        try {
            urlConnection = this.createUrlConnection(url, httpMethod, connectionTimeout, readTimeout);
            if (httpRequest != null) {
                this.setHttpRequestHeaders(urlConnection, httpRequest);
            }

            if (httpMethod != HttpMethod.GET && httpRequest != null) {
                String requestParameter = httpRequest.getRawData();
                dataOutputStream = this.writeUrlDataConnection(urlConnection);
                dataOutputStream.write(requestParameter.getBytes());
            }

            int responseStatusCode = urlConnection.getResponseCode();
            String responseMessage = urlConnection.getResponseMessage();
            String responseBody = this.extractResponseBody(responseStatusCode, responseMessage, urlConnection);
            HttpResponseHeader responseHeader = this.prepareHttpResponseHeader(urlConnection);

            LOGGER.info("responseCode: " + responseStatusCode + ", responseBody: " + responseBody);
            response = new HttpResponse(responseStatusCode, responseMessage, responseBody, responseHeader);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        } finally {
            this.flushAndCloseDataOutputStream(dataOutputStream);
            this.disconnectHttpUrlConnection(urlConnection);
        }

        return response;
    }

    private HttpURLConnection createUrlConnection(String url, HttpMethod httpMethod, int connectionTimeout, int readTimeout) {
        HttpURLConnection urlConnection = null;

        try {
            URL targetUrl = new URL(url);
            urlConnection = (HttpURLConnection) targetUrl.openConnection();
            urlConnection.setRequestMethod(httpMethod.name());
            if (httpMethod != HttpMethod.GET) {
                urlConnection.setDoOutput(true);
            }
            urlConnection.setInstanceFollowRedirects(false);
            urlConnection.setUseCaches(false);
            urlConnection.setConnectTimeout(connectionTimeout);
            urlConnection.setReadTimeout(readTimeout);
        } catch (MalformedURLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        } catch (ProtocolException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }

        return urlConnection;
    }

    private DataOutputStream writeUrlDataConnection(HttpURLConnection urlConnection) {
        DataOutputStream dataOutputStream = null;
        try {
            dataOutputStream = new DataOutputStream(urlConnection.getOutputStream());
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }

        return dataOutputStream;
    }

    private void flushAndCloseDataOutputStream(DataOutputStream dataOutputStream) {
        if (dataOutputStream != null) {
            try {
                dataOutputStream.flush();
                dataOutputStream.close();
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, e.getMessage());
            }

        }
    }

    private void disconnectHttpUrlConnection(HttpURLConnection urlConnection) {
        if (urlConnection != null) {
            urlConnection.disconnect();
        }
    }

    private String extractResponseBody(int responseStatusCode, String responseMessage, HttpURLConnection urlConnection) {
        if (responseStatusCode > HttpURLConnection.HTTP_MULT_CHOICE - 1) {
            throw new HttpResponseException("Response Status: " + responseStatusCode + ", Response message:" + responseMessage);
        }

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream()));
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }

        String inputLine;
        StringBuilder sb = new StringBuilder();
        try {
            while (reader != null && ((inputLine = reader.readLine()) != null)) {
                sb.append(inputLine);
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }

        return String.valueOf(sb);
    }

    private HttpResponseHeader prepareHttpResponseHeader(HttpURLConnection urlConnection) {
        HttpResponseHeader httpResponseHeader = new HttpResponseHeader();

        for (Map.Entry<String, List<String>> header : urlConnection.getHeaderFields().entrySet()) {
            httpResponseHeader.addResponseHeader(header.getKey(), header.getValue());
        }
        return httpResponseHeader;
    }

	private void setHttpRequestHeaders(HttpURLConnection urlConnection, HttpRequest httpRequest) {
		Map<String, String> httpHeaders = httpRequest.getHttpHeaders();
		for (Map.Entry<String, String> entry : httpHeaders.entrySet()) {
			urlConnection.setRequestProperty(entry.getKey(), entry.getValue());
		}
	}

}
