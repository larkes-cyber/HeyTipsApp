rootProject.name = "heytipsApp"
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
include(":common:admin:api")
include(":common:admin:data")
include(":common:admin:presentation")
include(":common:admin:compose")
include(":common:user:api")
include(":common:user:data")
include(":common:user:presentation")
include(":common:user:compose")
include(":common:auth:compose")
include(":common:auth:presentation")
include(":common:auth:api")
include(":common:auth:data")
include(":common:compose-root")
include(":common:core-utils")
include(":common:tips:api")
include(":common:tips:data")
include(":common:tips:presentation")
include(":common:tips:compose")
include(":common:compose-utils")