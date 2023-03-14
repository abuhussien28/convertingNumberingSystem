package com.example.convertingnumber.fragment

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.convertingnumber.*

class CovertScreen : Fragment() {
    lateinit var editTextDecimal: EditText
    lateinit var editTextBinary: EditText
    lateinit var editTextOctal: EditText
    lateinit var editTextHex: EditText
    lateinit var clear:ImageButton
    lateinit var onFocusChangeListener: View.OnFocusChangeListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_covert_screen, container, false)
        iniViews(view)
        setFocusChangeListenerForEditText()
        addListener()
        clear()
        return view
    }
    private fun setFocusChangeListenerForEditText(){
        editTextDecimal.onFocusChangeListener = focusChangeListener
        editTextBinary.onFocusChangeListener = focusChangeListener
        editTextOctal.onFocusChangeListener = focusChangeListener
        editTextHex.onFocusChangeListener = focusChangeListener
    }
    private  fun iniViews(view: View){
        editTextDecimal = view.findViewById(R.id.decimalNumberEditText)
        editTextBinary = view.findViewById(R.id.binaryNumberEditText)
        editTextHex = view.findViewById(R.id.hexadecimalNumberEditText)
        editTextOctal = view.findViewById(R.id.octalNumberEditText)
        clear=view.findViewById(R.id.clearButton)
    }
    private fun addListener(){
    editTextDecimal.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {}
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            // check if the decimalEditText has focus
            if (editTextDecimal.hasFocus()) {
                // if it has focus, update the other fields
                try {
                    var num = s.toString().toLong()
                    editTextBinary.setText(java.lang.Long.toBinaryString(num))
                    editTextOctal.setText(java.lang.Long.toOctalString(num))
                    editTextHex.setText(java.lang.Long.toHexString(num))
                } catch (e: NumberFormatException) {
                    e.printStackTrace()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    })
}
    private fun clear(){
        clear.setOnClickListener {
            editTextBinary.text.clear()
            editTextDecimal.text.clear()
            editTextOctal.text.clear()
            editTextHex.text.clear()
        }
    }
    // create an OnFocusChangeListener object
    private val focusChangeListener = View.OnFocusChangeListener { view, hasFocus ->
        if (!hasFocus) {
            // call convertNumber() method when the focus changes from the current EditText field
            convertNumber(view as EditText)
        }
    }
    private fun convertNumber(editText: EditText) {
        try {
            var num: Long = 0
            when (editText.id) {
                R.id.decimalNumberEditText -> {
                    num = editText.text.toString().toLong()
                    editTextBinary.setText(java.lang.Long.toBinaryString(num))
                    editTextOctal.setText(java.lang.Long.toOctalString(num))
                    editTextHex.setText(java.lang.Long.toHexString(num))
                }
                R.id.binaryNumberEditText -> {
                    num = editText.text.toString().toLong(2)
                    editTextDecimal.setText(num.toString())
                    editTextOctal.setText(java.lang.Long.toOctalString(num))
                    editTextHex.setText(java.lang.Long.toHexString(num))
                }
                R.id.octalNumberEditText -> {
                    num = editText.text.toString().toLong(8)
                    editTextDecimal.setText(num.toString())
                    editTextBinary.setText(java.lang.Long.toBinaryString(num))
                    editTextHex.setText(java.lang.Long.toHexString(num))
                }
                R.id.hexadecimalNumberEditText -> {
                    num = editText.text.toString().toLong(16)
                    editTextDecimal.setText(num.toString())
                    editTextBinary.setText(java.lang.Long.toBinaryString(num))
                    editTextOctal.setText(java.lang.Long.toOctalString(num))
                }
            }
        } catch (e: NumberFormatException) {
            Toast.makeText(activity, "enter correct number", Toast.LENGTH_SHORT).show()
        }catch (e: Exception) {
              e.printStackTrace()
        }
    }
}


