package uk.co.brightman.mycarbonfoodprint.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import uk.co.brightman.mycarbonfoodprint.data.LoginDataSource
import uk.co.brightman.mycarbonfoodprint.data.LoginRepository

/**
 * ViewModel provider factory to instantiate LoginViewModel.
 * Required given LoginViewModel has a non-empty constructor
 */
class LoginViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(
                loginRepository = LoginRepository(
                    dataSource = LoginDataSource()
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}