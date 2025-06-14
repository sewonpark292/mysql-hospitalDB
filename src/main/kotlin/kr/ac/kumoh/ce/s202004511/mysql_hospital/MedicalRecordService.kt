package kr.ac.kumoh.ce.s202004511.mysql_hospital

interface MedicalRecordService {
    fun createMedicalRecord(dto: MedicalRecordDto): MedicalRecord
    fun getMedicalRecordsForPatient(patientId: Int): List<MedicalRecord>
}