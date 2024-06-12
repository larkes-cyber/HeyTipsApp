
plugins{
    id("multiplatform")
    id(libs.plugins.serialization.get().pluginId)
}

kotlin{
    sourceSets{

        commonMain{
            dependencies{
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.kotlinx.serialization.core)
            }
        }

    }
}

android {
    namespace = "org.larkes.contacts.common.core.utils"
}