package com.arpitkatiyarprojects.countrypickerproject.base

import android.app.Application
import android.os.StrictMode

class BaseApp : Application() {
    override fun onCreate() {
        super.onCreate()
        // Thread policy to detect disk and network access on the main thread
        StrictMode.setThreadPolicy(
            StrictMode.ThreadPolicy.Builder()
                //.detectAll()
                .detectNetwork()
                .detectDiskWrites()
                .detectCustomSlowCalls()
                .detectExplicitGc()
                .detectUnbufferedIo()
                .detectResourceMismatches()
                .penaltyDeath()
                .penaltyDeathOnNetwork()
                .penaltyDialog()
                .penaltyDropBox()
                .penaltyLog()
                //.penaltyDeath() // crashes the app when a violation is detected
                .build()
        )

        // VM policy to detect leaked resources or objects
        StrictMode.setVmPolicy(
            StrictMode.VmPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .penaltyDropBox()
                .penaltyDeathOnFileUriExposure()
                .penaltyDeathOnCleartextNetwork()
               // .penaltyDeath() // crashes the app when a violation is detected
                .build()
        )
    }
}