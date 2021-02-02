import 'dart:convert';
import 'dart:io';

import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;

class HttpTest extends StatefulWidget {
  HttpTest({Key key}) : super(key: key);
  @override
  _HttpTestState createState() => new _HttpTestState();
}

class _HttpTestState extends State<HttpTest> {
  var _data;
  _getIPAddress() async {
    print("CAAAA\n");
    var url = new Uri.http(
        'localhost:8080', '/user/greeting', {'name': 'caocc'});
    var client = http.Client();
    http.Response response = await client.get(url);
    if (response.statusCode == 200) {
      Map<String, dynamic> user = jsonDecode(response.body);
      _data = user['data'];
      print(user['data']);
    }
  }

  @override
  Widget build(BuildContext context) {
    var spacer = new SizedBox(height: 32.0);

    return new Scaffold(
      body: new Center(
        child: new Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            new Text('Your current IP address is:'),
            new Text('$_data'),
            spacer,
            new RaisedButton(
              onPressed: _getIPAddress,
              child: new Text('Get IP address'),
            ),
          ],
        ),
      ),
    );
  }
}