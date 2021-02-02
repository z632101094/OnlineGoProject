import 'package:flutter/material.dart';
import 'package:online_go_app/api/rest_api.dart';
import 'package:online_go_app/widget/room_list.dart';


class HallPage extends StatefulWidget {
  @override
  _HallPageState createState() => _HallPageState();
}

class _HallPageState extends State<HallPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Flutter REST API'),
      ),
      body: FutureBuilder(
        future: ApiService.getRooms(),
        builder: (context, snapshot) {
          final rooms = snapshot.data;
          if (snapshot.connectionState == ConnectionState.done) {
            return ListView.separated(
              separatorBuilder: (context, index) {
                return Divider(
                  height: 2,
                  color: Colors.black,
                );
              },
              itemBuilder: (context, index) {
                final room = rooms[index];
                return RoomList(
                  roomId: room["roomId"],
                  roomName : room["roomName"],
                  players : room["players"],
                  start : room["start"],
                );
                //return ListTile(
                //  title: Text(user["username"]),
                //  subtitle: Text('Age: ${user["name"]}'),
                //);
              },
              itemCount: rooms.length ?? 0,

            );
          }
          return Center(
            child: CircularProgressIndicator(),
          );
        },
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
        },
        tooltip: 'Increment',
        child: Icon(Icons.add),
      ),
    );
  }
}
