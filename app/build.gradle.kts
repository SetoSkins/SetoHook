import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 34
    buildFeatures {
        prefab = true
        buildConfig = true
        viewBinding = true
        resValues = true
    }
    defaultConfig {
        applicationId = "com.setoskins.hook"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.1.0"
        buildConfigField("String", "BUILD_TIME", "\"${System.currentTimeMillis()}\"")
    }

    buildTypes {
        named("release") {
            isShrinkResources = true
            isMinifyEnabled = true
            proguardFiles("proguard-rules.pro")
        }
        named("debug") {
            versionNameSuffix = "-debug-" +
                    DateTimeFormatter.ofPattern("yyyyMMddHHmmss").format(LocalDateTime.now())
        }
    }

    androidResources {
        additionalParameters("--allow-reserved-package-id", "--package-id", "0x45")
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/**"
            excludes += "/kotlin/**"
            excludes += "/*.txt"
            excludes += "/*.bin"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    namespace = "com.setoskins.hook"
}

dependencies {
    implementation(project(":blockmiui"))
    implementation("com.github.kyuubiran:EzXHelper:2.0.7")
    implementation("org.luckypray:DexKit:1.1.8")
    implementation ("androidx.appcompat:appcompat:1.3.1")
    implementation ("androidx.core:core-ktx:1.6.0")
    implementation ("androidx.appcompat:appcompat:1.3.1")
    implementation ("androidx.preference:preference-ktx:1.1.1")
    //UI
    implementation(project(":blockmiui"))
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("com.scottyab:rootbeer-lib:0.1.0")
    //APP Center
    val appCenterSdkVersion = "4.4.3"
    implementation("com.microsoft.appcenter:appcenter-analytics:${appCenterSdkVersion}")
    implementation("com.microsoft.appcenter:appcenter-crashes:${appCenterSdkVersion}")
    compileOnly(files("libs\\compile_only\\xposed-api-82_compileonly.jar"))
    // implementation("org.lsposed.hiddenapibypass:hiddenapibypass:4.3")
}
