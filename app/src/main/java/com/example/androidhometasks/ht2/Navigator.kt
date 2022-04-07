package com.example.androidhometasks.ht2

import androidx.fragment.app.Fragment

fun Fragment.navigatorFragmentBack(): Navigator {

    return requireActivity() as Navigator

}

interface Navigator {

    fun onBackPressed()

}