package kr.ac.kumoh.ce.s202004511.mysql_hospital.controller

import org.springframework.web.bind.annotation.*
import kr.ac.kumoh.ce.s202004511.mysql_hospital.*
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.MedicalRecordDto
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.MedicalRecordRequest
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.PatientDto
import kr.ac.kumoh.ce.s202004511.mysql_hospital.service.DoctorService
import kr.ac.kumoh.ce.s202004511.mysql_hospital.service.MedicalRecordService

@RestController
@RequestMapping("/api/doctors")
class DoctorController(
    private val doctorService: DoctorService,
    private val medicalRecordService: MedicalRecordService
) {
    // 담당 환자 목록 조회
    @GetMapping("/{doctorId}/patients")
    fun getMyPatients(@PathVariable doctorId: Int): List<PatientDto> =
        doctorService.getPatientsByDoctorId(doctorId)

    // 담당 환자 의료기록 조회 (읽기)
    @GetMapping("/{doctorId}/patients/{patientId}/medical-records")
    fun getPatientRecords(
        @PathVariable doctorId: Int,
        @PathVariable patientId: Int
    ): List<MedicalRecordDto> =
        medicalRecordService.getRecordsByDoctorAndPatient(doctorId, patientId)

    // 의료기록 추가
    @PostMapping("/{doctorId}/patients/{patientId}/medical-records")
    fun addMedicalRecord(
        @PathVariable doctorId: Int,
        @PathVariable patientId: Int,
        @RequestBody request: MedicalRecordRequest
    ): MedicalRecordDto =
        medicalRecordService.addRecordByDoctor(doctorId, patientId, request)
}
