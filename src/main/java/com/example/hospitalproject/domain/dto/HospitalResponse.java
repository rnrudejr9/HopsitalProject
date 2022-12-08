package com.example.hospitalproject.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.sql.Timestamp;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HospitalResponse {
    private Integer id;

    @Column(name = "road_name_address")
    private String roadNameAddress;

    @Column(name = "hospital_name")
    private String hospitalName;

    @Column(name = "business_type_name")
    private String businessTypeName;

    private Integer patient_room_count;

    @Column(name = "total_number_of_beds")
    private Integer totalNumberOfBeds;

    private float total_area_size;

    public HospitalResponse(Integer id, String roadNameAddress, String hospitalName, String businessTypeName, Integer patient_room_count, Integer totalNumberOfBeds, float total_area_size) {
        this.id = id;
        this.roadNameAddress = roadNameAddress;
        this.hospitalName = hospitalName;
        this.businessTypeName = businessTypeName;
        this.patient_room_count = patient_room_count;
        this.totalNumberOfBeds = totalNumberOfBeds;
        this.total_area_size = total_area_size;
    }

    private String businessStatusName;

    public void setBusinessStatusName(String businessStatusName) {
        this.businessStatusName = businessStatusName;
    }
}