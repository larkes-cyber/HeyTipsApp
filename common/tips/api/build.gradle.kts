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
    namespace = "org.larkes.heytips.common.tips"
}