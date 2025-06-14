package kr.ac.kumoh.ce.s202004511.mysql_hospital.service

import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.*
import kr.ac.kumoh.ce.s202004511.mysql_hospital.repository.NurseRepository
import org.springframework.stereotype.Service

@Service
class NurseService(
    private val nurseRepository: NurseRepository
) {
    fun getAllNurses(): List<NurseDto> =
        nurseRepository.findAll().map { it.toDto() }

    fun getNurseById(id: Int): NurseDto =
        nurseRepository.findById(id).orElseThrow().toDto()

    fun createNurse(request: NurseRequest): NurseDto {
        val nurse = Nurse(
            nurseId = request.nurseId,
            name = request.name,
            departmentId = request.departmentId,
            licenseNumber = request.licenseNumber
        )
        return nurseRepository.save(nurse).toDto()
    }
}
