package de.htwg.se.setgame.clientProcessing;

/**
 * Created by Pavan on 29/06/2015.
 */

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClientProcessing {
    JSONObject jsonParam;
    DataOutputStream wr;
    BufferedReader rd;


    // HTTP GET request
    private String sendGet() throws Exception {
        String line="";
        String result = "";
        String url = "http://de-htwg-sa-highscores.herokuapp.com";
        try{
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);
            rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
            while ((line = rd.readLine()) != null) {
                result += line;
            }
            rd.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }



    // HTTP POST request
    private void sendPost(String gameName,String playerName,Long score) throws Exception {

        String url = "http://de-htwg-sa-highscores.herokuapp.com";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        jsonParam = new JSONObject();
        jsonParam.put("game", gameName);
        jsonParam.put("player", playerName);
        jsonParam.put("score", score);
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        con.setRequestProperty("charset", "utf-8");
        con.setRequestProperty("Content-Length", "" + Integer.toString(url.getBytes().length));
        con.setUseCaches (false);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        DataOutputStream wr = new DataOutputStream(con.getOutputStream ());
        con.setDoOutput(true);
        wr.writeBytes(jsonParam.toString());
        wr.flush();
        wr.close();

    }

}
