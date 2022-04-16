package com.example.androidhometasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.androidhometasks.ht2.CalculatorFragment
import com.example.androidhometasks.ht2.CalculatorHistoryFragment
import com.example.androidhometasks.ht2.Navigator

class MainActivity : AppCompatActivity(R.layout.activity_main), Navigator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addFragment(CalculatorFragment())

    }

    fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

}

fun Fragment.pushFragment(list: List<String>) {
    (requireActivity() as MainActivity).addFragment(CalculatorHistoryFragment.getInstance(list))
}

