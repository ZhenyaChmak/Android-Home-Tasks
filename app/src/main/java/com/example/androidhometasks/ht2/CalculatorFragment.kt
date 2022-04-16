package com.example.androidhometasks.ht2

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.androidhometasks.R
import com.example.androidhometasks.databinding.FragmentCalculatorBinding
import com.example.androidhometasks.pushFragment

class CalculatorFragment : Fragment() {

    private var _binding: FragmentCalculatorBinding? = null
    private val binding get() = requireNotNull(_binding)
    private var list = mutableListOf<String>()

    private var tempString: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentCalculatorBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            toolbarCalculator.inflateMenu(R.menu.menu_calculator)

            button0.initClickListener()
            button1.initClickListener()
            button2.initClickListener()
            button3.initClickListener()
            button4.initClickListener()
            button5.initClickListener()
            button6.initClickListener()
            button7.initClickListener()
            button8.initClickListener()
            button9.initClickListener()

            buttonDivision.initClickListener()
            buttonPlus.initClickListener()
            buttonMinus.initClickListener()
            buttonMultiply.initClickListener()

            buttonClear.setOnClickListener {
                textView.text = ""
                textViewResult.text = ""
            }

            buttonBack.setOnClickListener {
                val string = textView.text.toString()
                if (string.isNotEmpty()) {
                    textView.text = string.substring(0, string.length - 1)
                }
                textViewResult.text = ""
            }

            buttonEqually.setOnClickListener {
                try {
                    if (textView.text.isNotEmpty()) {
                        val result =
                            ParsingStringWithoutBracketsInCalculator(textView.text.toString())
                                .resultSum()
                        val temp = result.toLong()
                        if (result == temp.toDouble()) {
                            textViewResult.text = result.toLong().toString()
                            tempString = " ${textView.text} = ${textViewResult.text}"
                            list.add(tempString)
                            tempString = ""
                        } else {
                            textViewResult.text = result.toString()
                            tempString = " ${textView.text} = ${textViewResult.text}"
                            list.add(tempString)
                            tempString = ""
                        }
                    }
                } catch (e: Exception) {
                    Toast.makeText(
                        buttonEqually.context,
                        "не корректно введенные данные",
                        Toast.LENGTH_LONG
                    )
                        .show()
                }
            }

            toolbarCalculator.setOnMenuItemClickListener {
                pushFragment(list)
                true
            }
        }

    }

    private fun Button.initClickListener() = setOnClickListener {
        setTextView(this.text.toString())
    }


    private fun setTextView(string: String) {
        if (binding.textViewResult.text != "") {
            binding.textView.text = binding.textViewResult.text
            binding.textViewResult.text = ""
        }
        binding.textView.append(string)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
