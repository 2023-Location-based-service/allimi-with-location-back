package kr.ac.kumoh.allimi.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "facilityInfo")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String phone;
    private Double latitude;
    private Double longitude;
    private Boolean support;
    private String city;
    private String region;

    public void saveLatLng(Double lat, Double lng, String region, String address) {
        this.latitude = lat;
        this.longitude = lng;
        this.support = false;
        this.region = region;
        this.address = address;
    }

    public void changeSupport() {
        this.support = true;
    }
}