package co.ke.tickett.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

const val CURRENT_USER_ID = 0
@Entity
data class User (
    var id : Int? = null,
    var first_name : String? = null,
    var last_name : String? = null,
    var phone : String? = null,
    var email : String? = null


){

    @PrimaryKey(autoGenerate = false)
    var uid: Int = CURRENT_USER_ID
}