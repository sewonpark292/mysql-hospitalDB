package kr.ac.kumoh.ce.s202004511.mysql_hospital.service

import kr.ac.kumoh.ce.s202004511.mysql_hospital.*
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.*
import kr.ac.kumoh.ce.s202004511.mysql_hospital.controller.*
import org.springframework.stereotype.Service

@Service
class NursePatientService(
    private val nursePatientRepository: NursePatientRepository
) {
    fun getAll(): List<NursePatientDto> =
        nursePatientRepository.findAll().map { it.toDto() }

    fun create(request: NursePatientRequest): NursePatientDto {
        val entity = NursePatient(
            nurseId = request.nurseId,
            patientId = request.patientId
        )
        return nursePatientRepository.save(entity).toDto()
    }
}
