plugins{
    id("multiplatform")
    id(libs.plugins.serialization.get().pluginId)
}

kotlin{

    sourceSets{

        commonMain{

            dependencies{
                implementation(project(":common:core"))
                implementation(project(":common:tips:api"))
                implementation(libs.kotlinx.serialization.json)
            }

        }

    }

}

android {
    namespace = "org.larkes.contacts.common.tips.data"
}