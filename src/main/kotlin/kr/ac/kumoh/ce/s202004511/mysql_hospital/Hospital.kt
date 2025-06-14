package kr.ac.kumoh.ce.s202004511.mysql_hospital


import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "departments")
data class Department(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val departmentId: Int,
    val deptName: String
)

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userId: Int,
    val username: String,
    val birthDate: String?,
    val phone: String?,
    val passwd: String,
    val contactInfo: String?,
    @Enumerated(EnumType.STRING)
    val gender: Gender?,
    @Enumerated(EnumType.STRING)
    val role: Role
)

enum class Gender { M, F }
enum class Role { patient, doctor, nurse, admin }

@Entity
@Table(name = "patients")
data class Patient(
    @Id
    val patientId: Int,
    val name: String
)

@Entity
@Table(name = "doctors")
data class Doctor(
    @Id
    val doctorId: Int,
    val name: String,
    val departmentId: Int?,
    val licenseNumber: String?
)

@Entity
@Table(name = "nurses")
data class Nurse(
    @Id
    val nurseId: Int,
    val name: String,
    val departmentId: Int?,
    val licenseNumber: String?
)

@Entity
@Table(name = "medicalRecords")
data class MedicalRecord(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val recordId: Int,
    val patientId: Int,
    val createdBy: Int,
    val date: LocalDate?,
    val diagnosis: String?,
    val description: String?,
    val treatment: String?,
    val recordType: String?,
    val lastUpdated: LocalDateTime = LocalDateTime.now()
)

@Entity
@Table(name = "appointments")
data class Appointment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val appointmentId: Int,
    val patientId: Int,
    val doctorId: Int?,
    val nurseId: Int?,
    val departmentId: Int?,
    val appointmentDate: LocalDate?,
    @Enumerated(EnumType.STRING)
    val status: AppointmentStatus = AppointmentStatus.scheduled,
    val createdAt: LocalDateTime = LocalDateTime.now()
)

enum class AppointmentStatus { scheduled, cancelled, completed }

@Entity
@Table(name = "doctorPatient")
data class DoctorPatient(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val identifyid: Int = 0,
    val doctorId: Int,
    val patientId: Int
)

@Entity
@Table(name = "nursePatient")
data class NursePatient(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val identifyid: Int = 0,
    val nurseId: Int,
    val patientId: Int
)

@Entity
@Table(name = "patientVerificationLog")
data class PatientVerificationLog(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val logId: Int = 0,
    val patientId: Int,
    @Enumerated(EnumType.STRING)
    val action: VerificationAction,
    val timestamp: LocalDateTime = LocalDateTime.now()
)

enum class VerificationAction { view_record, login }
