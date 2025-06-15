package kr.ac.kumoh.ce.s202004511.mysql_hospital.service

import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.DoctorDto
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.DoctorRequest
import kr.ac.kumoh.ce.s202004511.mysql_hospital.repository.DoctorRepository
import kr.ac.kumoh.ce.s202004511.mysql_hospital.Doctor
import kr.ac.kumoh.ce.s202004511.mysql_hospital.repository.PatientRepository
import org.springframework.stereotype.Service

@Service
class DoctorService(
    private val doctorRepository: DoctorRepository,
    private val patientRepository: PatientRepository
) {
    fun getAllDoctors(): List<DoctorDto> = doctorRepository.findAllDoctorDtos()

    fun getDoctorById(id: Int): DoctorDto =
        doctorRepository.findDoctorDtoById(id) ?: throw NoSuchElementException("Doctor not found: $id")

    fun createDoctor(request: DoctorRequest): DoctorDto {
        val doctor = Doctor(
            doctorId = request.doctorId,
            name = request.name,
            departmentId = request.departmentId,
            licenseNumber = request.licenseNumber
        )
        val saved = doctorRepository.save(doctor)
        return doctorRepository.findDoctorDtoById(saved.doctorId)!!
    }

    fun updateDoctor(id: Int, request: DoctorRequest): DoctorDto {
        val doctor = doctorRepository.findById(id).orElseThrow { NoSuchElementException("Doctor not found: $id") }
        val updated = doctor.copy(
            name = request.name,
            departmentId = request.departmentId,
            licenseNumber = request.licenseNumber
        )
        doctorRepository.save(updated)
        return doctorRepository.findDoctorDtoById(id)!!
    }

    fun deleteDoctor(id: Int) {
        doctorRepository.deleteById(id)
    }

    fun getPatientsByDoctorId(doctorId: Int): List<PatientDto> {
        val patientIds = doctorPatientRepository.findPatientIdsByDoctorId(doctorId)
        if (patientIds.isEmpty()) return emptyList()
        return patientRepository.findPatientDtosByIds(patientIds)
    }
}
