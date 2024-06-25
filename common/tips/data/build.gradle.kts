plugins{
    id("multiplatform")
    id(libs.plugins.serialization.get().pluginId)
}

kotlin{

    sourceSets{

        commonMain{

            dependencies{
                implementation(project(":common:core"))
                implementation(project(":common:tips:api"))
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.kotlinx.serialization.core)
            }

        }
        androidUnitTest{

            dependencies{
                implementation(libs.ktor.client.core.test)
                implementation(libs.ktor.client.okhttp)
                implementation(libs.sqldelight.sqlite.driver)
                implementation(libs.ktor.client.negotiation)
                implementation(libs.kotlin.test)
                implementation(libs.ktor.client.json)
            }

        }

    }

}

android {
    namespace = "org.larkes.heytips.common.tips.data"
}