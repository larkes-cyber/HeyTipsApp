plugins{
    id("multiplatform")
}

kotlin{
    sourceSets{

        commonMain{
            dependencies{
                implementation(project(":common:admin:api"))
                implementation(project(":common:tips:api"))
                implementation(project(":common:core"))
            }
        }

    }
}

android {
    namespace = "org.larkes.contacts.common.admin.data"
}