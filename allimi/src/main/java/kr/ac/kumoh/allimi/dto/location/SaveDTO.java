package kr.ac.kumoh.allimi.dto.location;

import lombok.Getter;

@Getter
public class SaveDTO {

    private Double lat;
    private Double lng;
    private String region;

    public SaveDTO(double lat, double lng, String region) {
        this.lat = lat;
        this.lng = lng;
        this.region = region;
    }
}
