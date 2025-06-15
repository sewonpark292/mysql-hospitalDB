package kr.ac.kumoh.ce.s202004511.mysql_hospital.repository

import kr.ac.kumoh.ce.s202004511.mysql_hospital.NursePatient
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface NursePatientRepository : JpaRepository<NursePatient, Int> {
    @Query("SELECT np.patientId FROM NursePatient np WHERE np.nurseId = :nurseId")
    fun findPatientIdsByNurseId(@Param("nurseId") nurseId: Int): List<Int>
}

