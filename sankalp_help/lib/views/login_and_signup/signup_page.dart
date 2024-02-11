import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:colour/colour.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:glassmorphism/glassmorphism.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:sankalp_help/services/auth.dart';
import 'package:sankalp_help/themes.dart';
import 'package:sankalp_help/views/home/home_page.dart';
import '../../consts/style_guide.dart';
import 'login_page.dart';

class SignupPage extends StatefulWidget {
  const SignupPage({super.key});

  @override
  State<SignupPage> createState() => _SignupPageState();
}


final FirebaseAuth _auth = FirebaseAuth.instance;
final _emailKey = GlobalKey<EditableTextState>();
final _passwordKey = GlobalKey<EditableTextState>();
String error = "";

bool _obscureText = false;
bool _isVisible = false ;

final TextEditingController emailController = TextEditingController();
final TextEditingController userNameController = TextEditingController();
final TextEditingController passwordController = TextEditingController();

Widget entryField(Key,String title,
    TextEditingController controller,IconButton? icon,ObscureText) {
  return TextField(
    cursorColor: Colors.black,
    controller: controller,
    obscureText: ObscureText,
    style: TextStyle(
      color: Colors.black
    ),
    decoration: InputDecoration(
      filled: true,
      fillColor: Colors.white70,
      contentPadding: EdgeInsets.only(top: 10,bottom: 10,left: 7),
      focusColor: Colour('000000'),
      border: OutlineInputBorder(
          borderSide: BorderSide(color: Colors.black),
        borderRadius: BorderRadius.circular(9)
      ),
      focusedBorder: OutlineInputBorder(
          borderSide: BorderSide(color: Colors.black,width: 1.5)
      ),
      labelStyle: TextStyle(
          color: Colors.black
      ),
      suffixIcon: icon,
      labelText: title,
      suffixIconColor: Colors.black
    ),
  );
}

FirebaseAuth auth = FirebaseAuth.instance;
User? currentUser = auth.currentUser;

const userCollection = "users";

Widget submitButton(BuildContext context){
  return TextButton(
    onPressed: () async {
      try {
        dynamic result = await _auth.createUserWithEmailAndPassword(
            email: emailController.text, password: passwordController.text);
        if(result == null){
          error = "Not able to login";
        }
        else{
          Navigator.push(context,
              MaterialPageRoute(builder: (context)=> HomePage())
          );
        }
      }catch(e){
        print(e.toString());
        if(e is FirebaseException) {
          String _eMessage = e.toString();
          print(_eMessage);
        }
      }
    },
    style: ButtonStyle(
      foregroundColor: MaterialStateProperty.all<Color>(Colors.black),
      fixedSize: MaterialStateProperty.all<Size>(Size(100, 20)),
      backgroundColor: MaterialStateProperty.resolveWith((states) => Colour('212529')),
      shape: MaterialStateProperty.all<RoundedRectangleBorder>(RoundedRectangleBorder(borderRadius: BorderRadius.circular(12))),
      padding: MaterialStateProperty.all<EdgeInsets>(EdgeInsets.all(0)),
    ),
    child: Text('Submit',style: TextStyle(color: Colors.white,fontWeight: FontWeight.w400,fontSize: 15,),),
  );
}

/*google sign in button */

Widget googleSigninBtn(BuildContext context){
  return OutlinedButton(
    onPressed: () async{
      await AuthService().signInWithGoogle(context);
    },
    style: ButtonStyle(
        overlayColor: MaterialStateColor.resolveWith((states) => Colors.transparent),
        padding: MaterialStateProperty.all<EdgeInsets>(EdgeInsets.all(5)),
        fixedSize: MaterialStateProperty.all<Size>(Size(86,25)),
        shape: MaterialStateProperty.all<RoundedRectangleBorder>(RoundedRectangleBorder(borderRadius: BorderRadius.circular(9)),),
      side: MaterialStateProperty.all<BorderSide>(BorderSide(width: 1))
    ),
    child: Row(
      children: <Widget>[
        Image.asset('assets/google-icon2.png',height: 25,width: 27,),
        Text('Google',style: TextStyle(color: Colors.black,),)
      ],
    ),);
}

/*facebook sign in button */

Widget facebookSigninBtn(){
  return OutlinedButton(
    onPressed: (){
    },
    style: ButtonStyle(
        overlayColor: MaterialStateColor.resolveWith((states) => Colors.transparent),
        padding: MaterialStateProperty.all<EdgeInsets>(EdgeInsets.all(5)),
        fixedSize: MaterialStateProperty.all<Size>(Size(107,25)),
        shape: MaterialStateProperty.all<RoundedRectangleBorder>(RoundedRectangleBorder(borderRadius: BorderRadius.circular(7)))
    ),
    child: Row(
      children: <Widget>[
        Image.asset('assets/facebook-icon.png',height: 30,width: 30,),
        Spacer(),
        Text('Facebook',style: TextStyle(color: Colors.black),)
      ],
    ),);
}

