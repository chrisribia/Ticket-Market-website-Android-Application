package co.ke.tickett.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import co.ke.tickett.data.db.entity.Tickets


@Dao
interface TicketDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllTickets(tickets : List<Tickets>)

    @Query("SELECT * FROM Tickets")
    fun getTickets() : LiveData<List<Tickets>>
}