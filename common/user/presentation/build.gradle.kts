plugins{
    id("multiplatform")
}

kotlin{
    sourceSets{

        commonMain{

            dependencies{

                api(libs.decompose.core)
                api(project(":common:user:api"))
                implementation(project(":common:core-utils"))
                implementation(project(":common:core"))

            }

        }

    }
}

android {
    namespace = "org.larkes.heytips.common.user.presentation"
}