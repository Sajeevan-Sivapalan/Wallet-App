package com.example.madproject.models

class User {

    private var userName:String = ""
    private var password:String = ""
    private var name:String = ""

    fun setUserName(userNa:String) {
        userName = userNa
    }

    fun setName(Na:String) {
        name = Na
    }

    fun setPassword(passwd:String) {
        password = passwd
    }

    fun getUserName():String {
        return userName
    }

    fun getPassword():String {
        return password
    }

    fun getName():String {
        return name
    }
}