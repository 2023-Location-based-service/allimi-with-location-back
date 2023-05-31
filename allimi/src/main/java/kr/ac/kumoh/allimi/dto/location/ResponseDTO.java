package kr.ac.kumoh.allimi.dto.location;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseDTO {

    private String name;
    private String address;
    private String phone;
    private Double latitude;
    private Double longitude;
    private Boolean support;
}
