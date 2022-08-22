package com.example.bahadireray_odev1

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.bahadireray_odev1.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var imageArray = ArrayList<ImageView>()
    var one = 0;
    var two = 0;
    var three = 0;
    var four = 0;
    var five = 0;
    var six = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        imageArray.add(binding.imageView1)
        imageArray.add(binding.imageView2)
        imageArray.add(binding.imageView3)
        imageArray.add(binding.imageView4)
        imageArray.add(binding.imageView5)
        imageArray.add(binding.imageView6)


        object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.button.text = "Başlamak İçin Bekle"
            }

            override fun onFinish() {
                for (images in imageArray) {
                    images.visibility = View.INVISIBLE
                }
                binding.button.text = "Zar At"
            }
        }.start()
    }

    fun dicePut(view: View) {

        for (images in imageArray) {
            images.visibility = View.INVISIBLE
        }
        val random = Random.nextInt(6)
        val randomIndex = random
        imageArray[randomIndex].visibility = View.VISIBLE
        println("deneme$randomIndex")

        when (randomIndex) {
            0 -> {
                one++
                binding.txtOne.text = " Bir : $one"
            }
            1 -> {
                two++
                binding.txtTwo.text = " İki : $two"
            }
            2 -> {
                three++
                binding.txtThree.text = "Üç : $three"
            }
            3 -> {
                four++
                binding.txtFour.text = "Dört : $four"
            }
            4 -> {
                five++
                binding.txtFive.text = "Beş : $five"
            }
            5 -> {
                six++
                binding.txtSix.text = "Altı : $six"
            }
        }
    }
}