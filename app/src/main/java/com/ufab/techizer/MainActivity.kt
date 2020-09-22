package com.ufab.techizer

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var minusNumber = 20
    var diff: Long = 1000

    var text1Counter = 0
    var text2Counter = 1
    var text3Counter = 1
    var text4Counter = 1

    var type = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counter()
    }

    private fun counter() {
        val maxCounter: Long = Long.MAX_VALUE

        object : CountDownTimer(maxCounter, diff) {
            override fun onTick(millisUntilFinished: Long) {
                diff = maxCounter - millisUntilFinished

                calculateTime(diff / 1000)


                mTextField.setText("seconds completed: " + diff / 1000)
                //here you can have your logic to set text to edittext
            }

            override fun onFinish() {
                mTextField.setText("done!")
            }
        }.start()
    }

    fun calculateTime(seconds: Long) {
        val modNumber = seconds.toInt() % 5
        if (modNumber == 0) {
            if (seconds / 5 <= 3) {
                setText((seconds / 5).toInt(), seconds)
            } else {
                val magicNumber = (seconds.toInt() - minusNumber) / 5
                setText(magicNumber, seconds)
            }



        } else {
            setText(type, seconds)
        }


    }

    fun setText(type: Int, second: Long) {
        Log.e("seconds", type.toString())

        when (this.type) {
            0 -> {
                text1.text =  text1Counter.toString()
                text1Counter++
            }
            1 ->{ text2.text =  text2Counter.toString()
                text2Counter++
            }
            2 -> {
                text3.text =  text3Counter.toString()
                text3Counter++
            }

            3 -> {
                text4.text = text4Counter.toString()
                text4Counter++
                    minusNumber = second.toInt()

                }

        }

            this.type = type

    }


}