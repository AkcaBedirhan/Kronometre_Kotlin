package com.erk.kronometre_kotlin

import android.annotation.SuppressLint
import android.app.ActivityManager
import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.erk.kronometre_kotlin.databinding.ActivityMainBinding
import java.util.function.ToLongBiFunction


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    @SuppressLint("SuspiciousIndentation")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var zamaniDurdur:Long = 0
        binding.btnStart.setOnClickListener{
            binding.kronometreKotlin.base=SystemClock.elapsedRealtime()+zamaniDurdur
            binding.kronometreKotlin.start()
            binding.btnStart.visibility= View.GONE
            binding.btnPause.visibility= View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.pause))

        }
        binding.btnPause.setOnClickListener{
            zamaniDurdur=binding.kronometreKotlin.base-SystemClock.elapsedRealtime()
            binding.kronometreKotlin.stop()
            binding.btnPause.visibility= View.GONE
            binding.btnStart.visibility= View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.start))

        }
        binding.btnReset.setOnClickListener{
            binding.kronometreKotlin.base=SystemClock.elapsedRealtime()
            binding.kronometreKotlin.stop()
            zamaniDurdur=0
            binding.btnPause.visibility= View.GONE
            binding.btnStart.visibility= View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.start))

        }


    }
}