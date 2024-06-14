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
                implementation("com.eygraber:compose-color-picker:0.0.19")
            }
        }
    }
}

android {
    namespace = "org.larkes.contacts.common.main"
}