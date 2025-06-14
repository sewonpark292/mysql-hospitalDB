package kr.ac.kumoh.ce.s202004511.mysql_hospital

import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.AppointmentDto
import org.springframework.stereotype.Service

@Service
class AppointmentServiceImpl(
    val appointmentRepository: AppointmentRepository
) : AppointmentService {
    override fun createAppointment(dto: AppointmentDto): Appointment {
        val appointment = Appointment(
            appointmentId = 0,
            patientId = dto.patientId,
            doctorId = dto.doctorId,
            nurseId = dto.nurseId,
            departmentId = dto.departmentId,
            appointmentDate = dto.appointmentDate
        )
        return appointmentRepository.save(appointment)
    }

    override fun getAppointmentsForPatient(patientId: Int): List<Appointment> {
        return appointmentRepository.findByPatientId(patientId)
    }
}