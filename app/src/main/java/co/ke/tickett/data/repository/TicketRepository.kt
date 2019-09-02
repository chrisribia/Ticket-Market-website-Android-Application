package co.ke.tickett.data.repository

import androidx.lifecycle.MutableLiveData
import co.ke.tickett.data.PreferenceProvider
import co.ke.tickett.data.db.AppDatabase
import co.ke.tickett.data.db.entity.Tickets
import co.ke.tickett.data.network.MyApi
import co.ke.tickett.data.network.SafeApiRequest
import co.ke.tickett.utils.Coroutines
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit



private val MINIMUM_INTERVAL = 2
class TicketRepository(private val api: MyApi,
                       private val db: AppDatabase,
                       private val prefs: PreferenceProvider
): SafeApiRequest() {


    private val ticktes = MutableLiveData<List<Tickets>>()

    init {
        ticktes.observeForever {
            saveTickets(it)
        }
    }


     suspend fun fetchTickets() {
        val lastSavedAt = prefs.getLastSavedAt()

        if (lastSavedAt == null || isFetchNeeded(LocalDateTime.parse(lastSavedAt))) {
            val response = apiRequest { api.getTickets() }
            ticktes.postValue(response.Tickets)
        }
    }

    private fun isFetchNeeded(savedAt: LocalDateTime): Boolean {
        return ChronoUnit.HOURS.between(savedAt, LocalDateTime.now()) > MINIMUM_INTERVAL
    }

    private fun saveTickets(quotes: List<Tickets>) {
        Coroutines.io {
            prefs.savelastSavedAt(LocalDateTime.now().toString())
            db.getTickets().saveAllTickets(quotes)
        }
    }

    fun findTicket(qr: String) = db.getTickets().getTicket(qr)

}