package avd.jdm.bindwallsapi

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import lombok.NoArgsConstructor

@Entity
@NoArgsConstructor
data class BlindWall(
    @Id
    @GeneratedValue
    var id: Int?,
    // id on the map in https://blindwalls.gallery/walls/
    val blindWallId: Int,
    // In H2 'year' is reserved: https://stackoverflow.com/questions/72178354/spring-sql-org-h2-jdbc-jdbcsqlsyntaxerrorexception-syntax-error-in-sql-stateme
    @Column(name = "\"year\"")
    val year: Int,
    val name: String,
    val author: String,
    @Column(length = 1000)
    val description: String,
    val blindWallsGalleryUrl: String,
    val imageUrl: String,

    // location of the blind wall
    val latitude: Double,
    val longitude: Double,

)

data class BlindWallsCollection (
    @JsonProperty(value = "blindwalls", required = true)
    val blindwalls: List<BlindWall>
)