package kr.ac.kumoh.ce.s202004511.mysql_hospital.controller

import kr.ac.kumoh.ce.s202004511.mysql_hospital.*
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.UserDto
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.UserRequest
import kr.ac.kumoh.ce.s202004511.mysql_hospital.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(
    private val userService: UserService
) {
    @GetMapping
    fun getAll(): List<UserDto> = userService.getAllUsers()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): UserDto = userService.getUserById(id)

    @PostMapping
    fun create(@RequestBody request: UserRequest): UserDto = userService.createUser(request)

    // 삭제, 수정은 구현하지 않음
}
