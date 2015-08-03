package com.amway.aws.utils;

import java.io.IOException;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.DefaultHttpClient;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

 
public class ApacheHttpPost {
    private static final String url="https://alert.victorops.com/integrations/generic/20131114/alert/xxxxxxxxxxxxxxxxxxxxxxxxxxxx/everyone";
 
    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

//        StringEntity stringEntity = new StringEntity(JsonUtils.toJson(myJsonObject));
//        httpPost.setEntity(stringEntity);

        httpPost.setHeader("Content-type", "application/json");
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            System.out.println(response.getStatusLine());
            HttpEntity entity2 = response.getEntity();
            EntityUtils.consume(entity2);
        } catch (Exception e) {
            System.out.println("Error");
        } finally {
//            response.close();
        }
    }
}
