
import 'package:flutter/cupertino.dart';
import 'package:flutter/rendering.dart';
import 'package:flutter_neumorphic/flutter_neumorphic.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:home_ui/screens/home/constants.dart';
import 'package:sizer/sizer.dart';

class MedicineCard {
  bool editMode;
  String name;
  String upcomingTime;
  String description;


  MedicineCard({required this.editMode, required this.name,
                required this.upcomingTime, required this.description
    });

  Widget buildMedicineCard() {
    return Neumorphic(
        style: NeumorphicStyle(
          boxShape: NeumorphicBoxShape.roundRect(BorderRadius.circular(2.h)),
          color: const Color(0xB0DCDDDC),
          depth: 1.8.h,
        ),
        child: Container(
            height: 19.h,
            width: 81.w,
            decoration: BoxDecoration(
              borderRadius: BorderRadius.circular(2.h),
            ),
            child: Padding(
              padding: EdgeInsets.only(left: 4.w,top: 1.h, right: 2.w),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Row(
                    children: <Widget>[
                      NeumorphicIcon(
                        FontAwesomeIcons.pills,
                        size: 3.h,
                        style: const NeumorphicStyle(
                            color: Colors.amber
                        ),
                      ),
                      const Spacer(),

                      editMode ? NeumorphicButton(
                        onPressed: (){},
                        drawSurfaceAboveChild: true,
                        style: const NeumorphicStyle(
                          boxShape: NeumorphicBoxShape.circle(),
                          shape: NeumorphicShape.flat,

                        ),
                        child: FaIcon(
                          FontAwesomeIcons.edit,
                          size: 2.h,
                          color: Colors.blue,
                        ),
                      ) : const SizedBox(width: 0),
                      NeumorphicButton(
                        onPressed: (){},
                        drawSurfaceAboveChild: true,
                        style: const NeumorphicStyle(
                          boxShape: NeumorphicBoxShape.circle(),
                          shape: NeumorphicShape.flat,

                        ),
                        child: FaIcon(
                          editMode ? FontAwesomeIcons.circleMinus : FontAwesomeIcons.check,
                          size: 2.h,
                          color: editMode ? Colors.deepPurple : Colors.green.shade400,
                        ),
                      ),
                    ],
                  ),
                  Padding(
                    padding: EdgeInsets.only(left: 18.w),
                    child: Text(
                      name,
                      style: GoogleFonts.heebo(
                        fontSize: 12.sp,
                        fontStyle: FontStyle.italic,
                        fontWeight: FontWeight.w700,
                        color: const Color(0xFA0E3371),
                        shadows: [cTextShadow(shadowColor: Colors.grey.shade400)]
                      ),
                    )
                  ),
                  Padding(
                    padding: EdgeInsets.only(left: 25.w, top : 1.h),
                    child: Row(
                      children: <Widget>[
                        NeumorphicIcon(
                          FontAwesomeIcons.clockRotateLeft,
                          size: 2.h,
                          style: const NeumorphicStyle(
                            boxShape: NeumorphicBoxShape.circle(),
                            color: Colors.purple,
                          )
                        ),
                        SizedBox(width: 1.5.w),
                        Text(
                          upcomingTime,
                          style: GoogleFonts.heebo(
                            fontSize: 10.sp,
                            fontWeight: FontWeight.w700,
                            color: const Color(0xFA5C0E71),
                            shadows: [cTextShadow(shadowColor: Colors.grey.shade400)]
                          )
                        ),
                      ],
                    )
                  ),
                  Padding(
                    padding: EdgeInsets.only(left: 2.w, top: 1.h),
                    child: Text(
                      description,
                      style: GoogleFonts.lobster(
                        fontSize: 9.5.sp,
                        fontWeight: FontWeight.w400,
                        color: const Color(0xFA71230E),
                        letterSpacing: 0.5.sp,
                        shadows: [cTextShadow(shadowColor: Colors.grey.shade400)]
                      ),
                    ),
                  ),
                ],
              ),
            )
        )
    );
  }
}
