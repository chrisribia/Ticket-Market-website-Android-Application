package co.ke.tickett.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import co.ke.tickett.data.db.entity.Stats

private val Id = 1
@Dao
interface StatsDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveBalance(stats: List<Stats>)

    @Query("SELECT * FROM Stats WHERE id=ID")
    fun getbalance() : LiveData<Stats>
}