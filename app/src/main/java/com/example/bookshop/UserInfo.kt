package com.example.bookshop

class UserInfo {
    var fullName:String=""
    var email:String=""
    var age:String=""
    var mnumber:String=""
    var password:String=""


    constructor(
        fullName: String,
        email: String,
        age: String,
        mnumber: String,
        password: String

    ) {
        this.fullName = fullName
        this.email = email
        this.age = age
        this.mnumber = mnumber
        this.password = password

    }
}