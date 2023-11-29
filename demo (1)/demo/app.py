from flask import Flask, render_template
from py4j.java_gateway import JavaGateway
from flask import Flask, render_template, request, redirect, url_for
from pymongo import MongoClient

app = Flask(__name__)

client = MongoClient("mongodb+srv://boab:<1234>@cluster0.d3aixga.mongodb.net/?retryWrites=true&w=majority")

db = client['user_database']

users_collection = db['User']

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/login', methods=['POST'])
def login():
    username = request.form['username']
    password = request.form['password']

    user = users_collection.find_one({'username': username, 'password': password})

    if user:
        return f'Welcome, {username}!'
    else:
        return 'Invalid username or password. Please try again.'

if __name__ == '__main__':
    app.run(debug=True)
