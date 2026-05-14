package org.sopt.lotteshopping.presentation.shopping

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.lotteshopping.data.model.info.HighlightModel
import org.sopt.lotteshopping.data.model.info.NewsCategory
import org.sopt.lotteshopping.data.model.info.NewsModel
import javax.inject.Inject

@HiltViewModel
class ShoppingViewModel @Inject constructor(
) : ViewModel() {
    private val _uiState = MutableStateFlow(ShoppingUiState())
    val uiState: StateFlow<ShoppingUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            getHighlights()
            getNews()
        }
    }

    private fun getHighlights() {
        viewModelScope.launch {
            // TODO (도연) : API 연동
            delay(300)

            val data = listOf(
                HighlightModel(
                    id = 0L,
                    imageUrl = "https://i.pinimg.com/1200x/26/5b/65/265b65e00c052334005f6fb8e184a54f.jpg",
                ),
                HighlightModel(
                    id = 1L,
                    imageUrl = "https://i.pinimg.com/1200x/26/5b/65/265b65e00c052334005f6fb8e184a54f.jpg",
                ),
                HighlightModel(
                    id = 2L,
                    imageUrl = "https://i.pinimg.com/1200x/26/5b/65/265b65e00c052334005f6fb8e184a54f.jpg",
                ),
                HighlightModel(
                    id = 3L,
                    imageUrl = "https://i.pinimg.com/1200x/26/5b/65/265b65e00c052334005f6fb8e184a54f.jpg",
                )
            )

            _uiState.update { it.copy(highlights = data.toImmutableList()) }
        }
    }

    private fun getNews(
        category: NewsCategory = NewsCategory.ALL,
    ) {
        viewModelScope.launch {
            // TODO (도연) : API 연동
            delay(300)

            val data = listOf(
                NewsModel(
                    id = 0L,
                    title = "[뷰티살롱] 나만을 위한 뷰티 컨설팅",
                    targetBranch = "백화점 전점",
                    startDate = "4.1(수)",
                    endDate = "4.3(목)",
                    imageUrl = "https://i.pinimg.com/1200x/26/5b/65/265b65e00c052334005f6fb8e184a54f.jpg",
                ),
                NewsModel(
                    id = 1L,
                    title = "[뷰티살롱] 나만을 위한 뷰티 컨설팅",
                    targetBranch = "",
                    startDate = "4.1(수)",
                    endDate = "4.3(목)",
                    imageUrl = "https://i.pinimg.com/1200x/26/5b/65/265b65e00c052334005f6fb8e184a54f.jpg",
                ),
                NewsModel(
                    id = 2L,
                    title = "[뷰티살롱] 나만을 위한 뷰티 컨설팅",
                    targetBranch = "백화점 전점",
                    startDate = "4.1(수)",
                    endDate = "4.3(목)",
                    imageUrl = "https://i.pinimg.com/1200x/26/5b/65/265b65e00c052334005f6fb8e184a54f.jpg",
                ),
                NewsModel(
                    id = 3L,
                    title = "[뷰티살롱] 나만을 위한 뷰티 컨설팅",
                    targetBranch = "백화점 전점",
                    startDate = "4.1(수)",
                    endDate = "4.3(목)",
                    imageUrl = "https://i.pinimg.com/1200x/26/5b/65/265b65e00c052334005f6fb8e184a54f.jpg",
                ),
                NewsModel(
                    id = 4L,
                    title = "[뷰티살롱] 나만을 위한 뷰티 컨설팅",
                    targetBranch = "",
                    startDate = "4.1(수)",
                    endDate = "4.3(목)",
                    imageUrl = "https://i.pinimg.com/1200x/26/5b/65/265b65e00c052334005f6fb8e184a54f.jpg",
                ),
                NewsModel(
                    id = 5L,
                    title = "[뷰티살롱] 나만을 위한 뷰티 컨설팅",
                    targetBranch = "",
                    startDate = "4.1(수)",
                    endDate = "4.3(목)",
                    imageUrl = "https://i.pinimg.com/1200x/26/5b/65/265b65e00c052334005f6fb8e184a54f.jpg",
                ),
                NewsModel(
                    id = 6L,
                    title = "[뷰티살롱] 나만을 위한 뷰티 컨설팅",
                    targetBranch = "백화점 전점",
                    startDate = "4.1(수)",
                    endDate = "4.3(목)",
                    imageUrl = "https://i.pinimg.com/1200x/26/5b/65/265b65e00c052334005f6fb8e184a54f.jpg",
                ),
                NewsModel(
                    id = 7L,
                    title = "[뷰티살롱] 나만을 위한 뷰티 컨설팅",
                    targetBranch = "백화점 전점",
                    startDate = "4.1(수)",
                    endDate = "4.3(목)",
                    imageUrl = "https://i.pinimg.com/1200x/26/5b/65/265b65e00c052334005f6fb8e184a54f.jpg",
                ),
            )

            _uiState.update { it.copy(news = data.toImmutableList()) }
        }
    }

    fun onCategoryClick(category: NewsCategory) {
        _uiState.update { it.copy(selectedCategory = category) }
        viewModelScope.launch { getNews(category) }
    }
}
