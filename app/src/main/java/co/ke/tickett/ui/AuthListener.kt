package co.ke.tickett.ui

import co.ke.tickett.data.db.entity.User

interface AuthListener {

    fun onStarted(message: String)
    fun onSuccess(user: User)
    fun onFailure(message: String)
}