package kr.ac.kumoh.ce.s202004511.mysql_hospital.service

import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.NursePatientDto
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.NursePatientRequest
import kr.ac.kumoh.ce.s202004511.mysql_hospital.repository.NursePatientRepository
import kr.ac.kumoh.ce.s202004511.mysql_hospital.NursePatient
import org.springframework.stereotype.Service

@Service
class NursePatientService(
    private val nursePatientRepository: NursePatientRepository
) {
    fun getAll(): List<NursePatientDto> = nursePatientRepository.findAllNursePatientDtos()

    fun create(request: NursePatientRequest): NursePatientDto {
        val entity = NursePatient(
            identifyid = 0,
            nurseId = request.nurseId,
            patientId = request.patientId
        )
        val saved = nursePatientRepository.save(entity)
        return NursePatientDto(saved.identifyid, saved.nurseId, saved.patientId)
    }
}
