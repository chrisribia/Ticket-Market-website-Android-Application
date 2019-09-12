package co.ke.tickett.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Stats(
    @PrimaryKey(autoGenerate = false)
    val unconfirmed_tickets: String?,
    val confirmed_tickets : Int?,
    val event_name : String?
)