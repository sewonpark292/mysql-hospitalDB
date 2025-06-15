package kr.ac.kumoh.ce.s202004511.mysql_hospital.repository

import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.PatientDto
import kr.ac.kumoh.ce.s202004511.mysql_hospital.Patient
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface PatientRepository : JpaRepository<Patient, Int> {
    @Query("SELECT new kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.PatientDto(p.patientId, p.name) FROM Patient p WHERE p.patientId IN :ids")
    fun findPatientDtosByIds(@Param("ids") ids: List<Int>): List<PatientDto>
}

