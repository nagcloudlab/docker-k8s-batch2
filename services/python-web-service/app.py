import socket
import mysql.connector
from flask import Flask, jsonify

app = Flask(__name__)

@app.route('/api/info', methods=['GET'])
def get_info():
    """Returns Pod hostname and IP"""
    hostname = socket.gethostname()
    ip = socket.gethostbyname(hostname)
    return jsonify({"hostname": hostname, "ip": ip}), 200

if __name__ == '__main__':
    app.run(host="0.0.0.0", port=8080, debug=True)
