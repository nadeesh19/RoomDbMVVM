package pos.uk.co.roomdbmvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import pos.uk.co.roomdbmvvm.db.SubscriberRepository

class SubscriberViewModelFactory(private val repository: SubscriberRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SubscriberViewModel::class.java)){
            return SubscriberViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown view model class")
    }
}

/*
class EmailAccountValidationViewModelFactory(private val accountCreator: AccountCreator) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return EmailAccountValidationViewModel(accountCreator) as T
    }
}
*/
