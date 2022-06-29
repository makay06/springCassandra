package com.example.cassandra.demo.repository;

import com.example.cassandra.demo.model.City;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface WeatherRepository extends CassandraRepository<City,Integer> {
}
