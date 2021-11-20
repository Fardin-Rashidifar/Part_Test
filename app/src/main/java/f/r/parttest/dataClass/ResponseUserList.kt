package f.r.parttest.dataClass

import javax.inject.Inject

data class ResponseUserList @Inject constructor(
    val data: List<Data>,
    val page: Int,
    val per_page: Int,
    val support: Support,
    val total: Int,
    val total_pages: Int
)