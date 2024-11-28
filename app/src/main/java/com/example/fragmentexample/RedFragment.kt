package com.example.fragmentexample

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentexample.databinding.FragmentRedBinding

class RedFragment : Fragment() {
    private lateinit var _binding: FragmentRedBinding
    private val binding get() = _binding

    private lateinit var listener: OnFragmentActionsListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentActionsListener) {
            listener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // view binding in fragment
        binding.btnPlus.setOnClickListener { listener.onClickFragmentButton("ROJO") }
    }

    override fun onDetach() {
        super.onDetach()
        // listener = null
        binding.btnPlus.setOnClickListener {  }
    }
}