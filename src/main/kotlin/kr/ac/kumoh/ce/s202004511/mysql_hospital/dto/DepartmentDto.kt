package kr.ac.kumoh.ce.s202004511.mysql_hospital.dto

data class DepartmentDto(
    val departmentId: Int,
    val deptName: String
)

data class DepartmentRequest(
    val deptName: String
)