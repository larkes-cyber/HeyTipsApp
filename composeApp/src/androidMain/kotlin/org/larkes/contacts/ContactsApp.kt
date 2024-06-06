package org.larkes.contacts

import PlatformConfiguration
import PlatformSDK
import android.app.Application

class ContactsApp:Application() {
    override fun onCreate() {
        super.onCreate()
        PlatformSDK.init(PlatformConfiguration(this))
    }
}