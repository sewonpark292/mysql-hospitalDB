package kr.ac.kumoh.ce.s202004511.mysql_hospital

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DoctorPatientRepository : JpaRepository<DoctorPatient, Int> {
    fun findByDoctorId(doctorId: Int): List<DoctorPatient>
}