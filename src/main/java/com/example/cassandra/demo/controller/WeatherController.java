package com.example.cassandra.demo.controller;
import com.example.cassandra.demo.repository.WeatherRepository;

import com.example.cassandra.demo.ResouceNotFoundException;
import com.example.cassandra.demo.model.City;
import com.example.cassandra.demo.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;
@RestController
@RequestMapping("/api")
public class WeatherController {





        @Autowired
        WeatherRepository cityRepository;

        @PostMapping("/City")
        public City addcity(@RequestBody City city){
            cityRepository.save(city);
            return city;

        }

        @GetMapping("/City/{id}")
        public ResponseEntity<City> findById(@PathVariable("id") Integer cityId){
            City city=cityRepository.findById(cityId).orElseThrow(
                    () -> new ResouceNotFoundException("city not found" + cityId));
            return ResponseEntity.ok().body(city);
        }



        @GetMapping("/City")
        public List<City> getcitys(){

            return cityRepository.findAll();
        }

        @PutMapping("City/{id}")
        public ResponseEntity<City> updatecity(@PathVariable(value = "id") Integer cityId,
                                                     @RequestBody City cityDetails) {
            City city = cityRepository.findById(cityId)
                    .orElseThrow(() -> new ResouceNotFoundException("city not found for this id :: " + cityId));
            city.setName(cityDetails.getName());
            final City updatedcity = cityRepository.save(city);
            return ResponseEntity.ok(updatedcity);

        }

        @DeleteMapping("City/{id}")
        public ResponseEntity<Void> deletecity(@PathVariable(value = "id") Integer cityId) {
            City city = cityRepository.findById(cityId).orElseThrow(
                    () -> new ResouceNotFoundException("city not found::: " + cityId));
            cityRepository.delete(city);
            return ResponseEntity.ok().build();
        }




}
