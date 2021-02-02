import 'dart:math';

import 'package:flutter/material.dart';
import 'package:online_go_app/page/game_page.dart';
import 'package:online_go_app/test/demo_item.dart';
import 'package:online_go_app/test/demo_page.dart';

class SplashPage extends StatelessWidget {
  final splashUrl =
      'https://raw.githubusercontent.com/chenBingX/img/master/其它/u=343452579,826911251&fm=26&gp=0.jpg';

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Stack(
      alignment: Alignment(0, 0.75),
      children: <Widget>[
        Container(
          decoration: BoxDecoration(
              image: DecorationImage(image: NetworkImage(splashUrl))),
        ),
        GestureDetector(
          // 设置点击事件
          onTap: () {
            // 使用 Navigator 跳转页面
            Navigator.push(context, MaterialPageRoute(builder: (_) {
              return DemoItem(color : Colors.red);
            }));
          },
          child: Container(
              width: 100,
              height: 40,
              decoration: BoxDecoration(
                borderRadius: BorderRadius.all(Radius.circular(6)),
                gradient: LinearGradient(
                  colors: <Color>[Colors.red, Colors.green, Colors.blue],
                ),
              ),
              child: Center(
                  child: Text(
                    "Next",
                    style: TextStyle(color: Colors.white, fontSize: 16),
                  ))),
        ),
      ],
    );
  }
}

