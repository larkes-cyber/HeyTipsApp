rootProject.name = "ContactsApp"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

include(":composeApp")
include(":common:core")
include(":common:core-root")
include(":common:admin")
include(":common:user")
include(":common:auth")
include(":common:compose-root")
include(":common:core-utils")
include(":common:tips:api")
include(":common:tips:data")
include(":common:tips:presentation")
include(":common:tips:compose")