package io.stark.authfeature.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import io.stark.authfeature.R
import io.stark.authfeature.databinding.FragmentSplashBinding
import io.stark.authfeature.model.AuthEvent
import io.stark.authfeature.viewmodel.AuthViewModel
import kotlinx.coroutines.launch

class SplashFragment : Fragment() {

    private lateinit var viewModel: AuthViewModel
    private lateinit var binding: FragmentSplashBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[AuthViewModel::class.java]
        lifecycleScope.launch {
            viewModel.getEventFlow().collect {
                when(it) {
                    AuthEvent.AuthCompleted -> {
                        TODO("auth completed")
                    }
                    AuthEvent.TokenSetNotFounded -> {
                        findNavController().navigate(R.id.action_splashFragment_to_signInFragment)
                    }
                }
            }
        }
        viewModel.tryAuthByStore()
        return binding.root
    }


}