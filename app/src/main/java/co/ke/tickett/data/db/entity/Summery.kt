package co.ke.tickett.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Summery(
    @PrimaryKey(autoGenerate = false)
    val event_name: String?,
    val confirmed_tickets : Int?,
    val unconfirmed_tickets : Int?
)