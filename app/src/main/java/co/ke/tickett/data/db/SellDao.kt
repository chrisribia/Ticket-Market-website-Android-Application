package co.ke.tickett.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import co.ke.tickett.data.db.entity.Sell


@Dao
interface SellDao  {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllEvents(event : List<Sell>)

    @Query("SELECT * FROM Sell ")
    fun tickes(): LiveData<List<Sell>>

    @Query("SELECT * FROM Sell WHERE id=:id ")
    fun ticketForSale(id: String): LiveData<List<Sell>>



}