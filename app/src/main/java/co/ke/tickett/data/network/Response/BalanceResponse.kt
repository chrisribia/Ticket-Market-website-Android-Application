package co.ke.tickett.data.network.Response

import co.ke.tickett.data.db.entity.Stats

data class BalanceResponse (
    var error : Boolean?,
    val balance : List<Stats>
)