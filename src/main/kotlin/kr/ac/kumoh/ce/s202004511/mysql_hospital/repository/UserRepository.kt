package kr.ac.kumoh.ce.s202004511.mysql_hospital.repository

import kr.ac.kumoh.ce.s202004511.mysql_hospital.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Int>
