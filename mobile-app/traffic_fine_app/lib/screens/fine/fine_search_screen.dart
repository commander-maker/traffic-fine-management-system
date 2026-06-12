import 'package:flutter/material.dart';

class FineSearchScreen extends StatelessWidget {
  const FineSearchScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Search Fine')),
      body: Center(child: Text('Enter reference')),
    );
  }
}
