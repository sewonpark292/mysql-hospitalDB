package kr.ac.kumoh.ce.s202004511.mysql_hospital.controller

import kr.ac.kumoh.ce.s202004511.mysql_hospital.*
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.MedicalRecordDto
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.MedicalRecordRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/medical-records")
class MedicalRecordController(
    private val medicalRecordService: MedicalRecordService
) {
    @GetMapping
    fun getAll(): List<MedicalRecordDto> = medicalRecordService.getAllRecords()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): MedicalRecordDto = medicalRecordService.getRecordById(id)

    @PostMapping
    fun create(@RequestBody request: MedicalRecordRequest): MedicalRecordDto =
        medicalRecordService.createRecord(request)

    // 삭제, 수정은 구현하지 않음
}
