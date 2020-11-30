package com.lepaya.test

import android.app.Application
import android.content.Context
import com.lepaya.test.di.interactorsModule
import com.lepaya.test.di.networkModule
import com.lepaya.test.di.repositoriesModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber
import java.io.File


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        //Fix Temporary Google Map Crash.
        removeMapSDKTempIssue()

        // Set up Timber to see logs
        setUpTimber()
        // Next step is set up DI with Koin
        setUpKoin()
    }

    private fun removeMapSDKTempIssue() {
        val googleBug =
            getSharedPreferences("google_bug_154855417", Context.MODE_PRIVATE)
        if (!googleBug.contains("fixed")) {
            val corruptedZoomTables = File(filesDir, "ZoomTables.data")
            corruptedZoomTables.delete()
            googleBug.edit().putBoolean("fixed", true).apply()
        }
    }

    private fun setUpTimber() {
        // Build crash reporting tree only if this option
        // is enabled for current build type

            Timber.plant(Timber.DebugTree())
    }

    private fun setUpKoin() {
        // Start Koin for DI
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                listOf(
                    repositoriesModule,
                    interactorsModule,
                    networkModule
                )
            )
        }
    }
}