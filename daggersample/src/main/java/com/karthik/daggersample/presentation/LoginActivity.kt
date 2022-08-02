package com.karthik.daggersample.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.Observer
import com.karthik.daggersample.R
import com.karthik.daggersample.data.model.UserDetails
import com.karthik.daggersample.databinding.ActivityLoginBinding
import com.karthik.daggersample.presentation.viewmodel.LoginViewModel
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    @Inject
    lateinit var viewModel: LoginViewModel

    lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        binding.submit.setOnClickListener(this)
        observeUserDetails()
    }

    private fun observeUserDetails() {
        viewModel.onUserDetailsReceived.observe(this
        ) { user ->
            user.let {
                binding.usernameEdit.setText(it?.userName)
                binding.userPasswordEdit.setText(it?.userPassword)

            }
        }

    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.submit -> viewModel.saveUserDetails(binding.usernameEdit.text.toString(),
            binding.userPasswordEdit.text.toString())

        }
    }
}