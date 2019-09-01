package co.ke.tickett.data.repository

import co.ke.tickett.data.db.AppDatabase
import co.ke.tickett.data.network.MyApi
import co.ke.tickett.data.network.SafeApiRequest

class TicketRepository(private val api: MyApi,
                       private val db: AppDatabase
): SafeApiRequest() {
}