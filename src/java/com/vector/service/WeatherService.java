/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.service;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Vector
 */
public interface WeatherService {
    public String getWeather(String city);
    public String getCity(HttpServletRequest request);
}
