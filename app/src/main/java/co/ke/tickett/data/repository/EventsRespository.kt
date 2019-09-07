package co.ke.tickett.data.repository

import androidx.lifecycle.MutableLiveData
import co.ke.tickett.data.db.AppDatabase
import co.ke.tickett.data.db.entity.Events
import co.ke.tickett.data.network.MyApi
import co.ke.tickett.data.network.SafeApiRequest

class EventsRespository(private val api: MyApi,
                        private val db: AppDatabase) : SafeApiRequest() {

    private val events = MutableLiveData<List<Events>>()
}