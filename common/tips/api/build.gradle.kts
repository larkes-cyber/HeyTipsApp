plugins{
    id("multiplatform")
    id(libs.plugins.serialization.get().pluginId)
}

kotlin{

    sourceSets{

        commonMain{

            dependencies{
                implementation(libs.kotlinx.serialization.json)
            }

        }

    }

}

android {
    namespace = "org.larkes.contacts.common.tips"
}