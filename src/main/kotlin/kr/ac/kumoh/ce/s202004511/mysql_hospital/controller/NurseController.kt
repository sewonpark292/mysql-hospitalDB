package kr.ac.kumoh.ce.s202004511.mysql_hospital.controller

import org.springframework.web.bind.annotation.*
import kr.ac.kumoh.ce.s202004511.mysql_hospital.*
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.MedicalRecordDto
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.MedicalRecordRequest
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.PatientDto
import kr.ac.kumoh.ce.s202004511.mysql_hospital.service.MedicalRecordService
import kr.ac.kumoh.ce.s202004511.mysql_hospital.service.NurseService

@RestController
@RequestMapping("/api/nurses")
class NurseController(
    private val nurseService: NurseService,
    private val medicalRecordService: MedicalRecordService
) {
    // 담당 환자 목록 조회
    @GetMapping("/{nurseId}/patients")
    fun getMyPatients(@PathVariable nurseId: Int): List<PatientDto> =
        nurseService.getPatientsByNurseId(nurseId)

    // 담당 환자 의료기록 조회 (읽기)
    @GetMapping("/{nurseId}/patients/{patientId}/medical-records")
    fun getPatientRecords(
        @PathVariable nurseId: Int,
        @PathVariable patientId: Int
    ): List<MedicalRecordDto> =
        medicalRecordService.getRecordsByNurseAndPatient(nurseId, patientId)

    // 의료기록 추가
    @PostMapping("/{nurseId}/patients/{patientId}/medical-records")
    fun addMedicalRecord(
        @PathVariable nurseId: Int,
        @PathVariable patientId: Int,
        @RequestBody request: MedicalRecordRequest
    ): MedicalRecordDto =
        medicalRecordService.addRecordByNurse(nurseId, patientId, request)
}