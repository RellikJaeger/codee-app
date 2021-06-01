plugins {
    id(Plugin.ANDROID_APPLICATION)
    id(Plugin.KOTLIN_ANDROID)
}

android {
    compileSdk = 30
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = ApplicationConfig.PACKAGE
        minSdk = ApplicationConfig.MIN_SDK_VERSION
        targetSdk = ApplicationConfig.TARGET_SDK_VERSION
        versionCode = Version.APPLICATION_VERSION_INT
        versionName = Version.APPLICATION_VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Version.COMPOSE
    }
}

dependencies {
    implementation(androidKtCore)
    implementation(appCompat)
    implementation(material)
    implementation(composeUI)
    implementation(composeMaterial)
    implementation(composeUITooling)
    implementation(androidxLifecycle)
    implementation(activityCompose)
    testImplementation(jUnit)
    androidTestImplementation(composeJUNIT)
    implementation(kotlin(kScriptRuntime))
    implementation(codeeCore)
    implementation(kotlin("reflect"))
    implementation(kotlin("compiler-embeddable"))
    implementation(kotlin("script-util"))
    implementation(kotlin("scripting-compiler-embeddable"))
    implementation(group = "org.jetbrains.kotlin", name = "kotlin-scripting-dependencies", version = "1.5.0")
}

with(tasks) {
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            languageVersion = "1.4"
        }
    }
}