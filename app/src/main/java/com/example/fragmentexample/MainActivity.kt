package com.example.fragmentexample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fragmentexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnFragmentActionsListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // replaceFragment(RedFragment())

        binding.btnRed.setOnClickListener { replaceFragment(RedFragment()) }
        binding.btnBlue.setOnClickListener { replaceFragment(BlueFragment()) }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.fragmentContainer.id, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    override fun onClickFragmentButton(color: String) {
        Toast.makeText(this, "El botón del fragment $color ha sido pulsado", Toast.LENGTH_SHORT).show()
    }
}