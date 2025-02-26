package com.alpha.todolist.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.googlefonts.Font
import com.alpha.todolist.R



val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val PlayfairDisplayFontFamily = FontFamily(
    Font(
        googleFont = GoogleFont("Playfair Display"),
        fontProvider = provider,
    )
)

val MysteryQuestFontFamily = FontFamily(
    Font(
        googleFont = GoogleFont("Mystery Quest"),
        fontProvider = provider,
    )
)

// Default Material 3 typography values
val baseline = Typography()

val Typography = Typography(
    displayLarge = baseline.displayLarge.copy(fontFamily = MysteryQuestFontFamily),
    displayMedium = baseline.displayMedium.copy(fontFamily = MysteryQuestFontFamily),
    displaySmall = baseline.displaySmall.copy(fontFamily = MysteryQuestFontFamily),
    headlineLarge = baseline.headlineLarge.copy(fontFamily = MysteryQuestFontFamily),
    headlineMedium = baseline.headlineMedium.copy(fontFamily = MysteryQuestFontFamily),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = MysteryQuestFontFamily),
    titleLarge = baseline.titleLarge.copy(fontFamily = MysteryQuestFontFamily),
    titleMedium = baseline.titleMedium.copy(fontFamily = MysteryQuestFontFamily),
    titleSmall = baseline.titleSmall.copy(fontFamily = MysteryQuestFontFamily),
    bodyLarge = baseline.bodyLarge.copy(fontFamily = PlayfairDisplayFontFamily),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = PlayfairDisplayFontFamily),
    bodySmall = baseline.bodySmall.copy(fontFamily = PlayfairDisplayFontFamily),
    labelLarge = baseline.labelLarge.copy(fontFamily = PlayfairDisplayFontFamily),
    labelMedium = baseline.labelMedium.copy(fontFamily = PlayfairDisplayFontFamily),
    labelSmall = baseline.labelSmall.copy(fontFamily = PlayfairDisplayFontFamily),
)




