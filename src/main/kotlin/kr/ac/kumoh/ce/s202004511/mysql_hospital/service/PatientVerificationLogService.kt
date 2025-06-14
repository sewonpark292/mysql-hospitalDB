package kr.ac.kumoh.ce.s202004511.mysql_hospital.service
import kr.ac.kumoh.ce.s202004511.mysql_hospital.*
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.*
import kr.ac.kumoh.ce.s202004511.mysql_hospital.controller.*
import org.springframework.stereotype.Service

@Service
class PatientVerificationLogService(
    private val patientVerificationLogRepository: PatientVerificationLogRepository
) {
    fun getAll(): List<PatientVerificationLogDto> =
        patientVerificationLogRepository.findAll().map { it.toDto() }

    fun create(request: PatientVerificationLogRequest): PatientVerificationLogDto {
        val entity = PatientVerificationLog(
            patientId = request.patientId,
            action = request.action
        )
        return patientVerificationLogRepository.save(entity).toDto()
    }
}
