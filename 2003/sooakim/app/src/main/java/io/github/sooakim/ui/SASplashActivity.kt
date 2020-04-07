package io.github.sooakim.ui

import android.content.Intent
import androidx.activity.viewModels
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.github.sooakim.ui.base.SAActivity
import io.github.sooakim.ui.login.SALoginActivity
import io.github.sooakim.ui.movie.SAMovieSearchActivity

class SASplashActivity : SAActivity<ViewDataBinding, SASplashViewModel, SASplashState>() {
    override val viewModel: SASplashViewModel by viewModels {
        object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return SASplashViewModel(
                    authRepository = requireApplication().authRepository
                ) as T
            }
        }
    }

    override fun onState(newState: SASplashState) {
        when (newState) {
            is SASplashState.ShowLogin -> {
                startActivity(Intent(this, SALoginActivity::class.java))
                finish()
            }
            is SASplashState.ShowMain -> {
                startActivity(Intent(this, SAMovieSearchActivity::class.java))
                finish()
            }
        }
    }
}