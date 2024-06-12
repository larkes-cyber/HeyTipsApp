plugins{
    id("multiplatform")
}
kotlin{
    sourceSets{
        commonMain{
            dependencies{
                api(libs.decompose.core)
                implementation(project(":common:core-utils"))
            }
        }
    }
}

android {
    namespace = "org.larkes.contacts.common.main"
}