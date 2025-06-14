package kr.ac.kumoh.ce.s202004511.mysql_hospital

// --- Service Interfaces ---
interface AppointmentService {
    fun createAppointment(dto: AppointmentDto): Appointment
    fun getAppointmentsForPatient(patientId: Int): List<Appointment>
}