package kr.ac.kumoh.ce.s202004511.mysql_hospital.dto

import java.time.LocalDate
import java.time.LocalDateTime

data class MedicalRecordDto(
    val recordId: Int,
    val patientId: Int,
    val createdBy: Int,
    val date: LocalDate?,
    val diagnosis: String?,
    val description: String?,
    val treatment: String?,
    val recordType: String?,
    val lastUpdated: LocalDateTime
)

data class MedicalRecordRequest(
    val patientId: Int,
    val createdBy: Int,
    val date: LocalDate?,
    val diagnosis: String?,
    val description: String?,
    val treatment: String?,
    val recordType: String?
)

