import 'package:colour/colour.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:glassmorphism/glassmorphism.dart';
import 'package:sankalp_help/consts/widgets.dart';
import 'package:sankalp_help/services/auth.dart';
import 'package:sankalp_help/themes.dart';
import 'package:sankalp_help/views/home/ngo_dashboard.dart';
import 'package:sankalp_help/views/pages/index.dart';

late TabController _tabController;

void _tabListener(){
  int currentIndex = _tabController.index;
}

const List<Tab> myTabs = <Tab>[
  Tab(child: Text('NGO')),
  Tab(child: Text('Psychologist')),
  Tab(child: Text('Others'))
];


class HomePage extends StatefulWidget {
  const HomePage({Key? key}): super(key: key);

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> with SingleTickerProviderStateMixin {

  @override
  void initState() {
    super.initState();
    _tabController = TabController(vsync: this, length: myTabs.length);
    _tabController.addListener(_tabListener);
  }

  @override
  Widget build(BuildContext context) {
    int selectedValue = 0;
    return Scaffold(
      backgroundColor: AppColors.backgroundColor,
      resizeToAvoidBottomInset: true,
      appBar: AppBar(
        bottom: TabBar(
          controller: _tabController,
          tabs: myTabs,
        ),
      ),
     body: SafeArea(
       child: TabBarView(
         controller: _tabController,
         children: const [
           NgoLogin(),
           PsyLogin(),
           OtherLogin()
         ],
       ),
     ),
    );
  }
}

class NgoLogin extends StatelessWidget {
  const NgoLogin({super.key});

  @override
  Widget build(BuildContext context) {
    TextEditingController nameController = TextEditingController();
    TextEditingController emailController = TextEditingController();
    TextEditingController regIdController = TextEditingController();
    TextEditingController contactController = TextEditingController();
    TextEditingController addressController = TextEditingController();
    return Scaffold(
      backgroundColor: AppColors.backgroundColor,
      body: Center(
        child: SingleChildScrollView(
          child: AnimatedContainer(
            duration: Duration(milliseconds: 30),
            margin: EdgeInsets.only(
                bottom: MediaQuery.of(context).viewInsets.bottom
            ),
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
                    Colors.white.withOpacity(0.35),
                    Colors.white.withOpacity(0.35),
                  ],
                  stops: const [
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
              child: Padding(
                padding: const EdgeInsets.all(2.0),
                child: Column(
                  children: <Widget>[
                    Padding(
                        padding: const EdgeInsets.symmetric(vertical: 6,horizontal: 12),
                      child: entryField("NGO Name", nameController, IconButton(onPressed: (){}, icon: Image.asset('assets/ngoIcon.png'))),
                    ),
                    Padding(
                      padding: const EdgeInsets.symmetric(vertical: 6,horizontal: 12),
                      child: entryField("Email", emailController, IconButton(onPressed: (){}, icon: const Icon(Icons.email_outlined,color: Colors.red,))),
                    ),
                    Padding(
                      padding: const EdgeInsets.symmetric(vertical: 6,horizontal: 12),
                      child: entryField("Registration Id", regIdController, IconButton(onPressed: (){}, icon: const Icon(Icons.app_registration,color: Colors.cyan,))),
                    ),
                    Padding(
                      padding: const EdgeInsets.symmetric(vertical: 6,horizontal: 12),
                      child: entryField("Contact", contactController, IconButton(onPressed: (){}, icon: const Icon(CupertinoIcons.phone,color: Colors.black,))),
                    ),
                    Padding(
                      padding: const EdgeInsets.symmetric(vertical: 6,horizontal: 12),
                      child: entryField("Address", addressController, IconButton(onPressed: (){}, icon: const Icon(CupertinoIcons.home,color: Colors.purple,))),
                    ),
                    Center(child: ElevatedButton(
                      onPressed: (){
                        int parsedContact = int.parse(contactController.text);
                        try{
                          addNgoData(nameController.text, emailController.text, regIdController.text, parsedContact, addressController.text);
                        }
                        catch(e){
                          print(e);
                        }
                        Navigator.push(context, MaterialPageRoute(builder: (context)=>NGODashboard()));
                      }, child: const Text("Submit"),
                    ),)
                  ],
                ),
              ),
            ),
          ),
        )
      ),

    );
  }
}

class PsyLogin extends StatelessWidget {
  const PsyLogin({super.key});

