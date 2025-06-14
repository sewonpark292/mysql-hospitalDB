package kr.ac.kumoh.ce.s202004511.mysql_hospital

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/records")
class MedicalRecordController(
    val medicalRecordService: MedicalRecordService
) {
    @PostMapping
    fun createMedicalRecord(@RequestBody dto: MedicalRecordDto): ResponseEntity<MedicalRecord> {
        return ResponseEntity.ok(medicalRecordService.createMedicalRecord(dto))
    }

    @GetMapping("/patient/{patientId}")
    fun getRecords(@PathVariable patientId: Int): ResponseEntity<List<MedicalRecord>> {
        return ResponseEntity.ok(medicalRecordService.getMedicalRecordsForPatient(patientId))
    }
}