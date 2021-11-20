package f.r.parttest.dataClass

import javax.inject.Inject

data class Support @Inject constructor(
    val text: String,
    val url: String
)