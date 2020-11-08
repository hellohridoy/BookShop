package com.example.bookshop
class BookInfo {
    var bookName:String=""
    var bookPrice:String=""
    var publicationDate:String=""
    var bmobileNumber:String=""
    var email:String=""

    constructor(
        bookName: String,
        bookPrice: String,
        publicationDate: String,
        bmobileNumber: String,
        email: String
    ) {
        this.bookName = bookName
        this.bookPrice = bookPrice
        this.publicationDate = publicationDate
        this.bmobileNumber = bmobileNumber
        this.email = email
    }
}