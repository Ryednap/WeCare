package com.iot.backend.services.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class DataModel {
    private String envTemperature;
    private String envHumidity;
    private String bodyPulse;
    private String bodyTemperature;
}
