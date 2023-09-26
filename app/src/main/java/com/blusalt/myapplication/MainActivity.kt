package com.blusalt.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
//import com.blusalt.posplugin.PosMainActivity
import com.dspread.blusalt.activities.AmountEntryActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.pay).setOnClickListener { v: View? ->
//            val intent = Intent(this, PosMainActivity::class.java)
            val intent = Intent(this, AmountEntryActivity::class.java)
            startActivityForResult(intent, 180)
//            resultLauncher.launch(intent)
        }
    }

    private var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        Log.e("MainActivity APP", "okayy")
        Log.e("MainActivity APP", "okayy" + result)

        if (result.resultCode == Activity.RESULT_OK) {
            // There are no request codes
            Log.e("MainActivity APP", "okay" + result.data.toString())

            val data: Intent? = result.data
            val result = data?.data
            Log.e("MainActivity APP", "okayy" + result)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.e("MainActivity APP", "okayy")
        Log.e("MainActivity APP", "okayy" + resultCode)
        when (requestCode) {
            180 -> if (resultCode == RESULT_OK) {
                val responseCode = intent.getStringExtra("responseCode")

                Log.d("TAG", "responseCode $responseCode")
            }
        }
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        Log.e("MainActivity APP", "okay" + requestCode)
//        Log.e("MainActivity APP", "okay" + resultCode)
//
//        if (resultCode == Activity.RESULT_OK && requestCode == 180) {
//
//            val result = data?.getStringExtra("data")
//            Log.e("MainActivity APP", "okayy" + result)
//
//            if (data != null && data.hasExtra("data")) {
//                val result = data.getStringExtra("data")
//                Log.e("MainActivity APP", result.toString())
//            }
//        }
//    }
}