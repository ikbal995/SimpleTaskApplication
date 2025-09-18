package ikbal.mulalic.data.remote.model

import ikbal.mulalic.data.ui.Post
import kotlinx.serialization.Serializable

@Serializable
data class PostEntity(
    val id: Long,
    val userId: Long,
    val title: String,
    val body: String
)

fun PostEntity.toUiModel() = Post(
    id = id,
    userId = userId,
    title = title,
    body = body
)
