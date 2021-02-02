import 'package:flutter/material.dart';

class Room {
  final id;
  String text;
  Color bg;
  bool enabled;

  Room(
      {this.id, this.text = "", this.bg = Colors.grey, this.enabled = true});
}
