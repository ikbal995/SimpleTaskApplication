package ikbal.mulalic.simpletaskapplication.post

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ikbal.mulalic.data.remote.NetworkState
import ikbal.mulalic.data.ui.Post
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    private val _posts = MutableStateFlow<NetworkState<List<Post>>>(NetworkState.Loading)
    val posts: StateFlow<NetworkState<List<Post>>> = _posts.asStateFlow()

    init {
        viewModelScope.launch {
            val posts = mainRepository.getAllPosts()
            posts.collect { _posts.value = it }
        }
    }
}