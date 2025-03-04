plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    //ksp for room database
    id("com.google.devtools.ksp")
}

ksp {
    this.arg("room.schemaLocation", "$projectDir/schemas")
}

android {
    namespace = "com.alpha.todolist"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.alpha.todolist"
        minSdk = 21
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

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
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17

    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    //room_database
    val roomVersion = "2.6.1"
    implementation("androidx.room:room-runtime:$roomVersion")
    ksp("androidx.room:room-compiler:$roomVersion")
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$roomVersion")

    // instead of shared preferences
    implementation("androidx.datastore:datastore-preferences:1.1.2")

    //jetpack navigation
    implementation("androidx.navigation:navigation-compose:2.8.7")

    //Splash Api
    implementation("androidx.core:core-splashscreen:1.0.1")

    //viewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7")

    //Progress Indicator
    implementation("androidx.compose.material3:material3-android:1.3.1") // if some functionality doesn't work downgrade to 1.2.0-rc01

    //Compose Foundation
    implementation("androidx.compose.foundation:foundation:1.7.8") // if some functionality doesn't work downgrade to 1.4.3

    //Accompanist
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.36.0")

    //Coil
    implementation("io.coil-kt:coil-compose:2.7.0")

    //google fonts
    implementation("androidx.compose.ui:ui-text-google-fonts:1.7.8")

    //allow older Android versions to use Java 8+ APIs
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.1.4")

    //json-to-string || opposite
    implementation("com.google.code.gson:gson:2.12.1")



    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")
    implementation("androidx.activity:activity-compose:1.10.0")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}