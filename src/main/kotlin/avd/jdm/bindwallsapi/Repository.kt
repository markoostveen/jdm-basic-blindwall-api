package avd.jdm.bindwallsapi

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface Repository : JpaRepository<BlindWall, Int> {
}