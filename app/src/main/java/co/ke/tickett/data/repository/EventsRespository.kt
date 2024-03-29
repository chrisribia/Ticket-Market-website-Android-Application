package co.ke.tickett.data.repository

import androidx.lifecycle.MutableLiveData
import co.ke.tickett.data.db.AppDatabase
import co.ke.tickett.data.db.entity.Events
import co.ke.tickett.data.network.MyApi
import co.ke.tickett.data.network.Response.ConfirmResponse
import co.ke.tickett.data.network.SafeApiRequest
import co.ke.tickett.utils.Coroutines

class EventsRespository(private val api: MyApi,
                        private val db: AppDatabase) :
    SafeApiRequest() {

    private val events = MutableLiveData<List<Events>>()


    init {
        events.observeForever {
            saveEvents(it)
        }


    }

    suspend fun fetchTickets() {
            val response = apiRequest { api.getEvents() }
            events.postValue(response.Events)

    }
    private fun saveEvents(events: List<Events>) {
        Coroutines.io {
            db.getEventsDao().saveAllEvents(events)
        }
    }

    fun findEvent(qr: String) = db.getEventsDao().findEvent(qr)


    suspend fun confirmTicket(qr_code : String)  : ConfirmResponse{

        return apiRequest {  api.confirmTicket(qr_code)}
    }

    suspend fun confirmTicketCode(Ticket_code : String)  : ConfirmResponse{

        return apiRequest {  api.confirmTicketByCode(Ticket_code)}
    }




    fun getEvents() = db.getEventsDao().getEvents()

    fun findEventBycode(query: String) = db.getEventsDao().findEventByCode(query)

    fun findEventBycodez(query: String) = db.getEventsDao().findByCodez(query)

}