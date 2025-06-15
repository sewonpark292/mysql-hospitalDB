package kr.ac.kumoh.ce.s202004511.mysql_hospital.dto

import kr.ac.kumoh.ce.s202004511.mysql_hospital.VerificationAction
import java.time.LocalDateTime

data class PatientVerificationLogDto(
    val logId: Int,
    val patientId: Int,
    val action: VerificationAction,
    val timestamp: LocalDateTime
)

data class PatientVerificationLogRequest(
    val patientId: Int,
    val action: VerificationAction
)
