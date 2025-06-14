package kr.ac.kumoh.ce.s202004511.mysql_hospital.service

import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.*
import kr.ac.kumoh.ce.s202004511.mysql_hospital.repository.PatientRepository
import org.springframework.stereotype.Service

@Service
class PatientService(
    private val patientRepository: PatientRepository
) {
    fun getAllPatients(): List<PatientDto> =
        patientRepository.findAll().map { it.toDto() }

    fun getPatientById(id: Int): PatientDto =
        patientRepository.findById(id).orElseThrow().toDto()

    fun createPatient(request: PatientRequest): PatientDto {
        val patient = Patient(
            patientId = request.patientId,
            name = request.name
        )
        return patientRepository.save(patient).toDto()
    }
}
