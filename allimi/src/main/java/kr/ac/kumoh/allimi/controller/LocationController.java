package kr.ac.kumoh.allimi.controller;

import kr.ac.kumoh.allimi.dto.location.ChangeDTO;
import kr.ac.kumoh.allimi.dto.location.RequestDTO;
import kr.ac.kumoh.allimi.dto.location.ResponseDTO;
import kr.ac.kumoh.allimi.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;

    @GetMapping("/save")
    public ResponseEntity saveLatLng() throws Exception {
        locationService.save();

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/find")
    public ResponseEntity findNH(@RequestBody RequestDTO requestDTO) throws Exception {
        List<ResponseDTO> responseList = locationService.getInfo(requestDTO.getCity(), requestDTO.getRegion());

        return ResponseEntity.status(HttpStatus.OK).body(responseList);
    }

    @PostMapping("/search")
    public ResponseEntity searchNH(@RequestBody Map<String, String> search) throws Exception {
        String searchWord = search.get("search_word");
        List<ResponseDTO> responseList = locationService.getSearch(searchWord);

        return ResponseEntity.status(HttpStatus.OK).body(responseList);
    }

}