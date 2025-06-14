package kr.ac.kumoh.ce.s202004511.mysql_hospital

import kr.ac.kumoh.ce.s202004511.mysql_hospital.Gender
import kr.ac.kumoh.ce.s202004511.mysql_hospital.Role

data class UserDto(
    val userId: Int,
    val username: String,
    val birthDate: String?,
    val phone: String?,
    val contactInfo: String?,
    val gender: Gender?,
    val role: Role
)

data class UserRequest(
    val username: String,
    val birthDate: String?,
    val phone: String?,
    val passwd: String,
    val contactInfo: String?,
    val gender: Gender?,
    val role: Role
)
