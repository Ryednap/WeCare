import os
os.environ['TF_XLA_FLAGS'] = '--tf_xla_enable_xla_devices'
os.environ['CUDA_VISIBLE_DEVICES'] = '-1'
import tensorflow as tf
import pandas as pd
from flask import Flask, jsonify, request
app = Flask(__name__)
model = tf.keras.models.load_model("model_final.h5")

@app.route("/test", methods=["GET"])
def serveGet():
    return jsonify({
        "message" : "Hello World"
    })

@app.route("/", methods=["POST"])
def index():
  data = request.json
  df = pd.DataFrame(data, index=[0])
  prediction = model.predict(df)
  
  health = prediction[0]
  return jsonify({"health_status": str(health)})

if __name__=='__main__':
    print(model.layers)
    app.run(debug=True)