package kr.ac.kumoh.ce.s202004511.mysql_hospital.repository

import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.DoctorDto
import kr.ac.kumoh.ce.s202004511.mysql_hospital.Doctor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface DoctorRepository : JpaRepository<Doctor, Int> {
    @Query("SELECT new kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.DoctorDto(" +
            "d.doctorId, " +
            "d.name, " +
            "d.departmentId, " +
            "d.licenseNumber" +
            ") " +
            "FROM Doctor d " +
            "WHERE d.doctorId = :doctorId")
    fun findDoctorDtoById(@Param("doctorId") doctorId: Int): DoctorDto?

    @Query("SELECT new kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.DoctorDto(d.doctorId, d.name, d.departmentId, d.licenseNumber) FROM Doctor d")
    fun findAllDoctorDtos(): List<DoctorDto>
}
