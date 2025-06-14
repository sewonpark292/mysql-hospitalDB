package kr.ac.kumoh.ce.s202004511.mysql_hospital.dto

data class NursePatientDto(
    val identifyid: Int,
    val nurseId: Int,
    val patientId: Int
)

data class NursePatientRequest(
    val nurseId: Int,
    val patientId: Int
)