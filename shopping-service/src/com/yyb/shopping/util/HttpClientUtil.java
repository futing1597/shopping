package com.yyb.shopping.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

public class HttpClientUtil {
    
    /**
     * �˴���Ҫ���ܻ�ȡ����ֵ
     * @param args
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static void main(String[] args) throws ClientProtocolException, IOException {
        
        // �����͑���
        CloseableHttpClient httpclient = HttpClients.createDefault();
        
        try {
            // Get����   �����POST�������t��HttpPost
            HttpPost httppost = new HttpPost("http://localhost:8080/Shopping/login/addUser");
            
            // ���ļ�
            //FileBody bin = new FileBody(new File(args[0]));
            //StringBody comment = new StringBody("A binary file of some kind", ContentType.TEXT_PLAIN);
            
            HttpEntityEnclosingRequestBase entity = (HttpEntityEnclosingRequestBase) httppost.getEntity();
            entity.setHeader("username", "lucy");
            Map<String, Object> param = new HashMap<>();
            param.put("username", "lucy");
            param.put("password", "123456");
            
            Gson gson = new Gson();
            //httppost.get
            
            BasicHttpEntity reqEntity = new BasicHttpEntity();
            //reqEntity.setContent(instream);

            httppost.setEntity(reqEntity);
            
            System.out.println("Executing request " + httppost.getRequestLine());

            // ����һ������ֵHandle
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

                @Override
                public String handleResponse(
                        final HttpResponse response) throws ClientProtocolException, IOException {
                    
                    // ��ȡ����״̬
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }

            };
            String responseBody = httpclient.execute(httppost, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        } finally {
            httpclient.close();
        }
    }
    
    /**
     * �˴���Ҫ����Ȩ
     * @throws Exception
     */
    public void ClientAuthentication() throws Exception {
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope("httpbin.org", 80),
                new UsernamePasswordCredentials("user", "passwd"));
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsProvider)
                .build();
        try {
            HttpGet httpget = new HttpGet("http://httpbin.org/basic-auth/user/passwd");

            System.out.println("Executing request " + httpget.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                System.out.println(EntityUtils.toString(response.getEntity()));
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
    }
}