  @override
  Widget build(BuildContext context) {
    TextEditingController nameController = TextEditingController();
    TextEditingController emailController = TextEditingController();
    TextEditingController regIdController = TextEditingController();
    TextEditingController contactController = TextEditingController();
    TextEditingController addressController = TextEditingController();
    return Scaffold(
      backgroundColor: AppColors.backgroundColor,
      body: Center(
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
                  Colors.white.withOpacity(0.35),
                  Colors.white.withOpacity(0.35),
                ],
                stops: const [
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
              children: <Widget>[
                Padding(
                  padding: const EdgeInsets.symmetric(vertical: 6,horizontal: 12),
                  child: entryField("NGO Name", nameController, IconButton(onPressed: (){}, icon: Image.asset('assets/ngoIcon.png'))),
                ),
                Padding(
                  padding: const EdgeInsets.symmetric(vertical: 6,horizontal: 12),
                  child: entryField("Email", emailController, IconButton(onPressed: (){}, icon: const Icon(Icons.email_outlined,color: Colors.red,))),
                ),
                Padding(
                  padding: const EdgeInsets.symmetric(vertical: 6,horizontal: 12),
                  child: entryField("Registration Id", regIdController, IconButton(onPressed: (){}, icon: const Icon(Icons.app_registration,color: Colors.cyan,))),
                ),
                Padding(
                  padding: const EdgeInsets.symmetric(vertical: 6,horizontal: 12),
                  child: entryField("Contact", contactController, IconButton(onPressed: (){}, icon: const Icon(CupertinoIcons.phone,color: Colors.black,))),
                ),
                Padding(
                  padding: const EdgeInsets.symmetric(vertical: 6,horizontal: 12),
                  child: entryField("Address", addressController, IconButton(onPressed: (){}, icon: const Icon(CupertinoIcons.home,color: Colors.purple,))),
                ),
                Center(child: ElevatedButton(
                  onPressed: (){
                    int parsedContact = int.parse(contactController.text);
                    try{
                      addNgoData(nameController.text, emailController.text, regIdController.text, parsedContact, addressController.text);
                    }
                    catch(e){
                      print(e);
                    }
                    Navigator.push(context, MaterialPageRoute(builder: (context)=>const NGODashboard()));
                  }, child: const Text("Submit"),
                ),)
              ],
            ),
          )
      ),
    );
  }
}

class OtherLogin extends StatelessWidget {
  const OtherLogin({super.key});

  @override
  Widget build(BuildContext context) {
    TextEditingController nameController = TextEditingController();
    TextEditingController emailController = TextEditingController();
    TextEditingController regIdController = TextEditingController();
    TextEditingController contactController = TextEditingController();
    TextEditingController addressController = TextEditingController();
    return Scaffold(
      backgroundColor: AppColors.backgroundColor,
      body: Center(
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
                  Colors.white.withOpacity(0.35),
                  Colors.white.withOpacity(0.35),
                ],
                stops: const [
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
              children: <Widget>[
                Padding(
                  padding: const EdgeInsets.symmetric(vertical: 6,horizontal: 12),
                  child: entryField("NGO Name", nameController, IconButton(onPressed: (){}, icon: Image.asset('assets/ngoIcon.png'))),
                ),
                Padding(
                  padding: const EdgeInsets.symmetric(vertical: 6,horizontal: 12),
                  child: entryField("Email", emailController, IconButton(onPressed: (){}, icon: const Icon(Icons.email_outlined,color: Colors.red,))),
                ),
                Padding(
                  padding: const EdgeInsets.symmetric(vertical: 6,horizontal: 12),
                  child: entryField("Registration Id", regIdController, IconButton(onPressed: (){}, icon: const Icon(Icons.app_registration,color: Colors.cyan,))),
                ),
                Padding(
                  padding: const EdgeInsets.symmetric(vertical: 6,horizontal: 12),
                  child: entryField("Contact", contactController, IconButton(onPressed: (){}, icon: const Icon(CupertinoIcons.phone,color: Colors.black,))),
                ),
                Padding(
                  padding: const EdgeInsets.symmetric(vertical: 6,horizontal: 12),
                  child: entryField("Address", addressController, IconButton(onPressed: (){}, icon: const Icon(CupertinoIcons.home,color: Colors.purple,))),
                ),
                Center(child: ElevatedButton(
                  onPressed: (){
                    int parsedContact = int.parse(contactController.text);
                    try{
                      addNgoData(nameController.text, emailController.text, regIdController.text, parsedContact, addressController.text);
                    }
                    catch(e){
                      print(e);
                    }
                    Navigator.push(context, MaterialPageRoute(builder: (context)=>const NGODashboard()));
                  }, child: const Text("Submit"),
                ),)
              ],
            ),
          )
      ),

    );
  }
}
