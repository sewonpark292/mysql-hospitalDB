package kr.ac.kumoh.ce.s202004511.mysql_hospital.service

import kr.ac.kumoh.ce.s202004511.mysql_hospital.*
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.*
import kr.ac.kumoh.ce.s202004511.mysql_hospital.controller.*
import org.springframework.stereotype.Service

@Service
class DoctorPatientService(
    private val doctorPatientRepository: DoctorPatientRepository
) {
    fun getAll(): List<DoctorPatientDto> =
        doctorPatientRepository.findAll().map { it.toDto() }

    fun create(request: DoctorPatientRequest): DoctorPatientDto {
        val entity = DoctorPatient(
            doctorId = request.doctorId,
            patientId = request.patientId
        )
        return doctorPatientRepository.save(entity).toDto()
    }
}
