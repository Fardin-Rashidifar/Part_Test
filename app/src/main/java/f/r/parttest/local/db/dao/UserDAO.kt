package f.r.parttest.local.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import f.r.parttest.dataClass.Data

@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(userList: List<Data>): List<Long>

    @Query("select * from userListTable")
    fun getAllUsers(): LiveData<List<Data>>
}