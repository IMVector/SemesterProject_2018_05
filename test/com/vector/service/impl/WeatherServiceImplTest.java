/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.service.impl;

import javax.servlet.http.HttpServletRequest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vector
 */
public class WeatherServiceImplTest {
    
    public WeatherServiceImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getWeather method, of class WeatherServiceImpl.
     */
    @Test
    public void testGetWeather() {
//        System.out.println("getWeather");
//        String city = "";
//        WeatherServiceImpl instance = new WeatherServiceImpl();
//        String expResult = "";
//        String result = instance.getWeather(city);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getCity method, of class WeatherServiceImpl.
     */
    @Test
    public void testGetCity() {
        System.out.println("getCity");
        HttpServletRequest request = null;
        WeatherServiceImpl instance = new WeatherServiceImpl();
        String expResult = "";
        String result = instance.getCity(request);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
