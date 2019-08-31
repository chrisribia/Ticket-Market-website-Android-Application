package co.ke.tickett.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Tickets (
    @PrimaryKey(autoGenerate = false)
    var id : Int? = null,
    var qr_code : String?= null,
    var event_code : String? =null,
    var client_code : String? = null
)