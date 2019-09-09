package co.ke.tickett.ui.login

import co.ke.tickett.data.db.entity.User

interface AuthListener {

    fun onStarted()
    fun onSuccess(user: User)
    fun onFailure(message: String)
}