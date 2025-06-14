package kr.ac.kumoh.ce.s202004511.mysql_hospital.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kr.ac.kumoh.ce.s202004511.mysql_hospital.*
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.AppointmentDto
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.AppointmentRequest
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.MedicalRecordDto
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.PatientDto

@RestController
@RequestMapping("/api/patients")
class PatientController(
    private val patientService: PatientService,
    private val medicalRecordService: MedicalRecordService,
    private val appointmentService: AppointmentService
) {
    // 본인 정보 조회 (필요시)
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): PatientDto = patientService.getPatientById(id)

    // 본인 의료기록 열람 (읽기만 가능)
    @GetMapping("/{id}/medical-records")
    fun getMedicalRecords(@PathVariable id: Int): List<MedicalRecordDto> =
        medicalRecordService.getRecordsByPatientId(id)

    // 진료 예약 신청 (읽기/추가만 필요하다면 추가)
    @PostMapping("/{id}/appointments")
    fun createAppointment(
        @PathVariable id: Int,
        @RequestBody request: AppointmentRequest
    ): AppointmentDto = appointmentService.createAppointmentForPatient(id, request)
}
