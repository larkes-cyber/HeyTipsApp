plugins{
    id("multiplatform")
}
kotlin{
    sourceSets{
        commonMain{
            dependencies{
                implementation(project(":common:core-utils"))
                implementation(project(":common:admin:presentation"))
            }
        }
    }
}

android {
    namespace = "org.larkes.contacts.common.main"
}