import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformType

plugins{
    id("multiplatform")
}

kotlin{
    sourceSets{

        commonMain{
            dependencies{
                implementation(project(":common:core"))
                implementation(project(":common:tips:data"))
                implementation(project(":common:admin:data"))
                implementation(project(":common:user:data"))

            }
        }

    }
}

android {
    namespace = "org.larkes.contacts.common.core.root"
}