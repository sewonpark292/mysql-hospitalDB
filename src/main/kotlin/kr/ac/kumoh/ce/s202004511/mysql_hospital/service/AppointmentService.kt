package kr.ac.kumoh.ce.s202004511.mysql_hospital.service

import kr.ac.kumoh.ce.s202004511.mysql_hospital.AppointmentStatus
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.AppointmentDto
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.AppointmentRequest
import kr.ac.kumoh.ce.s202004511.mysql_hospital.repository.AppointmentRepository
import kr.ac.kumoh.ce.s202004511.mysql_hospital.Appointment
import org.springframework.stereotype.Service

@Service
class AppointmentService(
    private val appointmentRepository: AppointmentRepository
) {
    fun getAllAppointments(): List<AppointmentDto> =
        appointmentRepository.findAllAppointmentDtos()

    fun getAppointmentById(id: Int): AppointmentDto =
        appointmentRepository.findAppointmentDtoById(id) ?: throw NoSuchElementException("Appointment not found: $id")

    fun createAppointment(request: AppointmentRequest): AppointmentDto {
        val appointment = Appointment(
            appointmentId = 0,
            patientId = request.patientId,
            doctorId = request.doctorId,
            nurseId = request.nurseId,
            departmentId = request.departmentId,
            appointmentDate = request.appointmentDate,
            status = request.status,
            createdAt = null // DB에서 자동 생성
        )
        val saved = appointmentRepository.save(appointment)
        return appointmentRepository.findAppointmentDtoById(saved.appointmentId)!!
    }

    fun updateAppointment(id: Int, request: AppointmentRequest): AppointmentDto {
        val appointment = appointmentRepository.findById(id).orElseThrow { NoSuchElementException("Appointment not found: $id") }
        val updated = appointment.copy(
            patientId = request.patientId,
            doctorId = request.doctorId,
            nurseId = request.nurseId,
            departmentId = request.departmentId,
            appointmentDate = request.appointmentDate,
            status = request.status
        )
        appointmentRepository.save(updated)
        return appointmentRepository.findAppointmentDtoById(id)!!
    }

    fun deleteAppointment(id: Int) {
        appointmentRepository.deleteById(id)
    }

    fun createAppointmentForPatient(patientId: Int, request: AppointmentRequest): AppointmentDto {
        val appointment = Appointment(
            appointmentId = 0,
            patientId = patientId,
            doctorId = request.doctorId,
            nurseId = request.nurseId,
            departmentId = request.departmentId,
            appointmentDate = request.appointmentDate,
            status = request.status ?: "scheduled",
            createdAt = null // DB에서 자동 할당
        )
        val saved = appointmentRepository.save(appointment)
        return appointmentRepository.findAppointmentDtoById(saved.appointmentId)!!
    }
}
