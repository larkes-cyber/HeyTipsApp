plugins{
    id("multiplatform")
}
kotlin{
    sourceSets{
        commonMain{
            dependencies{
                implementation(project(":common:core-utils"))
                implementation(project(":common:admin:presentation"))
                implementation(project(":common:compose-utils"))
                implementation(libs.compose.color.picker)
            }
        }
    }
}

android {
    namespace = "org.larkes.contacts.common.main"
}