package co.ke.tickett.data.db.entity

import androidx.room.PrimaryKey

data class Stats(
    @PrimaryKey(autoGenerate = false)
    val balance: Int?
)