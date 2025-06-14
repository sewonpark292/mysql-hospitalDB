package kr.ac.kumoh.ce.s202004511.mysql_hospital.dto

import kr.ac.kumoh.ce.s202004511.mysql_hospital.AppointmentStatus
import java.time.LocalDate
import java.time.LocalDateTime

data class AppointmentDto(
    val appointmentId: Int,
    val patientId: Int,
    val doctorId: Int?,
    val nurseId: Int?,
    val departmentId: Int?,
    val appointmentDate: LocalDate?,
    val status: AppointmentStatus,
    val createdAt: LocalDateTime
)

data class AppointmentRequest(
    val patientId: Int,
    val doctorId: Int?,
    val nurseId: Int?,
    val departmentId: Int?,
    val appointmentDate: LocalDate?
)

