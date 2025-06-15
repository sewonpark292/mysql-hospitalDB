package kr.ac.kumoh.ce.s202004511.mysql_hospital.dto

data class NurseDto(
    val nurseId: Int,
    val name: String,
    val departmentId: Int?,
    val licenseNumber: String?
)

data class NurseRequest(
    val nurseId: Int,
    val name: String,
    val departmentId: Int?,
    val licenseNumber: String?
)
