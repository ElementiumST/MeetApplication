package io.stark.authfeature.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import io.stark.authfeature.R
import io.stark.authfeature.viewmodel.AuthViewModel

class SignInFragment : Fragment() {

    private lateinit var viewModel: AuthViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity())[AuthViewModel::class.java]
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }


}