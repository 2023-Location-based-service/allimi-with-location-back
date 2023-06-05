package kr.ac.kumoh.allimi.service;

import kr.ac.kumoh.allimi.domain.Facility;
import kr.ac.kumoh.allimi.domain.User;
import kr.ac.kumoh.allimi.dto.facility.AddFacilityDTO;
import kr.ac.kumoh.allimi.dto.facility.EditFacilityDTO;
import kr.ac.kumoh.allimi.dto.facility.FacilityInfoDto;
import kr.ac.kumoh.allimi.exception.FacilityException;
import kr.ac.kumoh.allimi.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class FacilityService {
  private final FacilityRepository facilityRepository;

  public Long addFacility(AddFacilityDTO dto){ // name, address, tel, fm_name
    Facility facility = Facility.makeFacility(dto.getName(), dto.getAddress(), dto.getTel(), dto.getFm_name());
    facilityRepository.save(facility);

    return facility.getId();
  }

  public FacilityInfoDto getInfo(Long facilityId) throws Exception {
    Facility facility = facilityRepository.findById(facilityId)
            .orElseThrow(() -> new NoSuchElementException("해당하는 시설을 찾을 수 없음"));

    FacilityInfoDto dto = FacilityInfoDto.builder()
            .name(facility.getName())
            .tel(facility.getTel())
            .address(facility.getAddress())
            .fm_name(facility.getFmName())
            .build();

    return dto;
  }

  public Long editFacility(EditFacilityDTO dto) throws Exception { // facility_id, name, address, tel, fm_name
    Facility facility = facilityRepository.findById(dto.getFacility_id())
                    .orElseThrow(() -> new FacilityException("시설을 찾을 수 없음"));

    facility.edit(dto.getName(), dto.getAddress(), dto.getTel(), dto.getFm_name());

    return facility.getId();
  }

  @Transactional(readOnly = true)
  public Page<Facility> findAll(Pageable pageable) throws Exception {
    Page<Facility> facilities = facilityRepository.findAll(pageable);

    return facilities;
  }

  @Transactional(readOnly = true)
  public Page<Facility> findAllAdmin(Pageable pageable) throws Exception {
    int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
    pageable = PageRequest.of(page, 10);
    Page<Facility> facilities = facilityRepository.findAll(pageable);

    return facilities;
  }

  @Transactional(readOnly = true)
  public Page<Facility> getSearchFacility(String searchKeyword, Pageable pageable) {
    int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
    pageable = PageRequest.of(page, 10);

    Page<Facility> facilities = facilityRepository.findByNameContaining(searchKeyword, pageable).orElse(null);

    return facilities;
  }

  @Transactional
  public void deleteFacility(Long facility_id) throws Exception {
    facilityRepository.deleteById(facility_id);
  }
}
