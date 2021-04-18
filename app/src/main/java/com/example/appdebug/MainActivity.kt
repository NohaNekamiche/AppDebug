package com.android.example.appdebug

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val util = Util()
        val fbButton = findViewById(R.id.fbButton) as Button
        val factButton = findViewById(R.id.factButton) as Button
        val avgButton = findViewById(R.id.avgButton) as Button
        val factEditText = findViewById(R.id.factEditText) as EditText
        val sizeEditText = findViewById(R.id.sizeEditText) as EditText
        val x=Int.MAX_VALUE
        // The facebook page URL
        val url  = "fb://page/218641444910278"
        // Onclick of the first button
        fbButton.setOnClickListener {
            util.openPage(this,url)
        }
        // Onclick of the second button

        factButton.setOnClickListener {
            if(factEditText.text.toString().isEmpty()) {
                Toast.makeText(this, "veuillez Entrer un chiffre", Toast.LENGTH_SHORT).show()
            }else {
                try {
                if(factEditText.text.toString().toInt()>32767) {
                    Toast.makeText(this, "veuillez Entrer un nombre < ", Toast.LENGTH_SHORT).show()
                } else{



                        if(factEditText.text.toString().toInt()>0){
                            val i = util.factorial(factEditText.text.toString().toInt())
                            Toast.makeText(this,"Le factoriel est: $i",Toast.LENGTH_SHORT).show()}
                        else {Toast.makeText(this, "veuillez Entrer un nombre >0 ", Toast.LENGTH_SHORT).show()}

                    }


                }catch (e:NumberFormatException){
                    Toast.makeText(this, "veuillez Entrer un nombre ", Toast.LENGTH_SHORT).show()
                }}}
        // Onclick of the third button
        avgButton.setOnClickListener {
            if(sizeEditText.text.toString().isEmpty()){
                Toast.makeText(this,"veuillez Entrer un chiffre",Toast.LENGTH_SHORT).show()
            } else{
                try {
                if(sizeEditText.text.toString().toInt()>Int.MAX_VALUE){
                    Toast.makeText(this, "veuillez Entrer un nombre < $x", Toast.LENGTH_SHORT).show()
                }else{

                        if(sizeEditText.text.toString().toInt()>0) {
                            val list = util.randomList(sizeEditText.text.toString().toInt())
                            var sum = 0
                            for (item in list) {
                                sum += item
                            }
                            Toast.makeText(this, "La moyenne de la liste est: ${sum / list.size}", Toast.LENGTH_SHORT).show()
                        }
                    else
                        {
                            Toast.makeText(this, "veuillez Entrer un nombre >0", Toast.LENGTH_SHORT).show()
                        }
                    }
                }catch (e:NumberFormatException){
                    Toast.makeText(this, "veuillez Entrer un nombre ", Toast.LENGTH_SHORT).show()
                }
            }}

    }
}
