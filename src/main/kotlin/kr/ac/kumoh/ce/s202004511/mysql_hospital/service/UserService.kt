package kr.ac.kumoh.ce.s202004511.mysql_hospital.service

import kr.ac.kumoh.ce.s202004511.mysql_hospital.*
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.*
import kr.ac.kumoh.ce.s202004511.mysql_hospital.controller.*
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {
    fun getAllUsers(): List<UserDto> =
        userRepository.findAll().map { it.toDto() }

    fun getUserById(id: Int): UserDto =
        userRepository.findById(id).orElseThrow().toDto()

    fun createUser(request: UserRequest): UserDto {
        val user = User(
            userId = 0,
            username = request.username,
            birthDate = request.birthDate,
            phone = request.phone,
            passwd = request.passwd,
            contactInfo = request.contactInfo,
            gender = request.gender,
            role = request.role
        )
        return userRepository.save(user).toDto()
    }
}

