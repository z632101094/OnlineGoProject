import 'package:flutter/material.dart';
import 'package:online_go_app/page/game_page.dart';
import 'package:online_go_app/splash_page.dart';
import 'package:online_go_app/test/http_test.dart';
import 'package:online_go_app/page/hall_page.dart';
import 'package:online_go_app/test/demo_page.dart';
/*void main() {
  runApp(MyApp());
}*/

void main() => runApp(new MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      theme: new ThemeData(primaryColor: Colors.black),
      home: new HallPage(),
    );
  }
}

