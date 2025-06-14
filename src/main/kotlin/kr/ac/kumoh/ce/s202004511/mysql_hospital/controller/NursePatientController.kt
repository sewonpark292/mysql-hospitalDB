package kr.ac.kumoh.ce.s202004511.mysql_hospital.controller

import kr.ac.kumoh.ce.s202004511.mysql_hospital.*
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.NursePatientDto
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.NursePatientRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/nurse-patients")
class NursePatientController(
    private val nursePatientService: NursePatientService
) {
    @GetMapping
    fun getAll(): List<NursePatientDto> = nursePatientService.getAll()

    @PostMapping
    fun create(@RequestBody request: NursePatientRequest): NursePatientDto =
        nursePatientService.create(request)

    // 삭제, 수정은 구현하지 않음
}
