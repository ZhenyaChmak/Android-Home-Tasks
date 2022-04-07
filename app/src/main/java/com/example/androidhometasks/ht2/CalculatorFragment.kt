package com.example.androidhometasks.ht2

import android.os.Bundle
import android.view.*
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

            button0.setOnClickListener { setTextView(button0.text.toString()) }
            button1.setOnClickListener { setTextView(button1.text.toString()) }
            button2.setOnClickListener { setTextView(button2.text.toString()) }
            button3.setOnClickListener { setTextView(button3.text.toString()) }
            button4.setOnClickListener { setTextView(button4.text.toString()) }
            button5.setOnClickListener { setTextView(button5.text.toString()) }
            button6.setOnClickListener { setTextView(button6.text.toString()) }
            button7.setOnClickListener { setTextView(button7.text.toString()) }
            button8.setOnClickListener { setTextView(button8.text.toString()) }
            button9.setOnClickListener { setTextView(button9.text.toString()) }

            buttonDivision.setOnClickListener { setTextView(buttonDivision.text.toString()) }
            buttonPlus.setOnClickListener { setTextView(buttonPlus.text.toString()) }
            buttonMinus.setOnClickListener { setTextView(buttonMinus.text.toString()) }
            buttonMultiply.setOnClickListener { setTextView(buttonMultiply.text.toString()) }

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
