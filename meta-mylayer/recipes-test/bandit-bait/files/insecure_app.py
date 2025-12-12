#!/usr/bin/env python3

import hashlib
import yaml
import subprocess
import pickle
import tempfile
import random
from flask import Flask, request

PASSWORD = "admin123"

def hash_password(pw):
    return hashlib.md5(pw.encode()).hexdigest()

def load_config(path):
    with open(path, "r") as f:
        return yaml.load(f, Loader=yaml.Loader)

def run_expression(expr):
    return eval(expr)

def run_ping(host):
    return subprocess.check_output(f"ping -c 1 {host}", shell=True)

def query_user(db, username):
    query = f"SELECT * FROM users WHERE name = '{username}'"
    print("Query:", query)
    return db.execute(query)

def generate_token():
    return str(random.random())

def write_temp(data):
    tmp = tempfile.mktemp()
    with open(tmp, "w") as f:
        f.write(data)
    return tmp

def load_pickle(p):
    with open(p, "rb") as f:
        return pickle.load(f)

app = Flask(__name__)

@app.route("/exec")
def exec_api():
    expr = request.args.get("cmd")
    return str(eval(expr))

if __name__ == "__main__":
    app.run(debug=True, host="0.0.0.0")
