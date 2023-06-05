package kr.ac.kumoh.allimi.service;


import kr.ac.kumoh.allimi.domain.Location;
import kr.ac.kumoh.allimi.dto.location.ChangeDTO;
import kr.ac.kumoh.allimi.dto.location.ResponseDTO;
import kr.ac.kumoh.allimi.dto.location.SaveDTO;
import kr.ac.kumoh.allimi.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;

    // DB 저장용 서비스
    public void save() {
        List<Location> all = locationRepository.findAll();
        for (Location location : all) {
            String address = location.getAddress();
            int idx = address.indexOf('(');
            if (idx != -1)
                address = address.substring(0, idx);
//            SaveDTO saveDTO = getGeoDataByAddress(location.getAddress());
            SaveDTO saveDTO = getGeoDataByAddress(address);
            location.saveLatLng(saveDTO.getLat(), saveDTO.getLng(), saveDTO.getRegion(), address);
        }
    }

    private static SaveDTO getGeoDataByAddress(String address) {
        Double lat = 0.0, lng = 0.0;
        address = address.trim();
        String[] strings = address.split(" ");

        try {
            String API_KEY = "AIzaSyAMGh5-F_doU_fTq0DpFFdqz4rKKKy8to8";
            String urls = "https://maps.googleapis.com/maps/api/geocode/json?address=" + URLEncoder.encode(address, "UTF-8") + "&key=" + API_KEY;

            URL url = new URL(urls);
            InputStream is = url.openConnection().getInputStream();

            BufferedReader streamReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null) {
                responseStrBuilder.append(inputStr);
            }

            JSONObject jo = new JSONObject(responseStrBuilder.toString());
            JSONArray results = jo.getJSONArray("results");

            if(results.length() > 0) {
                JSONObject jsonObject;
                jsonObject = results.getJSONObject(0);

                lat = jsonObject.getJSONObject("geometry").getJSONObject("location").getDouble("lat");
                lng = jsonObject.getJSONObject("geometry").getJSONObject("location").getDouble("lng");
            }

//            System.out.println(address);
            return new SaveDTO(lat, lng, strings[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }

       return null;
    }

    // 실제 사용 서비스
    public List<ResponseDTO> getInfo(String city, String region) {
        List<Location> locations = locationRepository.findAllByCityAndRegion(city, region)
                .orElseThrow(() -> new RuntimeException("잘못된 요청"));

        List<ResponseDTO> responseDTOList = new ArrayList<>();

        for (Location location : locations) {
            responseDTOList.add(ResponseDTO.builder()
                    .name(location.getName())
                    .latitude(location.getLatitude())
                    .longitude(location.getLongitude())
                    .address(location.getAddress())
                    .support(location.getSupport())
                    .phone(location.getPhone()).build());
        }

        return responseDTOList;
    }

    public List<ResponseDTO> getSearch(String searchWord) {
        List<Location> locationList = locationRepository.findAllByNameContaining(searchWord)
                .orElseThrow(() -> new RuntimeException("검색 실패"));
        List<ResponseDTO> searchList = new ArrayList<>();

        for (Location location : locationList) {
            searchList.add(ResponseDTO.builder()
                    .name(location.getName())
                    .address(location.getAddress())
                    .phone(location.getPhone())
                    .latitude(location.getLatitude())
                    .longitude(location.getLongitude())
                    .support(location.getSupport()).build());
        }
        return searchList;
    }

    public void changeSupport(String name, String address) {
        Location location = locationRepository.findByNameAndAddress(name, address)
                .orElse(null);

        if (location != null)
            location.changeSupport();

    }
}
