package kr.ac.kumoh.ce.s202004511.mysql_hospital

data class DoctorDto(
    val doctorId: Int?,
    val name: String,
    val departmentId: Int?,
    val licenseNumber: String?
)
