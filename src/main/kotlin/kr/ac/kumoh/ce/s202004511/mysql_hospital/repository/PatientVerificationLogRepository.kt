package kr.ac.kumoh.ce.s202004511.mysql_hospital.repository

import kr.ac.kumoh.ce.s202004511.mysql_hospital.PatientVerificationLog
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PatientVerificationLogRepository : JpaRepository<PatientVerificationLog, Int>
