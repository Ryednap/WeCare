import 'dart:async';


import 'package:flutter/services.dart';
import 'package:flutter_neumorphic/flutter_neumorphic.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:home_ui/screens/home/constants.dart';
import 'package:home_ui/widgets/medicine_card.dart';
import 'package:home_ui/widgets/medicine_dialog.dart';
import 'package:home_ui/screens/home/top_cardView.dart';
import 'package:sizer/sizer.dart';
import 'package:intl/intl.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({Key? key}) : super(key: key);

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {

  late VoidCallback _medicineCardFunction;
  bool _editMode = false;
  final DateTime _selectedDate = DateTime.now();
  int medicineStatus = 0;


  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    SystemChrome.setEnabledSystemUIMode(SystemUiMode.manual, overlays: [
      SystemUiOverlay.bottom
    ]);
  }

  @override
  void dispose() {
    // TODO: implement dispose
    super.dispose();
    SystemChrome.setEnabledSystemUIMode(SystemUiMode.manual, overlays: SystemUiOverlay.values);
  }


  Widget _buildDateCalenderRow() {
    return Row(
      children: [
        NeumorphicIcon(
          FontAwesomeIcons.clock,
          size: 6.w,
          style:  NeumorphicStyle(
            depth: 4.h,
            intensity: 1,
            color: Colors.deepPurple,
          ),
        ),
        SizedBox(width: 4.w),
        StreamBuilder(
          stream: Stream.periodic(const Duration(seconds: 1)),
          builder: ((context, snapshot) {
            return Text(
                DateFormat("EEE d MMM, yyy\nkk:mm:ss").format(DateTime.now()),
                style: GoogleFonts.workSans(
                  fontSize: 3.5.w,
                  color: Colors.blue,
                  fontWeight: FontWeight.w700,
                  shadows: [
                    cTextShadow(shadowColor: Colors.grey.shade300),
                  ]
                )
            );
          }),
        ),
        SizedBox(width: 30.w),
        NeumorphicButton(
            onPressed: (){
              setState(() {
                showDatePicker(context: context, initialDate: _selectedDate, firstDate: DateTime(2015), lastDate: DateTime(2101));
              });
            },
            child: const FaIcon(FontAwesomeIcons.circleArrowDown, color: Colors.deepPurple),
            style: const NeumorphicStyle(
              boxShape: NeumorphicBoxShape.circle(),
            )
        )
      ],
    );
  }


  Widget _buildUpcomingMedicationRow() {
    return Row(
      children: <Widget>[
        Text(
            "Upcoming Medications",
            style: GoogleFonts.fredokaOne(
                fontSize: 5.3.w,
                color: Colors.pink,
                shadows: [
                  cTextShadow(shadowColor: Colors.grey.shade300),
                ]
            )
        ),
        SizedBox(width: 8.w),
        NeumorphicButton(
            onPressed: (){
              setState(() {
                _editMode ^= true;
              });
            },
            child: const FaIcon(FontAwesomeIcons.pencil, color: Colors.deepPurple),
            style: const NeumorphicStyle(
              boxShape: NeumorphicBoxShape.circle(),
            )
        )
      ],
    );
  }

  @override
  Widget build(BuildContext context) {

    return Scaffold(
      floatingActionButton: NeumorphicFloatingActionButton(
        onPressed: () async {
           await buildDialog(context);
        },
        style: NeumorphicStyle(
          boxShape: const NeumorphicBoxShape.circle(),
          intensity: 1,
          shape: NeumorphicShape.flat,
          depth: 10.h,
          shadowDarkColor: Colors.blueGrey.shade400,
        ),
        child: Center(child: FaIcon(FontAwesomeIcons.circlePlus, size: 5.h, color: Colors.redAccent)),
      ),
      body: Container(
        height: double.infinity,
        width: double.infinity,
        alignment: Alignment.topCenter,
        color: Theme.of(context).scaffoldBackgroundColor,
        child: Column(
          children: <Widget>[
            TopCardView.buildTopCard(context),
            SizedBox(height: 4.h),
            Expanded(
              child: SingleChildScrollView(
                scrollDirection: Axis.vertical,
                physics: const BouncingScrollPhysics(),
                child: Padding(
                  padding: EdgeInsets.only(left: 4.w),
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: <Widget>[
                      _buildDateCalenderRow(),
                      SizedBox(height: 2.5.h),
                      _buildUpcomingMedicationRow(),
                      SizedBox(height: 5.h),
                      MedicineCard(editMode: _editMode, name: "Fish Oil Omega-3", upcomingTime: "10::00 AM", description: "Take 1 spoon after meal. Drink Water after 1 hrs.").buildMedicineCard(),
                      SizedBox(height: 2.5.h),
                      MedicineCard(editMode: _editMode, name: "Fish Oil Omega-3", upcomingTime: "10::00 AM", description: "Take 1 spoon after meal. Drink Water after 1 hrs.").buildMedicineCard(),
                      SizedBox(height: 2.5.h),
                      MedicineCard(editMode: _editMode, name: "Fish Oil Omega-3", upcomingTime: "10::00 AM", description: "Take 1 spoon after meal. Drink Water after 1 hrs.").buildMedicineCard(),
                      SizedBox(height: 2.5.h),
                      MedicineCard(editMode: _editMode, name: "Fish Oil Omega-3", upcomingTime: "10::00 AM", description: "Take 1 spoon after meal. Drink Water after 1 hrs.").buildMedicineCard(),
                    ],
                  ),
                )
              ),
            ),
          ],
        )
      )
    );
  }
}
