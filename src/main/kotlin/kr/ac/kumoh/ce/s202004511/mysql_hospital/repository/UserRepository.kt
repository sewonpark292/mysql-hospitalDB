package kr.ac.kumoh.ce.s202004511.mysql_hospital.repository

import kr.ac.kumoh.ce.s202004511.mysql_hospital.User
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.UserDto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface UserRepository : JpaRepository<User, Int> {
    @Query("SELECT new kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.UserDto(u.userId, u.username, u.birthDate, u.phone, u.contactInfo, u.gender, u.role) FROM User u WHERE u.username = :username")
    fun findUserDtoByUsername(@Param("username") username: String): UserDto?

    @Query("SELECT new kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.UserDto(u.userId, u.username, u.birthDate, u.phone, u.contactInfo, u.gender, u.role) FROM User u")
    fun findAllUserDtos(): List<UserDto>
}
