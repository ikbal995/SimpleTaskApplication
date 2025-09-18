package ikbal.mulalic.simpletaskapplication.post

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ikbal.mulalic.data.remote.NetworkState
import ikbal.mulalic.data.ui.Post


@Composable
fun MainScreen() {
    val mainViewModel: MainViewModel = hiltViewModel()
    val posts by mainViewModel.posts.collectAsStateWithLifecycle()
    when (posts) {
        is NetworkState.Error -> Toast.makeText(
            LocalContext.current,
            (posts as NetworkState.Error).e.message,
            Toast.LENGTH_SHORT
        ).show()

        NetworkState.Loading -> CircularProgressIndicator()
        is NetworkState.Success<List<Post>> -> PostList(((posts as NetworkState.Success<List<Post>>).data))
    }
}

@Composable
fun PostList(list: List<Post>) {
    LazyColumn(modifier = Modifier.padding(vertical = 16.dp)) {
        items(list, key = { it.id }) { post ->
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(Modifier.padding(16.dp)) {
                    Text(text = post.title, style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = post.body, style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}