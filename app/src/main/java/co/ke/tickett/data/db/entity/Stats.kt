package co.ke.tickett.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Stats(
    @PrimaryKey(autoGenerate = false)
    val id: Int?,
    val balance : Int?
)