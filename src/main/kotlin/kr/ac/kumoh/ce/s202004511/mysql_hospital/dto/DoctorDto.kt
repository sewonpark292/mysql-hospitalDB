package kr.ac.kumoh.ce.s202004511.mysql_hospital.dto

data class DoctorDto(
    val doctorId: Int,
    val name: String,
    val departmentId: Int?,
    val licenseNumber: String?
)

data class DoctorRequest(
    val doctorId: Int,
    val name: String,
    val departmentId: Int?,
    val licenseNumber: String?
)

