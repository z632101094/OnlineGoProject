import 'package:flutter/material.dart';
import 'package:online_go_app/page/room_page.dart';

class RoomList extends StatefulWidget {
  int roomId;
  String roomName;
  int players;
  bool start;
  RoomList({
    Key key,
    this.roomId,
    this.roomName,
    this.players,
    this.start,
  }) : super(key: key);
  @override
  _RoomListState createState() => _RoomListState();
}

class _RoomListState extends State<RoomList> {



  ///返回一个居中带图标和文本的Item
  _getBottomItem(IconData icon, String text) {
    ///充满 Row 横向的布局
    return new Expanded(
      flex: 1,
      ///居中显示
      child: new Center(
        ///横向布局
        child: new Row(
          ///主轴居中,即是横向居中
          mainAxisAlignment: MainAxisAlignment.center,
          ///大小按照最大充满
          mainAxisSize : MainAxisSize.max,
          ///竖向也居中
          crossAxisAlignment : CrossAxisAlignment.center,
          children: <Widget>[
            ///一个图标，大小16.0，灰色
            new Icon(
              icon,
              size: 16.0,
              color: Colors.red,
            ),
            ///间隔
            new Padding(padding: new EdgeInsets.only(left:5.0)),
            ///显示文本
            new Text(
              text,
              //设置字体样式：颜色灰色，字体大小14.0
              style: new TextStyle(color: Colors.grey, fontSize: 14.0),
              //超过的省略为...显示
              overflow: TextOverflow.ellipsis,
              //最长一行
              maxLines: 1,
            ),
          ],
        ),
      ),
    );
  }



  @override
  Widget build(BuildContext context) {
    return new Container(
      ///卡片包装
      child: new Card(
        ///增加点击效果
          child: new FlatButton(
              onPressed: (){
                Navigator.push(context, MaterialPageRoute(builder: (_) {
                  return RoomPage(color : Colors.red);
                }));
              },
              child: new Padding(
                padding: new EdgeInsets.only(left: 0.0, top: 10.0, right: 10.0, bottom: 10.0),
                child: new Column(
                  mainAxisSize: MainAxisSize.min,
                  children: <Widget>[
                    ///文本描述
                    new Container(
                        child: new Text(
                          widget.roomName,
                          style: TextStyle(
                            //color: Color(GSYColors.subTextColor),
                            fontSize: 14.0,
                          ),
                          ///最长三行，超过 ... 显示
                          maxLines: 3,
                          overflow: TextOverflow.ellipsis,
                        ),
                        margin: new EdgeInsets.only(top: 6.0, bottom: 2.0),
                        alignment: Alignment.topLeft),
                    new Padding(padding: EdgeInsets.all(10.0)),

                    ///三个平均分配的横向图标文字
                    new Row(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: <Widget>[
                        _getBottomItem(Icons.star, "Room Id: " + widget.roomId.toString()),
                        _getBottomItem(Icons.star, "Players: " + widget.players.toString() + "/2"),
                        _getBottomItem(Icons.star, "In game: " + widget.start.toString()),
                      ],
                    ),
                  ],
                ),
              ))),
    );
  }
}