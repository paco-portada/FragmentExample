package com.example.fragmentexample

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentexample.databinding.FragmentBlueBinding

class BlueFragment : Fragment() {

    private lateinit var _binding: FragmentBlueBinding
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
        _binding = FragmentBlueBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //btnPlus = requireView().findViewById(R.id.btnPlus)
        binding.btnPlus.setOnClickListener { listener.onClickFragmentButton("AZUL") }
    }

    override fun onDetach() {
        super.onDetach()
        // listener = null
        binding.btnPlus.setOnClickListener { }
    }
}