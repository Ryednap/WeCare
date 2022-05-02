import 'package:day_night_time_picker/day_night_time_picker.dart';
import 'package:flutter_neumorphic/flutter_neumorphic.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:sizer/sizer.dart';

class MedicineTimeSlot extends StatefulWidget {
  const MedicineTimeSlot({Key? key}) : super(key: key);

  @override
  State<MedicineTimeSlot> createState() => _MedicineTimeSlotState();
}

class _MedicineTimeSlotState extends State<MedicineTimeSlot> {
  bool slotState = false;
  TimeOfDay _time = TimeOfDay.now().replacing(hour: 11, minute: 30);

  @override
  Widget build(BuildContext context) {
    return NeumorphicButton(
      onPressed: (){
        setState(() {
          Navigator.of(context).push(
            showPicker(
              value: _time,
              onChange: (TimeOfDay newTime) {
                _time = newTime;
              },
            )
          );
          slotState = !slotState;
        });
      },
      style: NeumorphicStyle(
        boxShape: NeumorphicBoxShape.roundRect(BorderRadius.circular(1.h)),
      ),
      child: slotState ? Text(_time.toString(), style: GoogleFonts.roboto(
          fontSize: 8.sp,
          fontWeight: FontWeight.w700,
          color: Colors.black54,
        ),
      ) : const FaIcon(FontAwesomeIcons.solidClock, color: Colors.deepPurple)
    );
  }
}
