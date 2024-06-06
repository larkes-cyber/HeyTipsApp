import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformType

plugins{
    id("multiplatform")
}

kotlin{
    sourceSets{

        commonMain{
            dependencies{

                implementation(project(":common:core"))

            }
        }

    }
}

android {
    namespace = "org.larkes.contacts.common.core.root"
}