package kr.ac.kumoh.ce.s202004511.mysql_hospital.service

import kr.ac.kumoh.ce.s202004511.mysql_hospital.*
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.*
import kr.ac.kumoh.ce.s202004511.mysql_hospital.controller.*
import org.springframework.stereotype.Service

@Service
class MedicalRecordService(
    private val medicalRecordRepository: MedicalRecordRepository
) {
    fun getAllRecords(): List<MedicalRecordDto> =
        medicalRecordRepository.findAll().map { it.toDto() }

    fun getRecordById(id: Int): MedicalRecordDto =
        medicalRecordRepository.findById(id).orElseThrow().toDto()

    fun createRecord(request: MedicalRecordRequest): MedicalRecordDto {
        val record = MedicalRecord(
            recordId = 0,
            patientId = request.patientId,
            createdBy = request.createdBy,
            date = request.date,
            diagnosis = request.diagnosis,
            description = request.description,
            treatment = request.treatment,
            recordType = request.recordType
        )
        return medicalRecordRepository.save(record).toDto()
    }
}
