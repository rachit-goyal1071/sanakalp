import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:sankalp_help/consts/style_guide.dart';
import 'package:sankalp_help/consts/widgets.dart';
import 'package:sankalp_help/services/auth.dart';
import 'package:sankalp_help/themes.dart';
import 'package:sankalp_help/views/pages/index.dart';
import '../login_and_signup/signup_page.dart';

class NGODashboard extends StatefulWidget {
  const NGODashboard({super.key});

  @override
  State<NGODashboard> createState() => _NGODashboardState();
}

class _NGODashboardState extends State<NGODashboard> {
  AuthService _auth = AuthService();
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: AppColors.backgroundColor,
      appBar: AppBar(
        backgroundColor: AppColors.errorColor,
        leading: IconButton(
          onPressed: (){
          Navigator.pop(context);},
          icon: Icon(CupertinoIcons.back),
        ),
      ),
      body: Container(
        child: Column(
          children: [
            ListTile(
              leading:
              Container(
                width: 70,
                child: AspectRatio(
                  aspectRatio: 1,
                  child: Container(
                    decoration: BoxDecoration(
                        borderRadius: BorderRadius.all(Radius.circular(14)),
                        image: DecorationImage(image: AssetImage("assets/Muskan_foundation.png"))
                    ),
                  ),
                ),
              ),
              title: Text("Muskan Foundation",style: chotiHeadingTextStyle,),
              subtitle: Text("contact@muskanfoundation.org.in"),
            ),
            ElevatedButton(onPressed: (){
              Navigator.push(context, MaterialPageRoute(builder: (context)=> IndexPage()));
            }, child: Text("Chat")),
            Center(
              child: ElevatedButton(onPressed: () async {
                try {
                  Navigator.push(context, MaterialPageRoute(builder: (
                      context) => SignupPage()));
                  await _auth.logoutFunct(context);
                } catch (e) {
                  print(e.toString());
                }
              },child: const Text("Logout")),
            )
          ],
        ),
      ),
    );
  }
}
