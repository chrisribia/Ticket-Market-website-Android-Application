package co.ke.tickett.data.network.Response

import co.ke.tickett.data.db.entity.Summery

data class BalanceResponse (
    var error : Boolean?,
    var Events : List<Summery>
)