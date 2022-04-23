import 'package:json_annotation/json_annotation.dart';

part 'medicine_model.g.dart';

@JsonSerializable()
class MedicineModel {
  int? id;
  final String? name;
  final String? description;
  final double? dosage;
  final String? type;
  final List<String>? timeList;
  final List<String>? dateList;

  MedicineModel({
    required this.id,
    required this.name,
    required this.description,
    required this.dosage,
    required this.type,
    required this.timeList,
    required this.dateList
  });

  factory MedicineModel.fromJson(Map<String, dynamic> json) => _$MedicineModelFromJson(json);

  Map<String, dynamic> toJson() => _$MedicineModelToJson(this);



  @override
  String toString() {
    return 'Medicine{id: $id, name: $name, description: $description, dosage: $dosage, type: $type, timeList: $timeList, dateList: $dateList}';
  }
}