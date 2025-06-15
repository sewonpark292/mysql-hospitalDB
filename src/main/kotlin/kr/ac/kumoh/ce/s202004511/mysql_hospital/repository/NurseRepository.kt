package kr.ac.kumoh.ce.s202004511.mysql_hospital.repository

import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.NurseDto
import kr.ac.kumoh.ce.s202004511.mysql_hospital.Nurse
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface NurseRepository : JpaRepository<Nurse, Int> {
    @Query("SELECT new kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.NurseDto(n.nurseId, n.name, n.departmentId, n.licenseNumber) FROM Nurse n WHERE n.nurseId = :nurseId")
    fun findNurseDtoById(@Param("nurseId") nurseId: Int): NurseDto?

    @Query("SELECT new kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.NurseDto(n.nurseId, n.name, n.departmentId, n.licenseNumber) FROM Nurse n")
    fun findAllNurseDtos(): List<NurseDto>
}
