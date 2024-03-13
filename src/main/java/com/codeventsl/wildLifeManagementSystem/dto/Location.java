package com.codeventsl.wildLifeManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Location {
    private String name;
    private String latitude;
    private String longitude;

    public Location( String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
