package kr.ac.kumoh.ce.s202004511.mysql_hospital

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
