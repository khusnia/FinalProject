package com.khusnia.mylaundry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home_.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_)

        btn_cari.setOnClickListener {
            val intent = Intent(this@HomeActivity,MainActivity::class.java)
            startActivity(intent)
        }

        btn_about.setOnClickListener {
            val intent = Intent(this@HomeActivity,AboutActivity::class.java)
            startActivity(intent)
        }
    }
}
