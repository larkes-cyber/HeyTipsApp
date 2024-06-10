plugins{
    id("multiplatform")
}

kotlin{

    sourceSets{
        commonMain{

            dependencies{
                implementation(project(":common:tips:api"))
                implementation(project(":common:user:api"))
                implementation(project(":common:core"))
            }

        }

    }

}

android {
    namespace = "org.larkes.contacts.common.user"
}