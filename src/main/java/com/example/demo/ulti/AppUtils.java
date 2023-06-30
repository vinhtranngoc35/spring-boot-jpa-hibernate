package com.example.demo.ulti;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class AppUtils {
    public static final ModelMapper mapper;

    static {
        mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }
}
