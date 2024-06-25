package org.larkes.heytips

import PlatformConfiguration
import PlatformSDK
import android.app.Application

class heytipsApp:Application() {
    override fun onCreate() {
        super.onCreate()
        PlatformSDK.init(PlatformConfiguration(this))
    }
}