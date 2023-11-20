package com.nguyencodervn.klad_activitybasic

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.nguyencodervn.klad_activitybasic.MainActivity.Companion.KEY_ACTIVITY
import com.nguyencodervn.klad_activitybasic.MainActivity.Companion.KEY_COUNT
import com.nguyencodervn.klad_activitybasic.MainActivity.Companion.KEY_KIND
import com.nguyencodervn.klad_activitybasic.MainActivity.Companion.KEY_OBJECT


class ActivityA : AppCompatActivity() {
    private lateinit var receivedTv: TextView
    private lateinit var returnBt: Button
    private var count: Int = 0
    private lateinit var activity: String
    private var transfer01: Transfer01? = null
    private var transfer02: Transfer02? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
        receivedTv = findViewById(R.id.receivedTv)
        returnBt = findViewById(R.id.returnBt)

        returnBt.setOnClickListener {
            finish()
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onStart() {
        super.onStart()
        activity = intent.getStringExtra(KEY_ACTIVITY)!!
        count = intent.getIntExtra(KEY_COUNT, 0)

        when (intent.getStringExtra(KEY_KIND)) {
            "Single" -> {
                receivedTv.text = "$activity $count"
            }
            "Serializable" -> {
                transfer01 = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    intent.getSerializableExtra(KEY_OBJECT, Transfer01::class.java)
                } else {
                    intent.getSerializableExtra(KEY_OBJECT) as Transfer01
                }
                receivedTv.text = "$activity $count " +
                        "${transfer01?.language} ${transfer01?.api}"
            }
            "Parcelable" -> {
                transfer02 = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    intent.getParcelableExtra(KEY_OBJECT, Transfer02::class.java)
                } else {
                    intent.getParcelableExtra(KEY_OBJECT)
                }
                receivedTv.text = "$activity $count " +
                        "${transfer02?.language} ${transfer02?.api}"
            }
            "Bundle" -> {
                val bundle = intent.extras
                transfer02 = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    bundle?.getParcelable(KEY_OBJECT, Transfer02::class.java)
                } else {
                    bundle?.getParcelable(KEY_OBJECT)
                }
                receivedTv.text = "$activity $count " +
                        "${transfer02?.language} ${transfer02?.api}"
            }
        }
    }
}