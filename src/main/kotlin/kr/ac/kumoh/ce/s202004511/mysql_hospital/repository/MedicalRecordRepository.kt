package kr.ac.kumoh.ce.s202004511.mysql_hospital.repository

import kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.MedicalRecordDto
import kr.ac.kumoh.ce.s202004511.mysql_hospital.MedicalRecord
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface MedicalRecordRepository : JpaRepository<MedicalRecord, Int> {
    @Query("" +
            "SELECT new kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.MedicalRecordDto(" +
            "m.recordId, " +
            "m.patientId, " +
            "m.createdBy, " +
            "m.date, " +
            "m.diagnosis, " +
            "m.description, " +
            "m.treatment, " +
            "m.recordType, " +
            "m.lastUpdated) " +
            "FROM MedicalRecord m"
    )
    fun findAllMedicalRecordDtos(): List<MedicalRecordDto>

    @Query("" +
            "SELECT new kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.MedicalRecordDto(" +
            "m.recordId," +
            " m.patientId," +
            " m.createdBy, " +
            "m.date," +
            " m.diagnosis, " +
            "m.description, " +
            "m.treatment, " +
            "m.recordType, " +
            "m.lastUpdated) " +
            "FROM MedicalRecord m " +
            "WHERE m.recordId = :id"
    )
    fun findMedicalRecordDtoById(@Param("id") id: Int): MedicalRecordDto?

    @Query("""
        SELECT new kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.MedicalRecordDto(
        m.recordId, 
        m.patientId, 
        m.createdBy, 
        m.date, 
        m.diagnosis, 
        m.description, 
        m.treatment, 
        m.recordType, 
        m.lastUpdated
        )
        FROM MedicalRecord m
        WHERE m.patientId = :patientId 
        AND m.createdBy = :doctorId
        ORDER BY m.date DESC
    """)
    fun findRecordsByDoctorAndPatient(
        @Param("doctorId") doctorId: Int,
        @Param("patientId") patientId: Int
    ): List<MedicalRecordDto>

    @Query("""
        SELECT new kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.MedicalRecordDto(
            m.recordId, m.patientId, m.createdBy, m.date, m.diagnosis, m.description, m.treatment, m.recordType, m.lastUpdated
        )
        FROM MedicalRecord m
        WHERE m.patientId = :patientId AND m.createdBy = :nurseId
        ORDER BY m.date DESC
    """)
    fun findRecordsByNurseAndPatient(
        @Param("nurseId") nurseId: Int,
        @Param("patientId") patientId: Int
    ): List<MedicalRecordDto>

    @Query("SELECT new kr.ac.kumoh.ce.s202004511.mysql_hospital.dto.MedicalRecordDto(m.recordId, m.patientId, m.createdBy, m.date, m.diagnosis, m.description, m.treatment, m.recordType, m.lastUpdated) FROM MedicalRecord m WHERE m.patientId = :patientId ORDER BY m.date DESC")
    fun findRecordsByPatientId(@Param("patientId") patientId: Int): List<MedicalRecordDto>
}
