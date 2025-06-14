package kr.ac.kumoh.ce.s202004511.mysql_hospital

import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.AppointmentDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/appointments")
class AppointmentController(
    val appointmentService: AppointmentService
) {
    @PostMapping
    fun createAppointment(@RequestBody dto: AppointmentDto): ResponseEntity<Appointment> {
        return ResponseEntity.ok(appointmentService.createAppointment(dto))
    }

    @GetMapping("/patient/{patientId}")
    fun getAppointments(@PathVariable patientId: Int): ResponseEntity<List<Appointment>> {
        return ResponseEntity.ok(appointmentService.getAppointmentsForPatient(patientId))
    }
}