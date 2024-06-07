
plugins{
    id("multiplatform")
}

kotlin{
    sourceSets{

        commonMain{
            dependencies{

                implementation(libs.compose.navigation)

            }
        }

    }
}

android {
    namespace = "org.larkes.contacts.common.compose.root"
}