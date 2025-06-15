package kr.ac.kumoh.ce.s202004511.mysql_hospital.service

import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.UserDto
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.UserRequest
import kr.ac.kumoh.ce.s202004511.mysql_hospital.repository.UserRepository
import kr.ac.kumoh.ce.s202004511.mysql_hospital.User
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {
    fun getAllUsers(): List<UserDto> =
        userRepository.findAllUserDtos()

    fun getUserByUsername(username: String): UserDto? =
        userRepository.findUserDtoByUsername(username)

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
        val saved = userRepository.save(user)
        // 저장 후 다시 DTO로 반환 (findUserDtoByUsername 사용)
        return userRepository.findUserDtoByUsername(saved.username)!!
    }
}
