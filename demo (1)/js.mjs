const express = require('express');
const router = express.Router();
const User = require('../model/users');
const mongoose = require('mongoose');
const db = "mongodb+srv://boab:<1234>@cluster0.d3aixga.mongodb.net/?retryWrites=true&w=majority";
mongoose.connect(db, config)
.then(connection_obj => {
    console.log('Connected to Mongodb' + connection_obj);
}).catch(err => {
    console.log('Error in connect the database' + err);
});
User = mongoose.Schema(
    name, {
        type: varchar,
        required: true
      }
  )
db.on('error', console.error.bind(console, 'Ошибка подключения:'));
db.once('open', () => {
  console.log('Успешное подключение к базе данных!');
});

// Экспортируем mongoose
module.exports = mongoose;


document.getElementById('registerForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    console.log('Регистрация:');
    console.log('Имя пользователя:', username);
    console.log('Пароль:', password);
    document.getElementById('output').innerHTML += `<p>Регистрация:<br>Имя пользователя: ${username}<br>Пароль: ${password}</p>`;
  });
  
  document.getElementById('login').addEventListener('submit', function(event) {
    event.preventDefault();
    const loginUsername = document.getElementById('loginUsername').value;
    const loginPassword = document.getElementById('loginPassword').value;
    console.log('Вход:');
    console.log('Имя пользователя:', loginUsername);
    console.log('Пароль:', loginPassword);
    document.getElementById('output').innerHTML += `<p>Вход:<br>Имя пользователя: ${loginUsername}<br>Пароль: ${loginPassword}</p>`;
  });