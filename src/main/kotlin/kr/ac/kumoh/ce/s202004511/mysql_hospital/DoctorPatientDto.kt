package kr.ac.kumoh.ce.s202004511.mysql_hospital

data class DoctorPatientDto(
    val identifyid: Int,
    val doctorId: Int,
    val patientId: Int
)

data class DoctorPatientRequest(
    val doctorId: Int,
    val patientId: Int
)