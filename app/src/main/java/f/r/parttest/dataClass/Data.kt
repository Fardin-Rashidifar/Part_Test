package f.r.parttest.dataClass

import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.inject.Inject

@Entity(tableName = "userListTable")
data class Data @Inject constructor(
    val avatar: String,
    val email: String,
    val first_name: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val last_name: String
)