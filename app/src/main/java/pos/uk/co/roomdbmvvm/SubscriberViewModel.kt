package pos.uk.co.roomdbmvvm

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pos.uk.co.roomdbmvvm.db.Subscriber
import pos.uk.co.roomdbmvvm.db.SubscriberRepository

class SubscriberViewModel(private val repository: SubscriberRepository) : ViewModel(), Observable{

    val subscribers = repository.subscribers

    @Bindable
    val inputName = MutableLiveData<String>()
    @Bindable
    val inputEmail = MutableLiveData<String>()
    @Bindable
    val saveOrUpdateButtonText = MutableLiveData<String>()
    @Bindable
    val clearAllOrDeleteButtonText = MutableLiveData<String>()

    init {
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "Delete All"
    }

    fun saveOrUpdate(){
        val name = inputName.value!!
        val email = inputEmail.value!!

        insert(Subscriber(0, name, email))
        inputName.value = ""
        inputEmail.value = ""
    }

    fun clearAllOrDelete(){
        clearAll()
    }

    fun insert(subscriber: Subscriber){
        viewModelScope.launch {
            repository.insert(subscriber)
        }
    }

    // OR
//    fun insert(subscriber: Subscriber) = viewModelScope.launch { repository.insert(subscriber) }
    fun update(subscriber: Subscriber) = viewModelScope.launch { repository.update(subscriber) }
    fun delete(subscriber: Subscriber) = viewModelScope.launch { repository.delete(subscriber) }
    fun clearAll() = viewModelScope.launch { repository.deleteAll() }



    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

}