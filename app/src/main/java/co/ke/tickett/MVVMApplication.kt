package co.ke.tickett

import android.app.Application
import co.ke.tickett.data.db.AppDatabase
import co.ke.tickett.data.network.MyApi
import co.ke.tickett.data.network.NetworkConnectionInterceptor
import co.ke.tickett.data.repository.EventsRespository
import co.ke.tickett.data.repository.UserRepository
import co.ke.tickett.ui.CodeFragment.CodeViewModelFactory
import co.ke.tickett.ui.ScannFragment.ScanViewModelFactory
import co.ke.tickett.ui.StatFragment.StatsViewModelFactory
import co.ke.tickett.ui.login.AuthViewModelFactory
import co.ke.tickett.ui.home.HomeViewModelFactory
import co.ke.tickett.ui.profileFragment.ProfileViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MVVMApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@MVVMApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { UserRepository(instance(), instance()) }
        bind() from singleton { EventsRespository(instance(), instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }
        bind() from provider { HomeViewModelFactory(instance()) }
        bind() from provider { ProfileViewModelFactory(instance()) }
        bind() from provider { ScanViewModelFactory(instance()) }
        bind() from provider { StatsViewModelFactory(instance()) }
        bind() from provider { CodeViewModelFactory(instance()) }


    }
}