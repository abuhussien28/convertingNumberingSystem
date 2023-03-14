package com.example.convertingnumber.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.convertingnumber.R


class OperationScreen : Fragment() {

private lateinit var editTextNumberOne:EditText
private lateinit var editTextNumberTwo:EditText
private lateinit var resultTextView:TextView
private lateinit var addIcon:ImageView
private lateinit var subtractIcon:ImageView
private lateinit var multiplyIcon:ImageView
private lateinit var divideIcon:ImageView
private lateinit var clear: ImageView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
     var view =inflater.inflate(R.layout.fragment_opeartion_screen, container, false)
        iniViews(view)
        doingOperation()
        clear()
        return view
    }
      fun iniViews(view: View) {
    editTextNumberOne=view.findViewById(R.id.numOneEditText)
    editTextNumberTwo=view.findViewById(R.id.numTwoEditText)
        resultTextView=view.findViewById(R.id.result)
addIcon=view.findViewById(R.id.add)
subtractIcon=view.findViewById(R.id.subtract)
multiplyIcon=view.findViewById(R.id.multiply)
divideIcon=view.findViewById(R.id.divide)
          clear=view.findViewById(R.id.clear)
    }

    fun operationFormula(operator: String) {

        val result = when (operator) {
            "+" ->{ Integer.parseInt(editTextNumberOne.text.toString(), 2) +
                    Integer.parseInt(editTextNumberTwo.text.toString(), 2)}
            "-" -> { Integer.parseInt(editTextNumberOne.text.toString(), 2) -
                    Integer.parseInt(editTextNumberTwo.text.toString(), 2)}
            "*" ->{ Integer.parseInt(editTextNumberOne.text.toString(), 2) *
                    Integer.parseInt(editTextNumberTwo.text.toString(), 2)}
            "/" -> { Integer.parseInt(editTextNumberOne.text.toString(), 2) /
                    Integer.parseInt(editTextNumberTwo.text.toString(), 2)}
            else -> throw IllegalArgumentException("Invalid operator")
        }
        resultTextView.text= "Result :"+Integer.toBinaryString(result)
    }
    fun doingOperation(){

        addIcon.setOnClickListener {
            operationFormula("+")
        }
        subtractIcon.setOnClickListener {
            operationFormula("-")
        }
        multiplyIcon.setOnClickListener { operationFormula("*") }
        divideIcon.setOnClickListener { operationFormula("/") }

    }
    private fun clear(){
        clear.setOnClickListener {
          editTextNumberOne.text.clear()
            editTextNumberTwo.text.clear()
           resultTextView.text=""
        }
    }

}