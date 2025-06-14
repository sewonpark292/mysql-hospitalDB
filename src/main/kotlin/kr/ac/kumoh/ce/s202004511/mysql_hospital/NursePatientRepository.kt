package kr.ac.kumoh.ce.s202004511.mysql_hospital

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NursePatientRepository : JpaRepository<NursePatient, Int> {
    fun findByNurseId(nurseId: Int): List<NursePatient>
}