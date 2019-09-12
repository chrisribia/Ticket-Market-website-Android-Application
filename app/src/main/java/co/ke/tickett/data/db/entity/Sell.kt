package co.ke.tickett.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Sell(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val event_name: String?,
    val ticket_type: String?,
    val available_tickets : Int?,
    val ticket_price : String?
)