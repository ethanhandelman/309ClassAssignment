package com.threezeronine;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.*;

/*
    Created by Team 3:
        Ethan Handelman
        Luis Rodriguez
        Devin Hadley
        Miro Haapalainen
 */
public class Weather extends JPanel {

    public Weather(String code) {
        setBackground(Color.GRAY);
        setLayout(new GridLayout(1,1));
        try {
            double value = getTemperature(code);
            add(new JLabel (" " + value));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private double getTemperature(String LocationKey) throws Exception {

        //String LocationKey = "331999"; // San Luis Obispo
        String apikey = "QVT4nid8IM60W3f3LMCG7NW0eKRbmsSf";
        String urlStr = "http://dataservice.accuweather.com/currentconditions/v1/"
                + LocationKey
                + "?apikey=" + apikey;

        URL url = new URL(urlStr);
        URLConnection connection = url.openConnection();
        InputStream inputStream = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        StringBuilder response = new StringBuilder();
        String inputLine = "";
        while ((inputLine = reader.readLine()) != null) {
            response.append(inputLine);
        }

        inputStream.close();
        return parse(response.toString());
    }

    private double parse (String response) {
        System.out.println(response);
        JSONArray jsonResponse = new JSONArray(response);
        JSONObject currentWeather = jsonResponse.getJSONObject(0);
        JSONObject temperature0bj = currentWeather.getJSONObject("Temperature");
        JSONObject metricObj = temperature0bj.getJSONObject("Metric");
        return metricObj.getDouble("Value");
    }



}
