package io.stark.authfeature.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import io.stark.authfeature.databinding.FragmentSignUpBinding
import io.stark.authfeature.di.AuthComponent
import io.stark.authfeature.viewmodel.AuthViewModel

class SignUpFragment : Fragment() {

    private lateinit var viewModel: AuthViewModel
    private lateinit var component: AuthComponent
    private lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(requireActivity())[AuthViewModel::class.java]
        return binding.root
    }

}