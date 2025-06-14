package kr.ac.kumoh.ce.s202004511.mysql_hospital

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MedicalRecordRepository : JpaRepository<MedicalRecord, Int> {
    fun findByPatientIdOrderByDateDesc(patientId: Int): List<MedicalRecord>
}