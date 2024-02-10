import 'package:colour/colour.dart';
import 'package:flutter/material.dart';

class TabPair {
  final Tab tab;
  final Widget view;
  TabPair({required this.tab, required this.view});
}

List<TabPair> TabPairs = [
  TabPair(
    tab: const Tab(
      text: 'Intro',
    ),
    view: const Center(
      child: Text(
        'Intro here',
        style: TextStyle(
          fontSize: 25,
          fontWeight: FontWeight.w600,
        ),
      ),
    ),
  ),
  TabPair(
    tab: const Tab(
      text: 'Ingredients',
    ),
    view: const Center(
      // replace with your own widget here
      child: Text(
        'Ingredients here',
        style: TextStyle(
          fontSize: 25,
          fontWeight: FontWeight.w600,
        ),
      ),
    ),
  ),
  TabPair(
    tab: const Tab(
      text: 'Steps',
    ),
    view: const Center(
      child: Text(
        'Steps here',
        style: TextStyle(
          fontSize: 25,
          fontWeight: FontWeight.w600,
        ),
      ),
    ),
  )
];
class TabBarAndTabViews extends StatefulWidget {
  @override
  _TabBarAndTabViewsState createState() => _TabBarAndTabViewsState();
}

class _TabBarAndTabViewsState extends State<TabBarAndTabViews>
    with SingleTickerProviderStateMixin {
  late TabController _tabController;

  @override
  void initState() {
    _tabController = TabController(length: TabPairs.length, vsync: this);
    super.initState();
  }

  @override
  void dispose() {
    super.dispose();
    _tabController.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(8.0),
      child: Column(
        children: [
          // give the tab bar a height [can change height to preferred height]
          Container(
            height: 45,
            decoration: BoxDecoration(
              color: Colors.white,
              borderRadius: BorderRadius.circular(
                25.0,
              ),
            ),
            child: Padding(
              padding: const EdgeInsets.all(6),
              child: TabBar(
                  controller: _tabController,
                  // give the indicator a decoration (color and border radius)
                  indicator: BoxDecoration(
                    borderRadius: BorderRadius.circular(
                      25.0,
                    ),
                    color: const Color(0xFFFF8527),
                  ),
                  labelColor: Colors.white,
                  unselectedLabelColor: Colors.black,
                  tabs: TabPairs.map((tabPair) => tabPair.tab).toList()),
            ),
          ),
          Expanded(
            child: TabBarView(
                controller: _tabController,
                children: TabPairs.map((tabPair) => tabPair.view).toList()),
          ),
        ],
      ),
    );
  }
}

Widget entryField(String title,
    TextEditingController controller, IconButton? icon) {
  return TextField(
    cursorColor: Colors.black,
    controller: controller,
    decoration: InputDecoration(
      contentPadding: EdgeInsets.only(top: 10, bottom: 10, left: 7),
      focusColor: Colors.black,
      border: OutlineInputBorder(
          borderSide: BorderSide(color: Colors.black,width: 2)
      ),
      focusedBorder: OutlineInputBorder(
          borderSide: BorderSide(color: Colors.black, width: 1.5)
      ),
      labelText: title,
      labelStyle: TextStyle(
          color: Colors.black
      ),
      suffixIcon: icon,
      // labelStyle: ,
    ),
  );
}

// Widget formField(String name,TextEditingController controller, Icon icon, String title){
//   return FormBuilderTextField(
//     name: name,
//     cursorColor: Colors.black,
//     controller: controller,
//     decoration: InputDecoration(
//       // fillColor: Colors.black,
//       contentPadding: EdgeInsets.only(top: 10, bottom: 10, left: 7),
//       focusColor: Colour('000000'),
//       border: OutlineInputBorder(
//           borderSide: BorderSide(color: Colors.black)
//       ),
//       focusedBorder: OutlineInputBorder(
//           borderSide: BorderSide(color: Colors.black, width: 1.5)
//       ),
//       labelText: title,
//       labelStyle: TextStyle(
//           color: Colors.black
//       ),
//       suffixIcon: icon,
//       // labelStyle: ,
//     ),
//   );
// }