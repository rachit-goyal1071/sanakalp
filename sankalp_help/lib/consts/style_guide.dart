import 'package:colour/colour.dart';
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

final TextStyle loginPageTextStyle = TextStyle(
  fontSize: 50,
  fontWeight: FontWeight.w600,
  color: Colors.black,
  letterSpacing: 2,
);

final TextStyle selectionPageTextStyle = TextStyle(
    fontSize: 23,
    color: Colors.black,
    fontWeight: FontWeight.w500
);

final TextStyle loginPageHeadingTextStyle = GoogleFonts.playfairDisplay(
  fontSize: 50,
  fontWeight: FontWeight.w400,
  letterSpacing: 1.5,
  color: Colors.black
);

final TextStyle mediumHeadingTextStyle = TextStyle(
    fontSize: 35,
    fontWeight: FontWeight.w400,
    letterSpacing: 1,
    color: mainWalaColour
);

final TextStyle everyButtonTextStyle = TextStyle(
    fontSize: 17,
    fontWeight: FontWeight.w400,
    color: Colors.black,
    letterSpacing: 0.3
);

final TextStyle dialogBoxTextStyle = TextStyle(
  fontSize: 16.5,
  letterSpacing: 0.2,
  fontWeight: FontWeight.w300,
  color: Colors.black,
);

final TextStyle dialogBoxTextStyle2 = TextStyle(
  fontSize: 18,
  letterSpacing: 0.2,
  fontWeight: FontWeight.w400,
  color: Colors.black,
);

final TextStyle navBarTextStyle = TextStyle(
  letterSpacing: 0.2,
);

final TextStyle basicWalaTextStyle = TextStyle(
    letterSpacing: 0.2,
    fontSize: 22,
    fontFamily: "Roboto",
    fontWeight: FontWeight.w500,
  color: Colors.black
);

final TextStyle basicWala2TextStyle = GoogleFonts.notoSans(
    letterSpacing: 0.2,
    fontSize: 25,
    fontWeight: FontWeight.w600,
    color: Colors.black
);

final TextStyle chotiHeadingTextStyle = TextStyle(
  fontSize: 20,
  fontWeight: FontWeight.w400,
);

final Colour mainWalaColour = Colour(
    "#FE7240" //0xffFE7240
);

final Colour main2WalaColour = Colour(
    "#e57373" //0xfffea585
);

gradient7(){
  return LinearGradient(colors: [Colors.cyan, Colors.cyanAccent],begin: Alignment.topCenter,end: Alignment.bottomCenter);
}
