package kr.ac.kumoh.ce.s202004511.mysql_hospital.service

import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.MedicalRecordDto
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.MedicalRecordRequest
import kr.ac.kumoh.ce.s202004511.mysql_hospital.repository.MedicalRecordRepository
import kr.ac.kumoh.ce.s202004511.mysql_hospital.MedicalRecord
import org.springframework.stereotype.Service

@Service
class MedicalRecordService(
    private val medicalRecordRepository: MedicalRecordRepository
) {
    fun getAllRecords(): List<MedicalRecordDto> =
        medicalRecordRepository.findAllMedicalRecordDtos()

    fun getRecordById(id: Int): MedicalRecordDto =
        medicalRecordRepository.findMedicalRecordDtoById(id) ?: throw NoSuchElementException("MedicalRecord not found: $id")

    fun createRecord(request: MedicalRecordRequest): MedicalRecordDto {
        val record = MedicalRecord(
            recordId = 0,
            patientId = request.patientId,
            createdBy = request.createdBy,
            date = request.date,
            diagnosis = request.diagnosis,
            description = request.description,
            treatment = request.treatment,
            recordType = request.recordType,
            lastUpdated = null // DB에서 자동 생성
        )
        val saved = medicalRecordRepository.save(record)
        return medicalRecordRepository.findMedicalRecordDtoById(saved.recordId)!!
    }
    fun getRecordsByDoctorAndPatient(doctorId: Int, patientId: Int): List<MedicalRecordDto> {
        return medicalRecordRepository.findRecordsByDoctorAndPatient(doctorId, patientId)
    }

    fun addRecordByDoctor(doctorId: Int, patientId: Int, request: MedicalRecordRequest): MedicalRecordDto {
        val record = MedicalRecord(
            recordId = 0,
            patientId = patientId,
            createdBy = doctorId,
            date = request.date,
            diagnosis = request.diagnosis,
            description = request.description,
            treatment = request.treatment,
            recordType = request.recordType,
            lastUpdated = null // DB에서 자동 생성
        )
        val saved = medicalRecordRepository.save(record)
        // 저장 후 목록에서 해당 레코드만 추출
        return medicalRecordRepository.findRecordsByDoctorAndPatient(doctorId, patientId)
            .first { it.recordId == saved.recordId }
    }

    fun getRecordsByNurseAndPatient(nurseId: Int, patientId: Int): List<MedicalRecordDto> {
        return medicalRecordRepository.findRecordsByNurseAndPatient(nurseId, patientId)
    }

    fun addRecordByNurse(nurseId: Int, patientId: Int, request: MedicalRecordRequest): MedicalRecordDto {
        val record = MedicalRecord(
            recordId = 0,
            patientId = patientId,
            createdBy = nurseId,
            date = request.date,
            diagnosis = request.diagnosis,
            description = request.description,
            treatment = request.treatment,
            recordType = request.recordType,
            lastUpdated = null // DB에서 자동 생성
        )
        val saved = medicalRecordRepository.save(record)
        // 저장 후 목록에서 해당 레코드만 추출
        return medicalRecordRepository.findRecordsByNurseAndPatient(nurseId, patientId)
            .first { it.recordId == saved.recordId }
    }

    fun getRecordsByPatientId(patientId: Int): List<MedicalRecordDto> {
        return medicalRecordRepository.findRecordsByPatientId(patientId)
    }
}
