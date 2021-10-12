package com.example.videoplayer

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import kotlinx.android.synthetic.main.activity_main.*
import android.view.SurfaceHolder
import android.widget.SeekBar

import androidx.core.view.ViewCompat




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mediaPlayer = MediaPlayer.create(this,R.raw.remo)
        surfaceView.keepScreenOn
        val surfaceHolder= surfaceView.holder
        surfaceHolder.addCallback(object : SurfaceHolder.Callback {
            override fun surfaceCreated(h: SurfaceHolder) {
                mediaPlayer.setDisplay(surfaceHolder)
            }
            override fun surfaceChanged(h: SurfaceHolder, format: Int, width: Int, height: Int) {

            }

            override fun surfaceDestroyed(h: SurfaceHolder) {
            }
        })

        seekBar.setMax(mediaPlayer.duration)
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // TODO Auto-generated method stub
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // TODO Auto-generated method stub
            }

            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // TODO Auto-generated method stub
                if(fromUser){
                    mediaPlayer.seekTo(progress)
                }
            }
        })
        play.setOnClickListener{
            if(mediaPlayer.isPlaying()) {
                mediaPlayer.pause()
                play.setText("Play")
            }
            else{
                mediaPlayer.start()
                play.setText("Pause")
            }

        }

    }
}