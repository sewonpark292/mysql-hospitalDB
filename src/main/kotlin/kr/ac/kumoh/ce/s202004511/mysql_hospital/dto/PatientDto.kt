package kr.ac.kumoh.ce.s202004511.mysql_hospital.dto

data class PatientDto(
    val patientId: Int,
    val name: String
)

data class PatientRequest(
    val patientId: Int,
    val name: String
)
