plugins{
    id("multiplatform")
}

kotlin{
    sourceSets{

        commonMain{
            dependencies{
                implementation(project(":common:core-utils"))
                implementation(libs.coil.compose.core)
                implementation(libs.coil.compose)
                implementation(libs.coil.mp)
                implementation(libs.coil.network.ktor)
            }
        }
        desktopMain{
            dependencies{
                implementation(libs.kotlinx.coroutines.swing)
            }
        }

    }
}

android {
    namespace = "org.larkes.contacts.common.tips.compose"
}