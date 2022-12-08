package com.example.hospitalproject.service;


import com.example.hospitalproject.domain.Hospital;
import com.example.hospitalproject.domain.User;
import com.example.hospitalproject.domain.Visit;
import com.example.hospitalproject.domain.dto.VisitCreateRequest;
import com.example.hospitalproject.exception.ErrorCode;
import com.example.hospitalproject.exception.HospitalReviewException;
import com.example.hospitalproject.repository.HospitalRepository;
import com.example.hospitalproject.repository.UserRepository;
import com.example.hospitalproject.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VisitService {

    private final VisitRepository visitRepository;
    private final HospitalRepository hospitalRepository;
    private final UserRepository userRepository;

    public void createVisit(VisitCreateRequest dto, String userName) {
        // hospital이 없을 때 등록 불가
        Hospital hospital = hospitalRepository.findById(dto.getHospitalId())
                .orElseThrow(() -> new HospitalReviewException(ErrorCode.HOSPITAL_NOT_FOUND, String.format("hospitalId:%s 가 없습니다.", dto.getHospitalId())));

        // user가 없을 때 등록 불가
        User user = userRepository.findByUsername(userName)
                .orElseThrow(() -> new HospitalReviewException(ErrorCode.USER_NOT_FOUND, String.format("'%s' user 가 없습니다.", userName)));

        Visit visit = Visit.builder()
                .user(user)
                .hospital(hospital)
                .disease(dto.getDisease())
                .amount(dto.getAmount())
                .build();
        visitRepository.save(visit);
    }
}