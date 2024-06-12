
plugins{
    id("multiplatform")
}

kotlin{
    sourceSets{


        commonMain{
            dependencies{
                implementation(project(":common:user:compose"))
                implementation(project(":common:admin:compose"))
                implementation(project(":common:auth:compose"))
                implementation(project(":common:user:presentation"))
                implementation(project(":common:admin:presentation"))
                implementation(project(":common:auth:presentation"))
                implementation(project(":common:core-utils"))
                api(libs.decompose.core)
                implementation(libs.decompose.jetbrains)
            }
        }

    }
}

android {
    namespace = "org.larkes.contacts.common.compose.root"
}