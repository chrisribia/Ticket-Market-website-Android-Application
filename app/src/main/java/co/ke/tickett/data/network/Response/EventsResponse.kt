package co.ke.tickett.data.network.Response

import co.ke.tickett.data.db.entity.Events

data class EventsResponse (
    var error : Boolean?,
    val Tickets : List<Events>
)