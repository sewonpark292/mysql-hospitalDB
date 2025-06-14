package kr.ac.kumoh.ce.s202004511.mysql_hospital

@Service
class AdminService(
    private val doctorRepo: DoctorRepository,
    private val nurseRepo: NurseRepository
) {
    // === DOCTOR ===
    fun createDoctor(dto: DoctorDto): Doctor = doctorRepo.save(
        Doctor(
            doctorId = 0,
            name = dto.name,
            departmentId = dto.departmentId,
            licenseNumber = dto.licenseNumber
        )
    )

    fun getAllDoctors(): List<Doctor> = doctorRepo.findAll()

    fun updateDoctor(id: Int, dto: DoctorDto): Doctor {
        val doctor = doctorRepo.findById(id).orElseThrow()
        val updated = doctor.copy(
            name = dto.name,
            departmentId = dto.departmentId,
            licenseNumber = dto.licenseNumber
        )
        return doctorRepo.save(updated)
    }

    fun deleteDoctor(id: Int) = doctorRepo.deleteById(id)

    // === NURSE ===
    fun createNurse(dto: NurseDto): Nurse = nurseRepo.save(
        Nurse(
            nurseId = 0,
            name = dto.name,
            departmentId = dto.departmentId,
            licenseNumber = dto.licenseNumber
        )
    )

    fun getAllNurses(): List<Nurse> = nurseRepo.findAll()

    fun updateNurse(id: Int, dto: NurseDto): Nurse {
        val nurse = nurseRepo.findById(id).orElseThrow()
        val updated = nurse.copy(
            name = dto.name,
            departmentId = dto.departmentId,
            licenseNumber = dto.licenseNumber
        )
        return nurseRepo.save(updated)
    }

    fun deleteNurse(id: Int) = nurseRepo.deleteById(id)
}