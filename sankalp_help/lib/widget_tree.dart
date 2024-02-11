import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:sankalp_help/views/home/home_page.dart';
import 'package:sankalp_help/views/login_and_signup/login_page.dart';
import 'package:sankalp_help/views/login_and_signup/signup_page.dart';

class WidgetTree extends StatefulWidget {
  const WidgetTree({super.key});

  @override
  State<WidgetTree> createState() => _WidgetTreeState();
}

final FirebaseAuth _auth= FirebaseAuth.instance;

class _WidgetTreeState extends State<WidgetTree> {
  @override
  Widget build(BuildContext context) {
    return StreamBuilder<User?>(stream: _auth.authStateChanges(),
        builder: (context,snapshot){
          if(snapshot.hasData){
            return HomePage();
          }
          else
            return SignupPage();
        });
  }
}