package com.example.androidhometasks.ht2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidhometasks.databinding.FragmentRecyclerviewHistoryCalculatorBinding

class CalculatorHistoryFragment : Fragment() {

    private var _binding: FragmentRecyclerviewHistoryCalculatorBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentRecyclerviewHistoryCalculatorBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {

            recyclerviewHistory.layoutManager = LinearLayoutManager(view.context)

            recyclerviewHistory.adapter =
                requireArguments().getStringArrayList(KEY_LIST)?.let {HistoryAdapter(it)}
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    companion object {

        private const val KEY_LIST = "key_list"

        fun getInstance(list: List<String>): CalculatorHistoryFragment {
            return CalculatorHistoryFragment().apply {
                arguments = bundleOf(
                    KEY_LIST to list
                )
            }
        }
    }

}