package com.example.lab8;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCustomList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }


    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCustomList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    public void testHasCity(){
        CustomList cityList = MockCustomList();
        City city = new City("Charlottetown", "Prince Edward Island");
        assertFalse(cityList.hasCity(city));
        cityList.addCity(city);
        assertTrue(cityList.hasCity(city));
    }

    @Test
    public void testDeleteCity(){
        CustomList cityList = MockCustomList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.addCity(city);
        assertTrue(cityList.hasCity(city));
        cityList.deleteCity(city);
        assertFalse(cityList.hasCity(city));
    }

    @Test
    public void testCountCities(){
        CustomList cityList = MockCustomList();
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.addCity(city);
        assertEquals(1, cityList.countCities());
    }
    
}
