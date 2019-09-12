package co.ke.tickett.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Events(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val qr_code: String?,
    val ticket_code: String?,
    val attended : String?,
    val event_name : String?,
    val ticket_type : String?,
    val no_of_tickets : Int?,
    val ticket_price : String?
)