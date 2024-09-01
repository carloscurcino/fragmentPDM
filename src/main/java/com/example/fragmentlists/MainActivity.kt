package com.example.fragmentlists

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentTransaction
import com.example.fragmentlists.BlankFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val btnFragment: Button = findViewById(R.id.btnFragment)
        val btnFragment2: Button = findViewById(R.id.btnFragment2)

        val fragment = BlankFragment()
        val fragment2 = Fragment2()

        var transaction:FragmentTransaction  = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameContent, fragment)
        transaction.commit()

        btnFragment.setOnClickListener {
            // Vai para Tela2
           println("fragment1")
            transaction  = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frameContent, fragment)
            transaction.commit()
        }
        btnFragment2.setOnClickListener{
            println("fragment2")
            transaction  = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frameContent, fragment2)
            transaction.commit()
        }

    }
}
