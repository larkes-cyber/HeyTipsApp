
plugins{
    id("multiplatform")
}

kotlin{
    sourceSets{

        commonMain{
            dependencies{
                implementation(libs.compose.navigation)
                implementation(project(":common:user:compose"))
                implementation(project(":common:admin:compose"))
                implementation(project(":common:core-utils"))
                implementation(project(":common:auth:compose"))
            }
        }

    }
}

android {
    namespace = "org.larkes.contacts.common.compose.root"
}