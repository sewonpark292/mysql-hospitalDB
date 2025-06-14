package kr.ac.kumoh.ce.s202004511.mysql_hospital

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class HospitalController(
    private val patientService: PatientService,
    private val doctorService: DoctorService,
    private val nurseService: NurseService,
    private val adminService: AdminService
) {

    // 1. 환자 기능
    @PostMapping("/patient/login")
    fun loginPatient(@RequestBody loginRequest: LoginRequest): LoginResponse =
        patientService.login(loginRequest)

    @PostMapping("/patient/verify")
    fun verifyPatient(@RequestParam patientId: Int): Boolean =
        patientService.verify(patientId)

    @GetMapping("/patient/records")
    fun getMedicalRecords(@RequestParam patientId: Int): List<MedicalRecordDto> =
        patientService.getMedicalRecords(patientId)

    @PostMapping("/patient/appointments")
    fun makeAppointment(@RequestBody request: AppointmentRequest): AppointmentDto =
        patientService.makeAppointment(request)

    // 2. 의사 기능
    @PostMapping("/doctor/login")
    fun loginDoctor(@RequestBody loginRequest: LoginRequest): LoginResponse =
        doctorService.login(loginRequest)

    @GetMapping("/doctor/patients")
    fun getDoctorPatients(@RequestParam doctorId: Int): List<PatientDto> =
        doctorService.getPatients(doctorId)

    @GetMapping("/doctor/records")
    fun getDoctorMedicalRecords(@RequestParam doctorId: Int): List<MedicalRecordDto> =
        doctorService.getMedicalRecords(doctorId)

    @PostMapping("/doctor/records")
    fun addDoctorRecord(@RequestBody record: MedicalRecordRequest): MedicalRecordDto =
        doctorService.addRecord(record)

    @PutMapping("/doctor/records")
    fun updateDoctorRecord(@RequestBody record: MedicalRecordRequest): MedicalRecordDto =
        doctorService.updateRecord(record)

    // 3. 간호사 기능
    @PostMapping("/nurse/login")
    fun loginNurse(@RequestBody loginRequest: LoginRequest): LoginResponse =
        nurseService.login(loginRequest)

    @GetMapping("/nurse/patients")
    fun getNursePatients(@RequestParam nurseId: Int): List<PatientDto> =
        nurseService.getPatients(nurseId)

    @GetMapping("/nurse/records")
    fun getNurseMedicalRecords(@RequestParam nurseId: Int): List<MedicalRecordDto> =
        nurseService.getMedicalRecords(nurseId)

    @PostMapping("/nurse/records")
    fun addNurseTreatment(@RequestBody record: MedicalRecordRequest): MedicalRecordDto =
        nurseService.addTreatment(record)

    @PutMapping("/nurse/records")
    fun updateNurseTreatment(@RequestBody record: MedicalRecordRequest): MedicalRecordDto =
        nurseService.updateTreatment(record)

    // 4. 관리자 기능
    @PostMapping("/admin/login")
    fun loginAdmin(@RequestBody loginRequest: LoginRequest): LoginResponse =
        adminService.login(loginRequest)

    @GetMapping("/admin/users")
    fun getAllUsers(): List<UserDto> =
        adminService.getAllUsers()

    @PostMapping("/admin/users")
    fun addUser(@RequestBody user: UserDto): UserDto =
        adminService.addUser(user)

    @PutMapping("/admin/users")
    fun updateUser(@RequestBody user: UserDto): UserDto =
        adminService.updateUser(user)

    @DeleteMapping("/admin/users/{userId}")
    fun deleteUser(@PathVariable userId: Int) =
        adminService.deleteUser(userId)
}
