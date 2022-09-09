package com.piracanjuba.clues

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var play=findViewById<Button>(R.id.play)
        play.setText("Play")
        var stop=findViewById<Button>(R.id.stop)
        stop.setText("Stop")
        var mp= MediaPlayer()
        play.setOnClickListener {
            mp.setDataSource(this, Uri.parse("android.resource://"+this.packageName+"/"+R.raw.otrem))
            mp.prepare()
            mp.start()
//            if (mp.isPlaying){
//                play.setText("||")
//            }
        }

        stop.setOnClickListener {
            mp.stop()
            mp.release()
            mp= MediaPlayer()
        }

        val button: Button = findViewById(R.id.mongol)
        button.setOnClickListener {
            val intent = Intent(this, Biografia::class.java)
            startActivity(intent)
        }

    }
}