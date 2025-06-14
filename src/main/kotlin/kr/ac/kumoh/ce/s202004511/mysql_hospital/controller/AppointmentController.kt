package kr.ac.kumoh.ce.s202004511.mysql_hospital.controller

import kr.ac.kumoh.ce.s202004511.mysql_hospital.*
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.AppointmentDto
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.AppointmentRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/appointments")
class AppointmentController(
    private val appointmentService: AppointmentService
) {
    @GetMapping
    fun getAll(): List<AppointmentDto> = appointmentService.getAllAppointments()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): AppointmentDto = appointmentService.getAppointmentById(id)

    @PostMapping
    fun create(@RequestBody request: AppointmentRequest): AppointmentDto =
        appointmentService.createAppointment(request)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody request: AppointmentRequest): AppointmentDto =
        appointmentService.updateAppointment(id, request)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) = appointmentService.deleteAppointment(id)
}
