package com.example.bookshop

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATABASE_NAME="mydb.db"
var DATABASE_VERSION:Int=10
val TABLE_NAME_REG="Registation"
val COL_FULLNAME="Full Name"
val COL_EMAIL="Email"
val COL_AGE="Age"
val COL_MOBILENUMBER="Number"
val COL_PASSWORD="Password"
val COL_CONFIRMPASSWORD="Confirm Password"

val TABLE_NAME_BOOKINFO="BookInfo"
val COL_BOOK_NAME="Book name"
val COL_BOOK_PRICE="Book price"
val COL_PUBLISH_YEAR="Publish year"
val COL_BUYER_NUMBER="Buyer number"
val COL_BUYER_EMAIL="Buyer Email"

val registationTable = "CREATE TABLE "+TABLE_NAME_REG+"( "+COL_FULLNAME+" VARCHAR(255), "+COL_EMAIL+" VARCHAR(255), "+COL_AGE+" VARCHAR(255), "+ COL_MOBILENUMBER+"(255), "+ COL_PASSWORD+"(255) ) "

val bookInformationTable = "CREATE TABLE " + TABLE_NAME_BOOKINFO +" (" +
        COL_BOOK_NAME +" VARCHAR(256)," +
        COL_BOOK_PRICE +" VARCHAR(256)," +
        COL_PUBLISH_YEAR +" VARCHAR(256)," +
        COL_BUYER_NUMBER+" VARCHAR(256)," +
        COL_BUYER_EMAIL +" VARCHAR(256));" ;

class MyDatabaseHelper (val context: Context):SQLiteOpenHelper(context, DATABASE_NAME,null,
    DATABASE_VERSION){
    override fun onCreate(p0: SQLiteDatabase?) {
        try {
            p0?.execSQL(registationTable)
           // p0?.execSQL(bookInformationTable)
            Toast.makeText(context,"Correctly work",Toast.LENGTH_LONG).show()
        }catch (e:Exception){
            Toast.makeText(context," "+e,Toast.LENGTH_LONG).show()

        }

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        try {

           // db!!.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS)
           // onCreate(db)

            p0?.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_REG);
            //p0!!.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_BOOKINFO);
            onCreate(p0)
        }catch (e:Exception){
            Toast.makeText(context," "+e,Toast.LENGTH_LONG).show()

        }

    }
    fun insertData(userInfo: UserInfo){
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COL_FULLNAME,userInfo.fullName)
        cv.put(COL_EMAIL,userInfo.email)
        cv.put(COL_AGE,userInfo.age)
        cv.put(COL_MOBILENUMBER,userInfo.mnumber)
        cv.put(COL_PASSWORD,userInfo.password)
        var result = db.insert(TABLE_NAME_REG,null,cv)
        if (result==-1.toLong()){
            Toast.makeText(context,"Failed",Toast.LENGTH_LONG).show()
        }else
            Toast.makeText(context,"Correctly work",Toast.LENGTH_LONG).show()


    }

    fun insertBookData(bookInfo: BookInfo){
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COL_BOOK_NAME,bookInfo.bookName)
        cv.put(COL_BOOK_PRICE,bookInfo.bookPrice)
        cv.put(COL_PUBLISH_YEAR,bookInfo.publicationDate)
        cv.put(COL_BUYER_NUMBER,bookInfo.bmobileNumber)
        cv.put(COL_BUYER_EMAIL,bookInfo.email)

        var result = db.insert(TABLE_NAME_BOOKINFO,null,cv)
        if (result==-1.toLong()){
            Toast.makeText(context,"Failed",Toast.LENGTH_LONG).show()
        }else
            Toast.makeText(context,"Correctly work",Toast.LENGTH_LONG).show()


    }


}