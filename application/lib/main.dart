import 'package:flutter/material.dart';
import 'package:home_ui/screens/auth/login.dart';
import 'package:home_ui/screens/home/home_screen.dart';
import 'package:sizer/sizer.dart';

void main () {
  runApp(Sizer(builder: ((context, orientation, deviceType) {
    return MaterialApp(
      title: 'WeCare',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        scaffoldBackgroundColor: const Color(0xFFecf1f3),
      ),
      initialRoute: '/',
      routes: {
        '/': (context)  => const LoginPage(),
        '/home': (context) => const HomeScreen(),
      },
    );
  })));
}