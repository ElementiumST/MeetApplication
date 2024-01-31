package io.stark.meetup.feature.auth.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.stark.meetup.databinding.FragmentSignUpBinding
import io.stark.meetup.feature.application.lazyViewModelGet
import io.stark.meetup.feature.auth.di.DaggerSignUpComponent
import io.stark.meetup.feature.auth.di.SignUpComponent
import io.stark.meetup.feature.auth.viewmodel.SignUpViewModel

class SignUpFragment : Fragment() {

    companion object {
        fun newInstance() = SignUpFragment()
    }

    private lateinit var viewModel: SignUpViewModel
    private lateinit var component: SignUpComponent
    private lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        component = DaggerSignUpComponent.create()
        viewModel = lazyViewModelGet(SignUpViewModel::class.java, component::provideViewModelFactory)
        return binding.root
    }

}