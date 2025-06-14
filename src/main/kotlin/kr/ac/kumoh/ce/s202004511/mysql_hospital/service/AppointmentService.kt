package kr.ac.kumoh.ce.s202004511.mysql_hospital.service
import kr.ac.kumoh.ce.s202004511.mysql_hospital.*
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.*
import kr.ac.kumoh.ce.s202004511.mysql_hospital.controller.*
import org.springframework.stereotype.Service

@Service
class AppointmentService(
    private val appointmentRepository: AppointmentRepository
) {
    fun getAllAppointments(): List<AppointmentDto> =
        appointmentRepository.findAll().map { it.toDto() }

    fun getAppointmentById(id: Int): AppointmentDto =
        appointmentRepository.findById(id).orElseThrow().toDto()

    fun createAppointment(request: AppointmentRequest): AppointmentDto {
        val appointment = Appointment(
            appointmentId = 0,
            patientId = request.patientId,
            doctorId = request.doctorId,
            nurseId = request.nurseId,
            departmentId = request.departmentId,
            appointmentDate = request.appointmentDate
        )
        return appointmentRepository.save(appointment).toDto()
    }

    fun updateAppointment(id: Int, request: AppointmentRequest): AppointmentDto {
        val appointment = appointmentRepository.findById(id).orElseThrow()
            .copy(
                patientId = request.patientId,
                doctorId = request.doctorId,
                nurseId = request.nurseId,
                departmentId = request.departmentId,
                appointmentDate = request.appointmentDate
            )
        return appointmentRepository.save(appointment).toDto()
    }

    fun deleteAppointment(id: Int) {
        appointmentRepository.deleteById(id)
    }
}
