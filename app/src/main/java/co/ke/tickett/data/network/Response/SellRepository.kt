package co.ke.tickett.data.network.Response

import co.ke.tickett.data.db.entity.Events
import co.ke.tickett.data.db.entity.Sell

data class SellRepository (
    var error : Boolean?,
    val Tickets : List<Sell>
)