class _SignupPageState extends State<SignupPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      resizeToAvoidBottomInset: false,
      body: Stack(
          children :<Widget>[
            Container(
              decoration: BoxDecoration(
                  color: Colour('#fee7df')
              ),
            ),
            Center(
              child: Container(
                constraints: BoxConstraints(minHeight: 470,maxHeight: 515,minWidth: 290,maxWidth: 310),
                decoration: BoxDecoration(
                  borderRadius: BorderRadius.circular(30),
                  color: AppColors.extraColor,
                ),
                child: Padding(
                  padding: EdgeInsets.all(1),
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    mainAxisAlignment: MainAxisAlignment.start,
                    children: <Widget>[
                      Padding(
                        padding: const EdgeInsets.only(top: 20),
                        child: Center(child: Text('Signup',style: loginPageHeadingTextStyle,)),
                      ),
                      Center(
                        child: Padding(
                          padding: const EdgeInsets.only(top: 30,bottom: 10,left: 8,right: 8),
                          child: GlassmorphicContainer(
                            width: 290,
                            height: 358,
                            borderRadius: 15,
                            border: 2,
                            blur: 2,
                            linearGradient: LinearGradient(
                                begin: Alignment.topLeft,
                                end: Alignment.bottomRight,
                                colors: [
                                  Colour('FFFFFF').withOpacity(0.35),
                                  Colour('FFFFFF').withOpacity(0.35),
                                ],
                                stops: [
                                  0.1,
                                  1,
                                ]),
                            borderGradient: LinearGradient(
                              begin: Alignment.topLeft,
                              end: Alignment.bottomRight,
                              colors: [
                                Colour('343A40').withOpacity(0.5),
                                Colour('343A40').withOpacity(0.5),
                              ],
                            ),
                            child: Column(
                              mainAxisAlignment: MainAxisAlignment.center,
                              crossAxisAlignment: CrossAxisAlignment.center,
                              children: <Widget>[
                                Padding(
                                    padding: const EdgeInsets.symmetric(vertical: 6,horizontal: 12),
                                    child: entryField(_emailKey,
                                        'Email',
                                        emailController,
                                        IconButton(
                                            onPressed: (){
                                              showDialog(context: context, builder: (context)=>
                                                  SimpleDialog(
                                                    title: Text("Enter your email address for creation of account."),
                                                    titleTextStyle: dialogBoxTextStyle,
                                                    shadowColor: Colors.black,
                                                    contentPadding: EdgeInsets.all(1),
                                                    shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(10)),
                                                    children: [
                                                      Container(
                                                        constraints: BoxConstraints(minHeight: 40,minWidth: 40,maxWidth: 40),
                                                      )
                                                    ],
                                                  ));
                                            },
                                            icon: Icon(Icons.email_outlined)),false)
                                ),
                                Padding(
                                  padding: const EdgeInsets.only(top: 6,left: 12,right: 12,bottom: 0),
                                  child: entryField(_passwordKey,"Password",
                                      passwordController,
                                      IconButton(onPressed: (){
                                        setState(() {
                                          _isVisible=!_isVisible;
                                          _obscureText = !_obscureText;
                                        });
                                      },  icon: _isVisible?Icon(CupertinoIcons.eye):Icon(Icons.visibility_off)),_obscureText
                                  ),
                                ),
                                Padding(
                                    padding: const EdgeInsets.only(top: 28),
                                    child: submitButton(context)
                                ),
                                // Divider(
                                //   indent: 19,
                                //   height: 20,
                                //   thickness: 0.6,
                                //   color: Colors.black,
                                //   endIndent: 19,
                                // ),
                                Padding(
                                  padding: const EdgeInsets.symmetric(vertical: 4),
                                  child: Center(child: Text('------------or------------',style: TextStyle(color: Colors.black,fontSize: 17),)),
                                ),
                                Row(
                                  mainAxisAlignment: MainAxisAlignment.center,
                                  children: [
                                    Padding(
                                      padding: const EdgeInsets.symmetric(vertical: 15,horizontal: 6),
                                      child: googleSigninBtn(context),
                                    ),
                                    // Padding(
                                    //   padding: const EdgeInsets.symmetric(horizontal: 6,vertical: 15),
                                    //   child: facebookSigninBtn(),
                                    // )
                                  ],
                                ),
                                TextButton(
                                    onPressed: (){
                                      Navigator.push(context,
                                          MaterialPageRoute(builder: (context)=>LoginPage()));
                                    },
                                    child: (Text("Log in?",style: TextStyle(fontWeight: FontWeight.w700,color: Colors.black),)))
                              ],
                            ),
                          ),
                        ),
                      )
                    ],
                  ),
                ),
              ),
            ),]
      ),
    );
  }
}
