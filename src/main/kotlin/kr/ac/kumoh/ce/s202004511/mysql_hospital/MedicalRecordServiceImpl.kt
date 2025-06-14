package kr.ac.kumoh.ce.s202004511.mysql_hospital

import org.springframework.stereotype.Service

@Service
class MedicalRecordServiceImpl(
    val medicalRecordRepository: MedicalRecordRepository
) : MedicalRecordService {
    override fun createMedicalRecord(dto: MedicalRecordDto): MedicalRecord {
        val record = MedicalRecord(
            recordId = 0,
            patientId = dto.patientId,
            createdBy = dto.createdBy,
            date = dto.date,
            diagnosis = dto.diagnosis,
            description = dto.description,
            treatment = dto.treatment,
            recordType = dto.recordType
        )
        return medicalRecordRepository.save(record)
    }

    override fun getMedicalRecordsForPatient(patientId: Int): List<MedicalRecord> {
        return medicalRecordRepository.findByPatientIdOrderByDateDesc(patientId)
    }
}