package com.khusnia.mylaundry.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_signin.*
import android.widget.Toast
import com.khusnia.mylaundry.HomeActivity
import com.khusnia.mylaundry.R
import com.khusnia.mylaundry.utils.Preferences
import com.google.firebase.database.*


class SigninActivity : AppCompatActivity() {

    lateinit var iUsername :String
    lateinit var iPassword :String

    lateinit var mDatabase: DatabaseReference
    lateinit var preferences: Preferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        mDatabase = FirebaseDatabase.getInstance().getReference("User")
        preferences = Preferences(this)

//        preferences.setValues("onboarding", "1")
//        if (preferences.getValues("status").equals("1")) {
//            finishAffinity()
//
//            val intent = Intent(this@SigninActivity,
//                MainActivity::class.java)
//            startActivity(intent)
//        }

        btn_login.setOnClickListener {
            iUsername = et_username.text.toString()
            iPassword = et_password.text.toString()

            if (iUsername.equals("")) {
                et_username.error = "Silahkan tulis Username Anda"
                et_username.requestFocus()
            } else if (iPassword.equals("")) {
                et_password.error = "Silahkan tulis Password Anda"
                et_password.requestFocus()
            } else {
                    pushLogin(iUsername, iPassword)
            }
        }

        btn_register.setOnClickListener {
            val intent = Intent(this@SigninActivity, SignupActivity::class.java)
            startActivity(intent)
        }
    }

    private fun pushLogin(iUsername: String, iPassword: String) {
        mDatabase.child(iUsername).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                val user = dataSnapshot.getValue(User::class.java)
                if (user == null) {
                    Toast.makeText(this@SigninActivity, "User tidak ditemukan", Toast.LENGTH_LONG).show()

                } else {
                    if (user.password.equals(iPassword)){
                        Toast.makeText(this@SigninActivity, "Selamat Datang", Toast.LENGTH_LONG).show()

                        preferences.setValues("nama", user.nama.toString())
                        preferences.setValues("user", user.username.toString())
                        preferences.setValues("email", user.email.toString())
                        preferences.setValues("status", "1")

                        finishAffinity()

                        val intent = Intent(this@SigninActivity,
                            HomeActivity::class.java)
                        startActivity(intent)

                    } else {
                        Toast.makeText(this@SigninActivity, "Password Anda Salah", Toast.LENGTH_LONG).show()
                    }

                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@SigninActivity, ""+error.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}
