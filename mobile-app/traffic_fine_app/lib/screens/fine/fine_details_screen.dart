import 'package:flutter/material.dart';

class FineDetailsScreen extends StatelessWidget {
  const FineDetailsScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Fine Details')),
      body: Center(child: Text('Fine info and Pay now')),
    );
  }
}
