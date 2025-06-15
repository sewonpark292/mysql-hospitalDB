package kr.ac.kumoh.ce.s202004511.mysql_hospital.service

import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.DoctorPatientDto
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.DoctorPatientRequest
import kr.ac.kumoh.ce.s202004511.mysql_hospital.repository.DoctorPatientRepository
import kr.ac.kumoh.ce.s202004511.mysql_hospital.DoctorPatient
import org.springframework.stereotype.Service

@Service
class DoctorPatientService(
    private val doctorPatientRepository: DoctorPatientRepository
) {
    fun getAll(): List<DoctorPatientDto> = doctorPatientRepository.findAllDoctorPatientDtos()

    fun create(request: DoctorPatientRequest): DoctorPatientDto {
        val entity = DoctorPatient(
            identifyid = 0,
            doctorId = request.doctorId,
            patientId = request.patientId
        )
        val saved = doctorPatientRepository.save(entity)
        return DoctorPatientDto(saved.identifyid, saved.doctorId, saved.patientId)
    }
}
