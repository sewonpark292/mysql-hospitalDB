package kr.ac.kumoh.ce.s202004511.mysql_hospital.service

import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.NurseDto
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.NurseRequest
import kr.ac.kumoh.ce.s202004511.mysql_hospital.repository.NurseRepository
import kr.ac.kumoh.ce.s202004511.mysql_hospital.Nurse
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.PatientDto
import kr.ac.kumoh.ce.s202004511.mysql_hospital.repository.NursePatientRepository
import kr.ac.kumoh.ce.s202004511.mysql_hospital.repository.PatientRepository
import org.springframework.stereotype.Service

@Service
class NurseService(
    private val nurseRepository: NurseRepository,
    private val nursePatientRepository: NursePatientRepository,
    private val patientRepository: PatientRepository
) {
    fun getAllNurses(): List<NurseDto> = nurseRepository.findAllNurseDtos()

    fun getNurseById(id: Int): NurseDto =
        nurseRepository.findNurseDtoById(id) ?: throw NoSuchElementException("Nurse not found: $id")

    fun createNurse(request: NurseRequest): NurseDto {
        val nurse = Nurse(
            nurseId = request.nurseId,
            name = request.name,
            departmentId = request.departmentId,
            licenseNumber = request.licenseNumber
        )
        val saved = nurseRepository.save(nurse)
        return nurseRepository.findNurseDtoById(saved.nurseId)!!
    }

    fun updateNurse(id: Int, request: NurseRequest): NurseDto {
        val nurse = nurseRepository.findById(id).orElseThrow { NoSuchElementException("Nurse not found: $id") }
        val updated = nurse.copy(
            name = request.name,
            departmentId = request.departmentId,
            licenseNumber = request.licenseNumber
        )
        nurseRepository.save(updated)
        return nurseRepository.findNurseDtoById(id)!!
    }

    fun deleteNurse(id: Int) {
        nurseRepository.deleteById(id)
    }

    fun getPatientsByNurseId(nurseId: Int): List<PatientDto> {
        val patientIds = nursePatientRepository.findPatientIdsByNurseId(nurseId)
        if (patientIds.isEmpty()) return emptyList()
        return patientRepository.findPatientDtosByIds(patientIds)
    }
}
