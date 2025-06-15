package kr.ac.kumoh.ce.s202004511.mysql_hospital.service

import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.PatientDto
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.PatientRequest
import kr.ac.kumoh.ce.s202004511.mysql_hospital.repository.PatientRepository
import kr.ac.kumoh.ce.s202004511.mysql_hospital.Patient
import org.springframework.stereotype.Service

@Service
class PatientService(
    private val patientRepository: PatientRepository
) {
    fun getAllPatients(): List<PatientDto> = patientRepository.findAllPatientDtos()

    fun getPatientById(id: Int): PatientDto =
        patientRepository.findPatientDtoById(id) ?: throw NoSuchElementException("Patient not found: $id")

    fun createPatient(request: PatientRequest): PatientDto {
        val patient = Patient(
            patientId = request.patientId,
            name = request.name
        )
        val saved = patientRepository.save(patient)
        return patientRepository.findPatientDtoById(saved.patientId)!!
    }
}
