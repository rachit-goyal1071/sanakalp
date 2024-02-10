import 'package:colour/colour.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:sankalp_help/themes.dart';
import 'package:sankalp_help/views/home/home_page.dart';
import '../../consts/style_guide.dart';
import '../../services/auth.dart';
import 'signup_page.dart';

class LoginPage extends StatefulWidget {
  const LoginPage({super.key});

  @override
  State<LoginPage> createState() => _LoginPageState();
}
final TextEditingController emailController = TextEditingController();
final TextEditingController userNameController = TextEditingController();
final TextEditingController passwordController = TextEditingController();
bool _obscureText = false;
bool _isVisible = false;
bool _isTransformed = false;

final AuthService _auth = AuthService();
String _eMessage="";

Widget submitButton(BuildContext context){
  return ElevatedButton(
    onPressed: () async {
      try {
        dynamic result = await _auth.signinWithEmailAndPassword(
            emailController.text, passwordController.text);
        if(result == null){
          error = "Not able to login";
        }
        else{
          Navigator.push(context, MaterialPageRoute(builder: (context)=>HomePage()));
        }
      }catch(e){
        // print(e.toString());
        if(e is FirebaseException) {
          _eMessage = e.toString();
          print(_eMessage);
        }
      }
    },
    style: ButtonStyle(
      fixedSize: MaterialStateProperty.all<Size>(Size(100, 20)),
      backgroundColor: MaterialStateProperty.resolveWith((states) => Colour('212529')),
      shape: MaterialStateProperty.all<RoundedRectangleBorder>(RoundedRectangleBorder(borderRadius: BorderRadius.circular(12))),
      padding: MaterialStateProperty.all<EdgeInsets>(EdgeInsets.all(0)),
    ),
    child: Text('Submit',style: TextStyle(color: Colors.white,fontWeight: FontWeight.w400,fontSize: 15,),),
  );
}

Widget entryField(Key,String title,
    TextEditingController controller,IconButton? icon,ObscureText) {
  return TextField(
    cursorColor: Colors.black,
    controller: controller,
    obscureText: ObscureText,
    decoration: InputDecoration(
      contentPadding: EdgeInsets.only(top: 10,bottom: 10,left: 7),
      focusColor: Colour('000000'),
      border: OutlineInputBorder(
          borderSide: BorderSide(color: Colors.black)
      ),
      focusedBorder: OutlineInputBorder(
          borderSide: BorderSide(color: Colors.black,width: 1.5)
      ) ,
      labelText: title,
      labelStyle: TextStyle(
          color: Colors.black
      ),
      suffixIcon: icon,
      // labelStyle: ,
    ),
  );
}

class _LoginPageState extends State<LoginPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: main2WalaColour,
      ),
      backgroundColor: main2WalaColour,
      resizeToAvoidBottomInset: true,
      body: SingleChildScrollView(
        child: Stack(
            children: [
              Container(
                  decoration: BoxDecoration(
                      color: AppColors.backgroundColor
                  ),
                  child: Column(
                    children: [
                      // Container(
                      //   decoration: BoxDecoration(
                      //       color: AppColors.extraLightColor
                      //   ),
                      //   child: Container(
                      //     color: Colors.white38,
                      //     child: Row(
                      //       crossAxisAlignment: CrossAxisAlignment.start,
                      //       children: [
                      //         IconButton(
                      //             onPressed: (){
                      //               Navigator.push(context, MaterialPageRoute(builder: (context) => SignupPage()));
                      //             },
                      //             icon: Icon(Icons.arrow_back,size: 33,color: Colors.black,))
                      //       ],
                      //     ),
                      //   ),
                      // ),
                      Container(
                          width: 400,
                          height: MediaQuery.of(context).size.height*0.44,
                          padding: EdgeInsets.only(bottom: 20,top: 0),
                          decoration: const BoxDecoration(
                              color: AppColors.backgroundColor
                          ),
                          // color: Color(0xffFE7240),
                          child: Image.asset("assets/logo.png",height: 200)),
                      Padding(
                        padding: const EdgeInsets.only(top: 0),
                        child: AnimatedContainer(
                          duration: Duration(milliseconds: 30),
                          margin: EdgeInsets.only(
                              bottom: MediaQuery.of(context).viewInsets.bottom
                          ),
                          height: MediaQuery.of(context).size.height*0.4461,
                          decoration: BoxDecoration(
                            borderRadius: BorderRadius.only(topLeft: Radius.circular(30),topRight: Radius.circular(30)),
                            color: main2WalaColour,
                          ),
                          child: Padding(
                            padding: const EdgeInsets.all(8.0),
                            child: Column(
                              crossAxisAlignment: CrossAxisAlignment.start,
                              children: [
                                Padding(
                                  padding: const EdgeInsets.only(top: 20,bottom: 20,),
                                  child: Center(child: Text("LOGIN",style: basicWala2TextStyle)),
                                ),
                                Padding(
                                  padding: const EdgeInsets.all(8.0),
                                  child: Column(
                                    mainAxisAlignment: MainAxisAlignment.center,
                                    children: [
                                      Padding(
                                        padding: const EdgeInsets.all(8.0),
                                        child: entryField(Key, "Email", emailController, IconButton(onPressed: null, icon: Icon(Icons.email_outlined)),false),
                                      ),
                                      Padding(
                                        padding: const EdgeInsets.all(8.0),
                                        child: entryField(Key, "Password", passwordController, IconButton(onPressed: (){
                                          setState(() {
                                            _obscureText = !_obscureText;
                                            _isVisible = !_isVisible;
                                          });
                                        }, icon: _isVisible? Icon(CupertinoIcons.eye):Icon(CupertinoIcons.eye_slash)),_obscureText),
                                      ),
                                      Padding(
                                        padding: const EdgeInsets.all(8.0),
                                        child: submitButton(context),
                                      ),
                                    ],
                                  ),
                                ),
                              ],
                            ),
                          ),
                        ),
                      )
                    ],
                  )
              ),
            ]
        ),
      ),
    );
  }
}
