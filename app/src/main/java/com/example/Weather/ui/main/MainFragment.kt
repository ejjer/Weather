package com.example.Weather.ui.main


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.Weather.databinding.MainFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.Weather.ui.main.model.repository.AppState
import com.google.android.material.snackbar.Snackbar

class MainFragment : Fragment() {



    private val viewModel: MainViewModel by viewModel()

    private var _binding: MainFragmentBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun renderData(appState: AppState)= with(binding){
        when (appState){
            is AppState.Success ->{
                val weatherData = appState.weatherData
                progressBar.visibility = View.GONE
                weatherGroup.visibility = View.VISIBLE
                setData(weatherData)
            }
            is AppState.Loading ->{
                weatherGroup.visibility = View.INVISIBLE
                progressBar.visibility = View.VISIBLE
            }
            is AppState.Error->{
                progressBar.visibility = View.GONE
                weatherGroup.visibility = View.INVISIBLE
                Snackbar
                    .make(mainView, "Error", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Reload"){viewModel.getWeather()}
                    .show()
            }
        }
    }
    companion object {
        fun newInstance() = MainFragment()
    }

}