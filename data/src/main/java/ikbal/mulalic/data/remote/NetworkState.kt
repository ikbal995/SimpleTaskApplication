package ikbal.mulalic.data.remote

sealed interface NetworkState<out T> {

    class Error(val e: Throwable) : NetworkState<Nothing>

    class Success<T>(val data: T) : NetworkState<T>

    object Loading : NetworkState<Nothing>
}