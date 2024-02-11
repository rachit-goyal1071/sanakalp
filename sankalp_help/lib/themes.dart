import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

abstract class AppColors {
  // Primary Color Palette
  static const Color primaryColor = Color(0xFF4CAF50); // Green
  static const Color accentColor = Color(0xFF009688); // Teal

  // Extra Xolors
  static const Color extraColor = Color(0xFF979797);
  static const Color extraLightColor = Color(0xFFB6B6B6);
  static const Color logoLightColor = Color(0xFFffdaaa);

  // Background Color Palette
  static const Color backgroundColor = Color(0xFFF5F5F5); // Light Grey

  // Text Color Palette
  static const Color textColor = Color(0xFF333333); // Dark Grey
  static const Color secondaryTextColor = Color(0xFF757575); // Grey

  // Error/Alert Color Palette
  static const Color errorColor = Color(0xFFE57373); // Light Red

  // Dark Card Color
  static const Color cardDark = Color(0xFF303334); // You can customize this color
}

abstract class AppFonts {
  static const String defaultFontFamily = 'Roboto'; // Use your desired font
}

abstract class AppTheme {
  // Light Theme
  static final ThemeData lightTheme = ThemeData(
    colorScheme: ColorScheme.fromSwatch(
      primarySwatch: Colors.green,
      accentColor: AppColors.accentColor,
      backgroundColor: AppColors.backgroundColor,
      cardColor: Colors.white,
      errorColor: AppColors.errorColor,
      brightness: Brightness.light,
    ),
    fontFamily: AppFonts.defaultFontFamily,
    appBarTheme: AppBarTheme(
      color: AppColors.primaryColor,
      iconTheme: IconThemeData(color: Colors.white),
    ),
    textTheme: TextTheme(
      headline6: TextStyle(color: AppColors.textColor, fontWeight: FontWeight.bold),
      bodyText1: TextStyle(color: AppColors.textColor),
      bodyText2: TextStyle(color: AppColors.secondaryTextColor),
      caption: TextStyle(color: AppColors.secondaryTextColor),
    ),
  );

  // Dark Theme
  static final ThemeData darkTheme = ThemeData(
    colorScheme: ColorScheme.fromSwatch(
      primarySwatch: Colors.green,
      accentColor: AppColors.accentColor,
      backgroundColor: AppColors.backgroundColor,
      cardColor: AppColors.cardDark,
      errorColor: AppColors.errorColor,
      brightness: Brightness.dark,
    ),
    fontFamily: AppFonts.defaultFontFamily,
    appBarTheme: AppBarTheme(
      color: AppColors.primaryColor,
      iconTheme: IconThemeData(color: Colors.white), systemOverlayStyle: SystemUiOverlayStyle.light, // Set brightness here for the dark theme
    ),
    textTheme: TextTheme(
      headline6: TextStyle(color: AppColors.textColor, fontWeight: FontWeight.bold),
      bodyText1: TextStyle(color: AppColors.textColor),
      bodyText2: TextStyle(color: AppColors.secondaryTextColor),
      caption: TextStyle(color: AppColors.secondaryTextColor),
    ),
  );
}
