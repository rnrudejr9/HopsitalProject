package com.example.hospitalproject.service;

import com.example.hospitalproject.domain.Hospital;
import com.example.hospitalproject.domain.dto.HospitalResponse;
import com.example.hospitalproject.repository.HospitalRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HospitalService {
    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public HospitalResponse getHospital(Integer id) {
        Optional<Hospital> optHospital = hospitalRepository.findById(id);   // Entity
        Hospital hospital = optHospital.get();
        HospitalResponse hospitalResponse = Hospital.of(hospital); // DTO

        // code에 맞는 이름으로 변경
        switch (hospital.getBusiness_status_code()){
            case 13:
                hospitalResponse.setBusinessStatusName("영업중");
                break;
            case 3:
                hospitalResponse.setBusinessStatusName("폐업");
                break;
            default:
                hospitalResponse.setBusinessStatusName(String.valueOf(hospital.getBusiness_status_code()));
        }

        return hospitalResponse;
    }
}