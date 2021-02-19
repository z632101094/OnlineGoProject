import 'package:flutter/material.dart';
import 'package:online_go_app/page/game_page.dart';
import 'package:online_go_app/splash_page.dart';
import 'package:online_go_app/test/http_test.dart';
import 'package:online_go_app/page/hall_page.dart';
import 'package:online_go_app/test/demo_page.dart';
import 'package:online_go_app/ui/home_page.dart';
import 'package:online_go_app/ui/user_provider.dart';
/*void main() {
  runApp(MyApp());
}*/

void main() => runApp(new MyApp());

class MyApp extends StatelessWidget {
  String url;

  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      title: 'TheGorgeousLogin',
      theme: new ThemeData(
        primarySwatch: Colors.blue,
      ),
      home:
      /**
       * 将用户数据共享给子控件，任何地方的子控件都可以获取到父控件所保存的用户信息
       * 根据有没有用户信息，进入不同的页面
       */
//      new UserContainer(user:new User("冬瓜","123456"),child: new HomePage(),),
      new UserContainer(user: null, child: new HomePage(),
      ),
    );
  }
}

