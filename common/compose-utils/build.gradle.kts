plugins{
    id("multiplatform")
}

kotlin{

    sourceSets{

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