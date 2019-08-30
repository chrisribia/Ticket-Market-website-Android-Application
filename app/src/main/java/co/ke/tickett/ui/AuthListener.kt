package co.ke.tickett.ui

interface AuthListener {

    fun onStarted(message: String)
    fun onSuccess(message: String)
    fun onFailure(message: String)
}