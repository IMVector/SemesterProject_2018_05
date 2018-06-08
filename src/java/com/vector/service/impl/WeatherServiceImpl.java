/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.service.impl;

import com.vector.service.WeatherService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vector
 */
@Service
public class WeatherServiceImpl implements WeatherService {

    @Override
    public String getWeather(String city) {
        //http://localhost:8084/WeatherServerForSemesterProject/resources/weather

        URL url = null;
        HttpURLConnection conn = null;
        String weather = null;
        try {
            city = URLEncoder.encode(city, "utf-8");
            //city = URLEncoder.encode("青岛", "utf-8");
            String reqUrl = "http://localhost:8084/WeatherServerForSemesterProject/resources/weather/" + city;
            url = new URL(reqUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("accept", "application/json");
            InputStream is = conn.getInputStream();
            InputStreamReader stdin = new InputStreamReader(is, "utf-8");
            LineNumberReader input = new LineNumberReader(stdin);
            weather = input.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return weather;

    }

    @Override
    public String getCity(HttpServletRequest request) {
        String ip = null;
        String reqIp = null;
        reqIp = request.getHeader("x-forwarded-for");
        if (reqIp == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            reqIp = request.getHeader("Proxy-Client-IP");
        }
        if (reqIp == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            reqIp = request.getHeader("WL-Proxy-Client-IP");
        }
        if (reqIp == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            reqIp = request.getRemoteAddr();
        }
        ip = reqIp.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : reqIp;
        System.out.println(ip);
        JSONObject json = null;
        try {
            json = readJsonFromUrl("http://api.map.baidu.com/location/ip?ak=2LmotBogfTb7OzgTYECWumCyvam74CbV&ip=182.40.63.116");
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        String city = ((JSONObject) ((JSONObject) json.get("content")).get("address_detail")).get("city").toString();
        city = city.replace("市", "");
        return city;
    }

    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    private JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = JSONObject.fromObject(jsonText);
            return json;
        } finally {
            is.close();
            // System.out.println("同时 从这里也能看出 即便return了，仍然会执行finally的！");
        }
    }
}
