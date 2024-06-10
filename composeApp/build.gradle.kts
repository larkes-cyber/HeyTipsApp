import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    id(libs.plugins.android.get().pluginId)
    id(libs.plugins.kotlin.get().pluginId)
    id(libs.plugins.compose.get().pluginId)
    id(libs.plugins.cocoapods.get().pluginId)
}

version = "0.0.1"


kotlin {
    jvmToolchain(17)
    androidTarget()
    jvm()

    listOf(
        iosArm64(),
        iosX64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "ComposeApp"
            isStatic = false
            linkerOpts.add("-lsqlite3")
        }
    }

    targets.withType<KotlinNativeTarget> {
        binaries {
            all {
                linkerOpts("-lsqlite3")
            }
        }
    }

    cocoapods {
        summary = "PlayZone iOS SDK"
        homepage = "https://google.com"
        ios.deploymentTarget = "14.0"

        framework {
            transitiveExport = false
            baseName = "SharedSDK"
            export(project(":common:core"))
            export(project(":common:core-root"))
            export(libs.compose.navigation)
            export(project(":common:compose-root"))
            isStatic = true
            export("org.jetbrains.compose.collection-internal:collection:1.6.0-beta01")
        }
    }

    sourceSets {

        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(project(":common:core-root"))
            implementation(project(":common:core"))
            implementation(libs.compose.navigation)
            implementation(project(":common:compose-root"))
            implementation("org.jetbrains.compose.collection-internal:collection:1.6.0-beta01")
        }
        jvmMain.dependencies {
            implementation(compose.desktop.currentOs)
        }
        iosMain{
            dependencies{
                api(project(":common:core-root"))
                api(project(":common:core"))
                api(libs.compose.navigation)
                api(project(":common:compose-root"))
                api("org.jetbrains.compose.collection-internal:collection:1.6.0-beta01")

            }
        }
    }
}


android {
    namespace = "org.larkes.contacts"
    compileSdk = 34
    defaultConfig {
        applicationId = "org.larkes.contacts"
        minSdk = libs.versions.mindsdk.get().toInt()
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}


compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "org.larkes.contacts"
            packageVersion = "1.0.0"
        }
    }
}
