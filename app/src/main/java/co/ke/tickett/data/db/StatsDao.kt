package co.ke.tickett.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import co.ke.tickett.data.db.entity.Stats

@Dao
interface StatsDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveBalance(stats: List<Stats>) : Long

    @Query("SELECT * FROM Stats")
    fun getbalance() : LiveData<Stats>
}