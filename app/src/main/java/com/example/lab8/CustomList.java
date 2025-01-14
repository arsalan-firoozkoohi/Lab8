package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    public int getCount(){
        return cities.size();
    }

    public void addCity(City city){
        cities.add(city);
    }

    /**
     * Checks to see if the list has the city
     * @param city
     * returns boolean
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * This deletes a city from the list if the city exists
     * @param city
     * removes
     */
    public void deleteCity(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     * Counts number of cities in list
     * @return
     * returns count
     */

    public int countCities() {
        return cities.size();
    }

}
