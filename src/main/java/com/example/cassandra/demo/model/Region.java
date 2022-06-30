package com.example.cassandra.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;
import java.util.OptionalDouble;

public class Region {
    public   List<City> listCity;
    public OptionalDouble average;
}
