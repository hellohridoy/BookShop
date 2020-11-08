package com.example.bookshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sell_your_book.*
import kotlinx.android.synthetic.main.activity_signup_page.*

class SellYourBook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sell_your_book)
        val context = this
        submitButtonId.setOnClickListener ({
            if (bookNameid.text.toString().length>0 &&
                bookPriceid.text.toString().length>0 &&
                publicationDateId.text.toString().length>0 &&
                mobileNumber.text.toString().length>0 &&
                buyerEmailId.text.toString().length>0){

                var bookInfo= BookInfo(bookNameid.text.toString(),
                    bookPriceid.text.toString(),
                    publicationDateId.text.toString(),
                    mobileNumber.text.toString(),
                    buyerEmailId.text.toString()

                )
                var db = MyDatabaseHelper(context)
                db.insertBookData(bookInfo)
            }
            else{
                Toast.makeText(context,"Fill all the field", Toast.LENGTH_LONG).show()

            }

        })
    }
}