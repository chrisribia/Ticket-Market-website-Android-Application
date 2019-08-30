package co.ke.tickett.data.network.Response

import co.ke.tickett.data.db.entity.User

data class AuthResponse(
    val error : Boolean?,
    val message: String?,
    val user: User?
)