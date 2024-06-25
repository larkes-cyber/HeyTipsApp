plugins{
    id("multiplatform")
}
kotlin{
    sourceSets{
        commonMain{
            dependencies{
                implementation(project(":common:core-utils"))
                implementation(project(":common:auth:presentation"))
            }
        }
    }
}

android {
    namespace = "org.larkes.heytips.common.main"
}