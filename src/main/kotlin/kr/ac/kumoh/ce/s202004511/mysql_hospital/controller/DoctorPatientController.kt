package kr.ac.kumoh.ce.s202004511.mysql_hospital.controller

import kr.ac.kumoh.ce.s202004511.mysql_hospital.*
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.DoctorPatientDto
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.DoctorPatientRequest
import kr.ac.kumoh.ce.s202004511.mysql_hospital.service.DoctorPatientService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/doctor-patients")
class DoctorPatientController(
    private val doctorPatientService: DoctorPatientService
) {
    @GetMapping
    fun getAll(): List<DoctorPatientDto> = doctorPatientService.getAll()

    @PostMapping
    fun create(@RequestBody request: DoctorPatientRequest): DoctorPatientDto =
        doctorPatientService.create(request)

    // 삭제, 수정은 구현하지 않음
}
