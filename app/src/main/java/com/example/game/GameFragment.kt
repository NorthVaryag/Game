package com.example.game

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.game.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    var _binding : FragmentGameBinding? = null
    val binding get() = _binding!!

    companion object {
        fun newInstance() = GameFragment()
    }

    private val viewModel: GameViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        val view = binding.root

        viewModel.displayWord.observe( viewLifecycleOwner,Observer<String>{
            binding.displayWord.text = it
        })

        viewModel.tryCount.observe(viewLifecycleOwner, Observer{
            binding.textCount.text = "Кол-во попыток: $it"
        })

        return view
    }
}