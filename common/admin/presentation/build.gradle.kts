plugins{
    id("multiplatform")
}
kotlin{
    sourceSets{
        commonMain{
            dependencies{
                api(libs.decompose.core)
                implementation(project(":common:core-utils"))
                implementation(project(":common:core"))
                api(project(":common:admin:api"))
            }
        }
    }
}

android {
    namespace = "org.larkes.contacts.common.main"
}