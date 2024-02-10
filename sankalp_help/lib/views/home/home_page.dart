import 'package:colour/colour.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:glassmorphism/glassmorphism.dart';
import 'package:sankalp_help/consts/widgets.dart';
import 'package:sankalp_help/themes.dart';

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
      resizeToAvoidBottomInset: false,
      appBar: AppBar(
        bottom: TabBar(
          controller: _tabController,
          tabs: myTabs,
        ),
      ),
     body: SafeArea(
       child: TabBarView(
         controller: _tabController,
         children: [
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
            children: <Widget>[
              Padding(
                  padding: const EdgeInsets.symmetric(vertical: 6,horizontal: 12),
                child: entryField("Name", nameController, IconButton(onPressed: (){}, icon: Icon(Icons.supervised_user_circle_rounded))),
              )
            ],
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
    return Scaffold(
      backgroundColor: Colors.white70,
      body: Text("PsyLogin"),
    );
  }
}

class OtherLogin extends StatelessWidget {
  const OtherLogin({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.green,
      body: Text("OtherLogin completed"),
    );
  }
}
