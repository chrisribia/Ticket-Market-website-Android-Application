package co.ke.tickett.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import co.ke.tickett.data.db.entity.Summery

@Dao
interface SummeryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllSummery(summery : List<Summery>)


    @Query("SELECT * FROM Summery ")
    fun summery(): LiveData<List<Summery>>




}