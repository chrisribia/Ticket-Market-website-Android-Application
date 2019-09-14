package co.ke.tickett.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import co.ke.tickett.data.db.entity.Events

@Dao
interface EventsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllEvents(quotes : List<Events>)


    @Query("SELECT * FROM Events WHERE qr_code = :qr_code")
    fun findEvent(qr_code: String): LiveData<Events>

    @Query("SELECT * FROM Events WHERE ticket_code = :qr_code")
    fun findEventByCodez(qr_code: String): LiveData<Events>



    @Query("SELECT * FROM Events")
    fun getEvents(): List<Events>

    @Query("SELECT * FROM Events WHERE ticket_code LIKE '%' || :ticket_code || '%' ")
    fun findEventByCode(ticket_code: String): List<Events>




}