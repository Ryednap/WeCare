// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'medicine_model.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

MedicineModel _$MedicineModelFromJson(Map<String, dynamic> json) =>
    MedicineModel(
      id: json['id'] as int?,
      name: json['name'] as String?,
      description: json['description'] as String?,
      dosage: (json['dosage'] as num?)?.toDouble(),
      type: json['type'] as String?,
      timeList: (json['timeList'] as List<dynamic>?)
          ?.map((e) => e as String)
          .toList(),
      dateList: (json['dateList'] as List<dynamic>?)
          ?.map((e) => e as String)
          .toList(),
    );

Map<String, dynamic> _$MedicineModelToJson(MedicineModel instance) =>
    <String, dynamic>{
      'id': instance.id,
      'name': instance.name,
      'description': instance.description,
      'dosage': instance.dosage,
      'type': instance.type,
      'timeList': instance.timeList,
      'dateList': instance.dateList,
    };
