package kr.ac.kumoh.ce.s202004511.mysql_hospital

import Doctor
import Nurse
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface HospitalRepository {
    @Repository
    interface DoctorRepository : JpaRepository<Doctor, Int>

    @Repository
    interface NurseRepository : JpaRepository<Nurse, Int>
}