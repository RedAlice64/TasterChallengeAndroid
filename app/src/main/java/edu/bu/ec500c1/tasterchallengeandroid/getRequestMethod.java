package edu.bu.ec500c1.tasterchallengeandroid;

import android.os.AsyncTask;

import java.io.BufferedReader;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.URI;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.HttpResponse;
import java.io.InputStreamReader;
import java.security.KeyStore;

import org.apache.http.conn.scheme.Scheme;

import javax.net.ssl.SSLSocketFactory;

/**
 * Created by jmeunier28 on 11/3/15.
 */
public class getRequestMethod {

   public int getVideoID(int id) {
        int videoID = id;
        return id;

    }
    public String setVideoID(String id){
        String VideoName = id;
        return VideoName;
    }


    public void connectHTTP(int id, String VideoName) {
        //Use Async task to connect to the server

        class HttpGetAsyncTask extends AsyncTask<String, Void, String> {

            @Override
            protected String doInBackground(String... params) {
                String paramVideoName = params[0];
                System.out.println("The videoName is: " + paramVideoName);

                //create an intermediate to connect to the internet
                HttpClient httpClient = new DefaultHttpClient();
                HttpGet httpGet = new HttpGet("http://vid4kids.s3.amazonaws.com/" + paramVideoName);
                try {
                    HttpResponse httpResponse = httpClient.execute(httpGet);
                    InputStream inputStream = httpResponse.getEntity().getContent();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                    StringBuilder stringBuilder = new StringBuilder();

                    String bufferedStrChunk = null;

                    //will get response as a string value now
                    while ((bufferedStrChunk = bufferedReader.readLine()) != null) {
                        stringBuilder.append(bufferedStrChunk);
                    }
                    return stringBuilder.toString();

                    //}catch(ClientProtocolException cpe) {System.out.println("Exceptionrates caz of httpResponse :" + cpe);
                    //    cpe.printStackTrace();}
                } catch (IOException ioe) {
                    System.out.println("Secondption generates caz of httpResponse :" + ioe);
                    ioe.printStackTrace();
                }
                return null;
            }


        }
    }

   /* public String getInternetData() throws Exception {

       // new TrustAllManager();
       // new TrustAllSSLSocketFactory();

        BufferedReader in = null;
        String data = null;


        try {
            HttpClient client = new DefaultHttpClient();
            URI website = new URI("what ever my url is idkkkkk");
            HttpGet request = new HttpGet();
            request.setURI(website);
            HttpResponse response = client.execute(request);
            response.getStatusLine().getStatusCode();

            in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuffer sb = new StringBuffer("");
            String l = "";
            String nl = System.getProperty("line.separator");
            while ((l = in.readLine()) != null) {
                sb.append(l + nl);
            }
            in.close();
            data = sb.toString();
            return data;
        } finally {
            if (in != null) {
                try {
                    in.close();
                    return data;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }*/
}
