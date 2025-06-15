package kr.ac.kumoh.ce.s202004511.mysql_hospital.repository

import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.PatientVerificationLogDto
import kr.ac.kumoh.ce.s202004511.mysql_hospital.PatientVerificationLog
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface PatientVerificationLogRepository : JpaRepository<PatientVerificationLog, Int> {
    @Query("SELECT new kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.PatientVerificationLogDto(l.logId, l.patientId, l.action, l.timestamp) FROM PatientVerificationLog l WHERE l.patientId = :patientId ORDER BY l.timestamp DESC")
    fun findAllByPatientId(@Param("patientId") patientId: Int): List<PatientVerificationLogDto>

    @Query("SELECT new kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.PatientVerificationLogDto(l.logId, l.patientId, l.action, l.timestamp) FROM PatientVerificationLog l")
    fun findAllLogDtos(): List<PatientVerificationLogDto>
}
