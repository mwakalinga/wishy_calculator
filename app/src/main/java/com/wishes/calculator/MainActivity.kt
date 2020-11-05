package com.wishes.calculator

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var numOne = 0.0
    private var numTwo = 0.0
    private var results =0.0
    private var nums = ""
    private var operation = ""
    private var firstLine = true
    private var num2 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn0.setOnClickListener {
            addNumber("0")
        }

        btn1.setOnClickListener {
            addNumber("1")
        }

        btn2.setOnClickListener {
            addNumber("2")
        }

        btn3.setOnClickListener {
            addNumber("3")
        }

        btn4.setOnClickListener {
            addNumber("4")
        }

        btn5.setOnClickListener {
            addNumber("5")
        }

        btn6.setOnClickListener {
            addNumber("6")
        }

        btn7.setOnClickListener {
            addNumber("7")
        }

        btn8.setOnClickListener {
            addNumber("8")
        }

        btn9.setOnClickListener {
            addNumber("9")
        }

        btndot.setOnClickListener {
            addNumber(".")
        }
    }

    private fun doing(){
        textout.text = results.toString()
    }

    private fun setOperation(operate : String){
        if (results != 0.0){
            operation = operate
            textin.text = results.toString() + operate
            numOne = results
            numTwo = 0.0
            results = 0.0
            num2 = ""
            textout.text = ""

        }else{
            firstLine = false
            operation = operate
            numOne = nums.toDouble()
            nums = textin.text.toString() + operate
            textin.text = nums
        }

    }

    fun delete(view: View) {
        clear()
    }

    fun clear(){
        numOne = 0.0
        numTwo = 0.0
        results =0.0
        nums = ""
        operation = ""
        firstLine = true
        num2 = ""
        textout.text = ""
        textin.text = ""
    }

    fun equal(view: View) {
        numTwo = num2.toDouble()
        when (operation) {
            "+" -> {
                results = numOne.plus(numTwo)
                doing()
            }
            "-" -> {
                results = numOne.minus(numTwo)
                doing()
            }
            "*" -> {
                results = numOne.times(numTwo)
                doing()
            }
            "/" -> {
                results = numOne.div(numTwo)
                doing()
            }
        }
    }

    fun devide(view: View) {
        setOperation("/")
    }

    fun times(view: View) {
        setOperation("*")
    }

    fun minus(view: View) {
        setOperation("-")
    }

    fun plus(view: View) {
        setOperation("+")
    }

    private fun addNumber(num: String){
        when {
            results != 0.0 -> {
                clear()
                nums = textin.text.toString() + num
                textin.text = nums
            }
            firstLine -> {
                nums = textin.text.toString() + num
                textin.text = nums
            }
            else -> {
                num2 += num
                nums = textin.text.toString() +num
                textin.text = nums
            }
        }

    }
}