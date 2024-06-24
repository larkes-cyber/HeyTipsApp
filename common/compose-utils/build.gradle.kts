plugins{
    id("multiplatform")
}

kotlin{

    sourceSets{


        iosMain{
            dependencies{
                implementation(libs.peekaboo.ui)
                implementation(libs.peekaboo.image.picker)
            }
        }

        androidMain{
            dependencies{
                implementation(libs.peekaboo.ui)
                implementation(libs.peekaboo.image.picker)
            }
        }

        commonMain{

            dependencies{
                implementation(libs.compose.image.picker)
            }

        }

    }

}

android {
    namespace = "org.larkes.contacts.common.compose.utils"
}