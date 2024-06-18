plugins{
    id("multiplatform")
    id(libs.plugins.sqldelight.get().pluginId)
}

sqldelight {
    databases {
        create("TipsDatabase") {
            packageName.set("org.larkes.contacts")
            generateAsync.set(true)
        }
    }
    linkSqlite = true
}

kotlin{
    sourceSets{

        androidMain{
            dependencies{
                implementation(libs.androidx.activity.compose)
            }
        }



        commonMain{
            dependencies{
                api(libs.koin.core)
                api(libs.kotlinx.coroutines)
                api(libs.ktor.client.core)
                implementation(libs.ktor.client.json)
                implementation(libs.ktor.client.serialization)
                implementation(libs.ktor.client.negotiation)
                implementation(libs.ktor.client.logging)
            }
        }

        desktopMain{
            dependencies{
                implementation(libs.ktor.client.okhttp)
                implementation(libs.sqldelight.sqlite.driver)
            }
        }

        androidMain{
            dependencies{
                implementation(libs.ktor.client.android)
                implementation(libs.sqldelight.android.driver)
            }
        }

        iosMain{
            dependencies{
                implementation(libs.ktor.client.ios)
                implementation(libs.sqldelight.native.driver)
            }
        }

        androidUnitTest{
            dependencies{
                implementation(libs.ktor.client.core.test)
                implementation(libs.sqldelight.sqlite.driver)
                implementation(libs.ktor.client.negotiation)
                implementation(libs.ktor.client.okhttp)
            }
        }

    }
}

android {
    namespace = "org.larkes.contacts.common.core"
}