import 'dart:convert';

import 'package:home_ui/models/medicine_model.dart';
import 'package:home_ui/service/service_settings.dart';
import 'package:home_ui/service/storage_service.dart';
import 'package:http/http.dart' as http;


class MedicineService {
  static final _uriEndpoint = Uri.parse('http://${ServiceSettings.HOST}:${ServiceSettings.PORT}/${ServiceSettings.MEDICINE_PATH}');

  static Future<List<MedicineModel>?> getMedicineList() async {
    final accessToken = await StorageService.retrieveToken(tokenName: 'access-token');
    final response = await http.get(
      _uriEndpoint,
      headers: {
        'Content-Type' : 'application/json',
        'Accept' : 'application/json',
        'Authorization' : 'Bearer $accessToken',
      },
    );

    if (response.statusCode != 200) {
      return null;
    }

    final jsonDecoded = await jsonDecode(response.body);
    return (jsonDecoded['medicineList'] as List)
        .map((model) => MedicineModel.fromJson(model))
        .toList();
  }

  static Future<dynamic> postMedicine(MedicineModel model) async {
    final accessToken = await StorageService.retrieveToken(tokenName: 'access-token');
    final response = await http.post(
        _uriEndpoint,
      headers: {
        'Content-Type' : 'application/json',
        'Accept' : 'application/json',
        'Authorization' : 'Bearer $accessToken',
      },
      body: model.toJson()
    );

    if (response.statusCode != 200) {
      return null;
    }
    final jsonDecoded = await jsonDecode(response.body);
    ServiceSettings.logger.d("Post decoded response body: $jsonDecoded");
    model.id = jsonDecoded['id'];
    return model;
  }
}