package kr.ac.kumoh.ce.s202004511.mysql_hospital.service

import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.PatientVerificationLogDto
import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.PatientVerificationLogRequest
import kr.ac.kumoh.ce.s202004511.mysql_hospital.repository.PatientVerificationLogRepository
import kr.ac.kumoh.ce.s202004511.mysql_hospital.PatientVerificationLog
import org.springframework.stereotype.Service

@Service
class PatientVerificationLogService(
    private val patientVerificationLogRepository: PatientVerificationLogRepository
) {
    fun getAll(): List<PatientVerificationLogDto> = patientVerificationLogRepository.findAllLogDtos()

    fun create(request: PatientVerificationLogRequest): PatientVerificationLogDto {
        val entity = PatientVerificationLog(
            logId = 0,
            patientId = request.patientId,
            action = request.action
        )
        val saved = patientVerificationLogRepository.save(entity)
        return PatientVerificationLogDto(saved.logId, saved.patientId, saved.action, saved.timestamp)
    }

    fun getLogsByPatientId(patientId: Int): List<PatientVerificationLogDto> =
        patientVerificationLogRepository.findAllByPatientId(patientId)
}
