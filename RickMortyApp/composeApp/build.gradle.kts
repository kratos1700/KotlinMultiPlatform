import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias (libs.plugins.kotlinxSerialization)
    alias (libs.plugins.kspCompose)
}

kotlin {
    // sirve para que se pueda acceder a los archivos generados por ksp
    sourceSets.commonMain{
        kotlin.srcDirs("build/generated/ksp/metadata")
    }


    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    
    sourceSets {
        task("testClasses") // per evitar errors de compilar amb el martell
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
            implementation(libs.koin.android)
            //ktor
            implementation(libs.ktor.client.okhttp)

        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)
            implementation(libs.naviation.compose)
            //koin en ordre tal com estan
            implementation(libs.koin.compose)
            implementation(libs.koin.core)
            implementation(libs.koin.compose.viewmodel)
            //Ktor
            implementation (libs.ktor.client.core)
            implementation (libs.ktor.client.negotiation)
            implementation (libs.kotlin.serialization)
            //viewModel
            implementation(libs.viewmodel.compose)
            //coil
            implementation(libs.coil.compose)
            implementation(libs.coil.network.ktor)
            //paging3
            implementation(libs.paging.compose.common)
            implementation(libs.paging.common)
            //data
            implementation(libs.kotlinx.datetime)
            //room
            implementation(libs.room.runtime)
            implementation(libs.androidx.sqlite.bundled)
        }
        iosMain.dependencies {
            implementation(libs.ktor.client.darwin) // ktor
        }
    }
}

android {
    namespace = "org.example.rickmotryapp"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "org.example.rickmotryapp"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
}

ksp{
    arg("room.schemaLocation", "$projectDir/schemas")
}

// estas dependencies son para que funcione room con ksp
dependencies {
    add("kspCommonMainMetadata", libs.room.compiler)
    add("kspAndroid", libs.room.compiler)
    add("kspIosX64", libs.room.compiler)
    add("kspIosArm64", libs.room.compiler)
    add("kspIosSimulatorArm64", libs.room.compiler)

}

