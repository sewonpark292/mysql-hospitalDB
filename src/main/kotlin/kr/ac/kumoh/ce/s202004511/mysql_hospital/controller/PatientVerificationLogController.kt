package kr.ac.kumoh.ce.s202004511.mysql_hospital.controller
import kr.ac.kumoh.ce.s202004511.mysql_hospital.*
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.PatientVerificationLogDto
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.PatientVerificationLogRequest
import kr.ac.kumoh.ce.s202004511.mysql_hospital.service.PatientVerificationLogService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/patient-verification-logs")
class PatientVerificationLogController(
    private val patientVerificationLogService: PatientVerificationLogService
) {
    @GetMapping
    fun getAll(): List<PatientVerificationLogDto> = patientVerificationLogService.getAll()

    @PostMapping
    fun create(@RequestBody request: PatientVerificationLogRequest): PatientVerificationLogDto =
        patientVerificationLogService.create(request)
}
