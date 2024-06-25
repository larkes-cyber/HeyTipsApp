plugins{
    id("multiplatform")
}

kotlin{
    sourceSets{

        commonMain{
            dependencies{
                implementation(project(":common:tips:api"))
            }
        }

    }
}

android {
    namespace = "org.larkes.heytips.common.admin.api"
}