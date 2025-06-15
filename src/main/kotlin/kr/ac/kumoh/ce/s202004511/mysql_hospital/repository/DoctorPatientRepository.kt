package kr.ac.kumoh.ce.s202004511.mysql_hospital.repository

import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.DoctorPatientDto
import kr.ac.kumoh.ce.s202004511.mysql_hospital.DoctorPatient
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface DoctorPatientRepository : JpaRepository<DoctorPatient, Int> {
    @Query(
        "" +
                "SELECT dp.patientId " +
                "FROM DoctorPatient dp " +
                "WHERE dp.doctorId = :doctorId"
    )
    fun findPatientsIdByDoctorId(@Param("doctorId") doctorId: Int): List<Int>
}

