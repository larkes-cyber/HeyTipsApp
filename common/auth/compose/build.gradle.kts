plugins{
    id("multiplatform")
}
kotlin{
    sourceSets{
        commonMain{
            dependencies{
                implementation(project(":common:core-utils"))
                implementation(libs.compose.navigation)
            }
        }
    }
}

android {
    namespace = "org.larkes.contacts.common.main"
}