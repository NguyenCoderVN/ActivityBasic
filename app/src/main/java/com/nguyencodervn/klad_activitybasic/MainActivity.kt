package com.nguyencodervn.klad_activitybasic

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import timber.log.Timber

class MainActivity : AppCompatActivity(), LifecycleEventObserver {
    private lateinit var mainToABt: Button
    private lateinit var countBt: Button
    private lateinit var finishBt: Button
    private lateinit var countTv: TextView
    private lateinit var mainTv: TextView
    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle.addObserver(this)
        initId()
        setupEven()
//        if (savedInstanceState!=null) {
//            count = savedInstanceState.getInt(KEY_COUNT)
//            countTv.text = count.toString()
//        }
    }

    companion object {
        const val KEY_COUNT = "KEY_COUNT"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(KEY_COUNT, count)
        Timber.i("onSaveInstanceState")
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        count = savedInstanceState.getInt(KEY_COUNT)
        countTv.text = count.toString()
        Timber.i("onRestoreInstanceState")
    }

    @SuppressLint("SetTextI18n")
    private fun initId() {
        mainToABt = findViewById(R.id.mainToABt)
        countBt = findViewById(R.id.countBt)
        finishBt = findViewById(R.id.finishBt)
        countTv = findViewById(R.id.countTv)
        mainTv = findViewById(R.id.mainTv)
        countTv.text = "0"
        val api = Build.VERSION.SDK_INT
        mainTv.text = "MainActivity run API $api"
    }

    private fun setupEven() {
        mainToABt.setOnClickListener {
            val intent = Intent(this, ActivityA::class.java)
            startActivity(intent)
        }

        finishBt.setOnClickListener {
            finish()
        }

        countBt.setOnClickListener {
            count += 1
            countTv.text = count.toString()
        }
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_STOP -> Timber.i("onStop");
            Lifecycle.Event.ON_CREATE -> Timber.i("onCreate");
            Lifecycle.Event.ON_START -> Timber.i("onStart");
            Lifecycle.Event.ON_RESUME -> Timber.i("onResume")
            Lifecycle.Event.ON_PAUSE -> Timber.i("onPause");
            Lifecycle.Event.ON_DESTROY -> Timber.i("onDestroy");
            Lifecycle.Event.ON_ANY -> Timber.i("onAny");
        }
    }
}