plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion(29)
    buildToolsVersion = "29.0.3"

    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        named("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(fileTree("dir" to "libs", "includes" to listOf("*.jar")))
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
    implementation("androidx.appcompat:appcompat:${rootProject.extra["appcompat_version"]}")
    implementation("androidx.paging:paging-runtime:2.1.2")
    implementation("com.google.android.material:material:${rootProject.extra["material_version"]}")

    testImplementation("junit:junit:${rootProject.extra["junit_version"]}")

    androidTestImplementation("androidx.test.ext:junit:${rootProject.extra["test_ext_version"]}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${rootProject.extra["test_espresso_version"]}")
}