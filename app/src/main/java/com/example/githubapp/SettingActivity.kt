package com.example.githubapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.githubapp.notification.AlarmReceiver
import com.example.githubapp.notification.AlarmReceiver.Companion.TYPE_REPEATING
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var notification : AlarmReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        supportActionBar?.title = "Setting"

        btn_send.setOnClickListener(this)
        btn_off.setOnClickListener(this)

        notification = AlarmReceiver()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_send -> {
                val message = "Check lagi"
                notification.setRepeatingAlarm(this, TYPE_REPEATING, message)
            }
            R.id.btn_off -> {
                notification.cancelAlarm(this, TYPE_REPEATING)
            }
        }
    }
}