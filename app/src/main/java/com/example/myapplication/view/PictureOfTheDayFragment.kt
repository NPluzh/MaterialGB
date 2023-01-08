package com.example.myapplication.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.myapplication.databinding.FragmentPictureBinding
import com.example.myapplication.viewmodel.AppState
import com.example.myapplication.viewmodel.PictureOfTheDayviewModel


class PictureOfTheDayFragment : Fragment() {

    private var _binding: FragmentPictureBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPictureBinding.inflate(inflater, container, false)
        return binding.root

    }

    private val viewModel: PictureOfTheDayviewModel by lazy {
        ViewModelProvider(this).get(PictureOfTheDayviewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getLiveData().observe(viewLifecycleOwner)
        { appState ->
            renderData(appState)
        }
        viewModel.sentRequest()


    }

    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Error -> {/*TODO*/
            }
            AppState.Loading -> {/*TODO*/
            }
            is AppState.Success -> {
                binding.imageView.load(appState.pictureOfTheDayResponseData.url) {
                    //TODO настроить загрузку изображения
                }

            }
        }
    }

    companion object{
        fun newInstance() = PictureOfTheDayFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}