  <h1 align="center">HeyTips</h1>
<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=24"><img alt="API" src="https://img.shields.io/badge/API-24%2B-brightgreen.svg?style=flat"/></a>
</p>
<p align="center">  
  HeyTips is a fullstack cross-platform mobile app that demonstrates modern Compose Multiplatform development with Decompose, Koin, SqlDelight, Ktor based on Multi-Module MVI architecture. Includes admin panel and user sreens based on one technology.
</p>

> [!TIP]
> If you want to see more the Kotlin Multiplatform content, check out the [telegram](https://t.me/snikky_notes) channel.
<img width="1440" alt="image" src="https://github.com/larkes-cyber/HeyTipsApp/assets/79082708/aeae86f0-b91e-484c-a0a6-b6302d586b7f">

## Download
Go to the [Releases](https://github.com/larkes-cyber/HeyTipsApp/releases/tag/publish) to download the latest APK.

## Main features
- Ios/Android/Desktop
- Caching/Pagination
- Image Picker/Internet Images
- Multi-module/MVI
- Unit tests
- MVC ktor server

## Overview
https://github.com/larkes-cyber/HeyTipsApp/assets/79082708/c5a8d48d-8b56-46f8-8229-09546190bbb8

## [Admin overview](https://drive.google.com/file/d/1EE9t2STVpTXjqui5ElY9uj6weLOooZqR/view?usp=sharing)
## [Desktop overview](https://drive.google.com/file/d/1MBCaQKwFDSDqJmL8322-t_sleTriB1GR/view?usp=sharing)


## Tech stack & Open-source libraries
- Minimum SDK level 24
- iOS Deployment Target 15.3
- [Kotlin Multiplatform](https://www.jetbrains.com/kotlin-multiplatform/) based, [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/) for Android/Ios/Desktop ui interfaces.
- Kotlin Multiplatform
  -  Expected/actual: Expected and actual declarations allow you to access platform-specific APIs from Kotlin Multiplatform modules. You can provide platform-agnostic APIs in the common code.
  - Gradle kts: Gradle’s Kotlin DSL provides an alternative syntax to the traditional Groovy DSL with an enhanced editing experience in supported IDEs, with superior content assist.
- Architecture
  - Multi-Module Concept: Modularization is a practice of organizing a codebase into loosely coupled and self contained parts. Each part is a module. Each module is independent and serves a clear purpose.
  - Decompose: library for breaking down your code into tree-structured lifecycle-aware business logic components (aka BLoC), with routing functionality and pluggable UI
  - [Koin](https://insert-koin.io/docs/reference/koin-mp/kmp/): Koin provides us with an all-in kotlin library to use it in our shared module to create injections that can be used by both Android and iOS
  - Repository Pattern: Repository commonly refers to a storage location, often for safety or preservation.
- Client/Server
  - [SqlDelight](https://github.com/cashapp/sqldelight):SQLDelight is a powerful tool for implementing data persistence in Kotlin Multiplatform Mobile (KMM) projects
  - [Ktor](https://ktor.io/docs/client-create-multiplatform-application.html):Ktor includes a multiplatform asynchronous HTTP client, which allows you to make requests and handle responses, extend its functionality with plugins, such as authentication, JSON serialization, and so on.
  - [Serialization﻿](https://github.com/Kotlin/kotlinx.serialization): Kotlin serialization consists of a compiler plugin, that generates visitor code for serializable classes, runtime library with core serialization API and support libraries with various serialization formats.

## <img width="800" alt="image" src="https://github.com/larkes-cyber/HeyTipsApp/assets/79082708/e441d672-cefe-44de-a7f5-b1edffb6cc3d">


### Compose Multiplatform
- **Coil: Loading images from network.**
> Code implementation: [realization](https://github.com/larkes-cyber/HeyTipsApp/blob/release/common/tips/compose/src/commonMain/kotlin/views/TipView.kt)
> 
> Dependencies: [gradle](https://github.com/larkes-cyber/HeyTipsApp/blob/release/common/tips/compose/build.gradle.kts)
> 
> Lib overview: [link](https://proandroiddev.com/coil-for-compose-multiplatform-5745ea76356f)

- **File Picker: Compose file picker for desktop.**
> Code implementation: [realization](https://github.com/larkes-cyber/HeyTipsApp/blob/release/common/compose-utils/src/desktopMain/kotlin/ImagePicker.desktop.kt)
> 
> Dependencies: [gradle](https://github.com/larkes-cyber/HeyTipsApp/blob/release/common/compose-utils/build.gradle.kts)
> 
> Lib overview: [link](https://github.com/Wavesonics/compose-multiplatform-file-picker)

- **Image Picker: Image picker for Android/Ios.**
> Code implementation:
> - [android realization](https://github.com/larkes-cyber/HeyTipsApp/blob/release/common/compose-utils/src/androidMain/kotlin/ImagePicker.android.kt)
> - [ios realization](https://github.com/larkes-cyber/HeyTipsApp/blob/release/common/compose-utils/src/iosMain/kotlin/ImagePicker.ios.kt)
> 
> Dependencies: [gradle](https://github.com/larkes-cyber/HeyTipsApp/blob/release/common/compose-utils/build.gradle.kts)
> 
> Lib overview: [link](https://github.com/onseok/peekaboo)

- **Color Picker: Cross-platform color picker.**
> Code implementation: [realization](https://github.com/larkes-cyber/HeyTipsApp/blob/release/common/admin/compose/src/commonMain/kotlin/add/AddTipScreen.kt)
> 
> Dependencies: [gradle](https://github.com/larkes-cyber/HeyTipsApp/blob/release/common/admin/compose/build.gradle.kts)
> 
> Lib overview: [link](https://github.com/eygraber/compose-color-picker)

- **Decompose Navigation: Cross-platform navigation.**
> Code implementation:
> - [nav realization](https://github.com/larkes-cyber/HeyTipsApp/tree/release/common/compose-root/src/commonMain/kotlin)
> - [android realization](https://github.com/larkes-cyber/HeyTipsApp/blob/release/composeApp/src/androidMain/kotlin/org/larkes/contacts/MainActivity.kt)
> - [ios realization](https://github.com/larkes-cyber/HeyTipsApp/blob/release/composeApp/src/iosMain/kotlin/MainViewController.kt)
> - [desktop realization](https://github.com/larkes-cyber/HeyTipsApp/blob/release/composeApp/src/jvmMain/kotlin/main.kt)
> 
> Dependencies: [gradle](https://github.com/larkes-cyber/HeyTipsApp/blob/release/common/compose-root/build.gradle.kts)
> 
> Lib overview: [link](https://www.youtube.com/watch?v=g4XSWQ7QT8g&ab_channel=PhilippLackner)


### <img width="600" alt="image" src="https://github.com/larkes-cyber/HeyTipsApp/assets/79082708/fcb8d7ac-2d01-47dc-bc1b-9228815dc24d">

## Architecture
**HeyTipsApp** is based on the Multi-Module Concept, the MVI architecture and the Repository pattern

<img width="400" alt="image" src="https://github.com/larkes-cyber/PokedexApp/assets/79082708/503c2012-d204-430a-b816-7223d4afc356">
<img width="400" alt="image" src="https://github.com/larkes-cyber/PokedexApp/assets/79082708/8997f2bf-4a9c-461e-9860-a561ab9e1cbb">

The project includes 8 modules where: 1 composeApp, 3 features, 2 core, 1 umbrella, 1 utils.

### Tips
The feature is to work with tips and contain common ui components. Included unit tests

### Feature User
The feature is  to represent app user side

### Feature Admin
The feature is to represent app admin side

<img width="1048" alt="image" src="https://github.com/larkes-cyber/HeyTipsApp/assets/79082708/3baffd84-1336-4976-8c8d-eb4b5dc59744">

## How to launch
- Clone repository
- Launch the server [https://github.com/larkes-cyber/HeyTipsBackend)
- Paste your server url into SERVER_URL [link](https://github.com/larkes-cyber/HeyTipsApp/blob/release/common/core-utils/src/commonMain/kotlin/Constants.kt)
- Launch android app from android studio, ios from xCode
- Launch desktop app by entering in terminal **/.gradle run**
- Enjoy the app!
