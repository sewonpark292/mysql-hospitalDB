package kr.ac.kumoh.ce.s202004511.mysql_hospital.repository

import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.AppointmentDto
import kr.ac.kumoh.ce.s202004511.mysql_hospital.Appointment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface AppointmentRepository : JpaRepository<Appointment, Int> {
    @Query("SELECT new kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.AppointmentDto(a.appointmentId, a.patientId, a.doctorId, a.nurseId, a.departmentId, a.appointmentDate, a.status, a.createdAt) FROM Appointment a")
    fun findAllAppointmentDtos(): List<AppointmentDto>

    @Query("SELECT new kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.AppointmentDto(a.appointmentId, a.patientId, a.doctorId, a.nurseId, a.departmentId, a.appointmentDate, a.status, a.createdAt) FROM Appointment a WHERE a.appointmentId = :id")
    fun findAppointmentDtoById(@Param("id") id: Int): AppointmentDto?
}
