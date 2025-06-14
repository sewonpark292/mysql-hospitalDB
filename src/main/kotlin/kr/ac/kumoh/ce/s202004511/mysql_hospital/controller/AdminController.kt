package kr.ac.kumoh.ce.s202004511.mysql_hospital.controller

import kr.ac.kumoh.ce.s202004511.mysql_hospital.*
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.DoctorDto
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.DoctorRequest
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.NurseDto
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.NurseRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/admin")
class AdminController(
    private val doctorService: DoctorService,
    private val nurseService: NurseService
) {
    // 의사 정보 관리
    @GetMapping("/doctors")
    fun getAllDoctors(): List<DoctorDto> = doctorService.getAllDoctors()

    @PostMapping("/doctors")
    fun addDoctor(@RequestBody request: DoctorRequest): DoctorDto = doctorService.createDoctor(request)

    @PutMapping("/doctors/{doctorId}")
    fun updateDoctor(
        @PathVariable doctorId: Int,
        @RequestBody request: DoctorRequest
    ): DoctorDto = doctorService.updateDoctor(doctorId, request)

    @DeleteMapping("/doctors/{doctorId}")
    fun deleteDoctor(@PathVariable doctorId: Int) = doctorService.deleteDoctor(doctorId)

    // 간호사 정보 관리
    @GetMapping("/nurses")
    fun getAllNurses(): List<NurseDto> = nurseService.getAllNurses()

    @PostMapping("/nurses")
    fun addNurse(@RequestBody request: NurseRequest): NurseDto = nurseService.createNurse(request)

    @PutMapping("/nurses/{nurseId}")
    fun updateNurse(
        @PathVariable nurseId: Int,
        @RequestBody request: NurseRequest
    ): NurseDto = nurseService.updateNurse(nurseId, request)

    @DeleteMapping("/nurses/{nurseId}")
    fun deleteNurse(@PathVariable nurseId: Int) = nurseService.deleteNurse(nurseId)
}
