package kr.ac.kumoh.ce.s202004511.mysql_hospital.service

import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.*
import kr.ac.kumoh.ce.s202004511.mysql_hospital.repository.DoctorRepository
import org.springframework.stereotype.Service

@Service
class DoctorService(
    private val doctorRepository: DoctorRepository
) {
    fun getAllDoctors(): List<DoctorDto> =
        doctorRepository.findAll().map { it.toDto() }

    fun getDoctorById(id: Int): DoctorDto =
        doctorRepository.findById(id).orElseThrow().toDto()

    fun createDoctor(request: DoctorRequest): DoctorDto {
        val doctor = Doctor(
            doctorId = request.doctorId,
            name = request.name,
            departmentId = request.departmentId,
            licenseNumber = request.licenseNumber
        )
        return doctorRepository.save(doctor).toDto()
    }
}
