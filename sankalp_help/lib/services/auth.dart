import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:google_sign_in/google_sign_in.dart';
import 'package:sankalp_help/views/home/home_page.dart';
import 'package:sankalp_help/views/login_and_signup/login_page.dart';
import 'package:sankalp_help/views/login_and_signup/signup_page.dart';

class Users{
  final String uid;
  Users({required this.uid});
}
const List<String> scopes = <String>[
  'email',
  'https://www.googleapis.com/auth/contacts.readonly',
];

GoogleSignIn _googleSignIn = GoogleSignIn(
  // Optional clientId
  // clientId: 'your-client_id.apps.googleusercontent.com',
  scopes: scopes,
);

FirebaseAuth auth = FirebaseAuth.instance;
FirebaseFirestore firestore = FirebaseFirestore.instance;
const userCollection = "users";
const canteenMenuItem = "menu_items";
const cartCollection = "cart";

class AuthService{
  final FirebaseAuth _auth = FirebaseAuth.instance;
  Users? _userFromFirebase(User? user) {
    return user != null ? Users(uid: user.uid) : null;
  }

  //signIn with email and password
  Future signinWithEmailAndPassword(String email, String password) async{
    try{
      UserCredential userCredential = await _auth.signInWithEmailAndPassword(email: email, password: password);
      User? user = userCredential.user;
      return _userFromFirebase(user);
    }catch(e){
      print(e.toString());
    }
  }

  //register with email and password
  Future registerWithEmailAndPassword(String email, String password) async{
    try{
      UserCredential userCredential = await _auth.createUserWithEmailAndPassword(email: email, password: password);
      User? user = userCredential.user;
      return _userFromFirebase(user);
    }catch(e){
      print(e.toString());
    }
  }

  // Google Sign-In
  Future<void> signInWithGoogle(BuildContext context) async {
    try {
      final GoogleSignInAccount? googleSignInAccount = await _googleSignIn.signIn();
      final GoogleSignInAuthentication googleSignInAuthentication =
      await googleSignInAccount!.authentication;

      final AuthCredential credential = GoogleAuthProvider.credential(
        accessToken: googleSignInAuthentication.accessToken,
        idToken: googleSignInAuthentication.idToken,
      );

      UserCredential userCredential = await _auth.signInWithCredential(credential);
      User? user = userCredential.user;

      // Check if the user is already registered in your system
      DocumentSnapshot<Map<String, dynamic>> userData =
      await firestore.collection(userCollection).doc(user!.uid).get();

      if (!userData.exists) {
        // If the user is not registered, store their data
        storeUserData(user.displayName, '', user.email, user.photoURL);
      }
      Navigator.pushNamedAndRemoveUntil(context, '../views/home/home_page', (route) => false);
    } catch (error) {
      print(error);
    }
  }
  void navigateToSignUp(BuildContext context) {
    Navigator.pushNamedAndRemoveUntil(
      context,
      '/login_page',  // Replace with the route name of your sign-up page
          (route) => false,  // This removes all the previous routes from the stack
    );
  }


  //logout
  Future<void> logoutFunct(BuildContext context) async{
    try{
      await _auth.signOut();
    }catch(e){
      print(e.toString());
    }
    Navigator.push(context, MaterialPageRoute(builder: (context)=> SignupPage()));
  }

  storeUserData(name,password,email, imgUrl) async{

    DocumentReference storeUser = await firestore.collection(userCollection).doc(currentUser!.uid);
    storeUser.set({
      "id": currentUser!.uid,
      "email" : email,
      "password" : password,
      "name": name,
      "progileImg": imgUrl,
    });
  }

  userDataFetched(name, email) async{
    QuerySnapshot userFetchedData = await firestore.collection(userCollection).get();
    QueryDocumentSnapshot documentSnapshotName = userFetchedData.docs[0];
    QueryDocumentSnapshot documentSnapshotEmail = userFetchedData.docs[email];
  }
// google registration
  User? currentUser = auth.currentUser;
}

addMenuItem(dishName, dishPrice, dishImage, preparationTime, dishDesc, dishCategory) async {
  CollectionReference<Map<String,dynamic>> itemsCollection = await firestore.collection(canteenMenuItem);
  Map<String, dynamic> data={
    "i_name": dishName,
    "i_price": dishPrice,
    "i_prep_time": preparationTime,
    "i_desc": dishDesc,
    "i_category": dishCategory,
  };
  itemsCollection.add(data);

}



