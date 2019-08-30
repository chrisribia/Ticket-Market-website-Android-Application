package co.ke.tickett.data.repository

import co.ke.tickett.data.db.AppDatabase
import co.ke.tickett.data.db.entity.User
import co.ke.tickett.data.network.MyApi
import co.ke.tickett.data.network.Response.AuthResponse
import co.ke.tickett.data.network.SafeApiRequest


class UserRepository(
    private val api: MyApi,
    private val db: AppDatabase
) : SafeApiRequest() {

    suspend fun userLogin(email: String, password: String): AuthResponse {
        return apiRequest { api.userLogin(email, password) }
    }


    suspend fun saveUser(user: User) = db.getUserDao().upsert(user)

    fun getUser() = db.getUserDao().getuser()

}