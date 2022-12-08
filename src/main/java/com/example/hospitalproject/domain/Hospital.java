package com.example.hospitalproject.domain;

import com.example.hospitalproject.domain.dto.HospitalResponse;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "nation_wide_hospitals")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Hospital {
    @Id
    private Integer id;
    private String open_service_name;
    private Integer open_local_government_code;
    private String management_number;
    private Timestamp license_date;
    private Integer business_status;
    private Integer business_status_code;
    private String phone;
    private String full_address;

    @Column(name = "road_name_address")
    private String roadNameAddress;

    @Column(name = "hospital_name")
    private String hospitalName;

    @Column(name = "business_type_name")
    private String businessTypeName;

    private Integer healthcare_provider_count;
    private Integer patient_room_count;

    @Column(name = "total_number_of_beds")
    private Integer totalNumberOfBeds;

    private float total_area_size;

    public static HospitalResponse of(Hospital hospital) {
        return new HospitalResponse(hospital.getId(), hospital.getRoadNameAddress(), hospital.getHospitalName(),
                hospital.getBusinessTypeName(), hospital.getPatient_room_count(), hospital.getTotalNumberOfBeds(),
                hospital.getTotal_area_size());
    }
}