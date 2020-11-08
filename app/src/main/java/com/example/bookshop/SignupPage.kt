package com.example.bookshop
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_signup_page.*

class SignupPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_page)
        val context = this
        signUpBtn.setOnClickListener ({
            if (fullName.text.toString().length>0 &&
                    fullName.text.toString().length>0 &&
                    userEmailId.text.toString().length>0 &&
                    age.text.toString().length>0 &&
                    mNumber.text.toString().length>0 &&
                    password.text.toString().length>0){

                var user= UserInfo(fullName.text.toString(),
                    userEmailId.text.toString(),
                    age.text.toString(),
                    mNumber.text.toString(),
                    password.text.toString()

                    )
                var db = MyDatabaseHelper(context)
                db.insertData(user)
            }
            else{
                Toast.makeText(context,"Fill all the field", Toast.LENGTH_LONG).show()

            }

        })
    }
}