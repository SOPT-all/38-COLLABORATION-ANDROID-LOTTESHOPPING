package org.sopt.lotteshopping.presentation.shopping

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.lotteshopping.data.model.shopping.NewsCategory
import org.sopt.lotteshopping.data.model.shopping.NewsModel
import org.sopt.lotteshopping.data.repository.ShoppingRepository
import org.sopt.lotteshopping.core.extension.toFormattedDate
import javax.inject.Inject

@HiltViewModel
@RequiresApi(Build.VERSION_CODES.O)
class ShoppingViewModel @Inject constructor(
    private val shoppingRepository: ShoppingRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow(ShoppingUiState())
    val uiState: StateFlow<ShoppingUiState> = _uiState.asStateFlow()

    init {
        getHighlights()
        getNews()
    }

    private fun getHighlights() {
        viewModelScope.launch {
            shoppingRepository.getShoppingHighlight()
                .onSuccess { result ->
                    _uiState.update { it.copy(highlights = result.toImmutableList()) }
                }
        }
    }

    private fun getNews(
        category: NewsCategory = NewsCategory.ALL,
    ) {
        viewModelScope.launch {
            shoppingRepository.getNews(category)
                .onSuccess { result ->
                    _uiState.update {
                        it.copy(
                            news = result.map { model ->
                                NewsModel(
                                    id = model.id,
                                    title = model.title,
                                    targetBranch = model.targetBranch,
                                    startDate = model.startDate.toFormattedDate(),
                                    endDate = model.endDate.toFormattedDate(),
                                    imageUrl = model.imageUrl,
                                )
                            }.toImmutableList()
                        )
                    }
                }
        }
    }

    fun onCategoryClick(category: NewsCategory) {
        _uiState.update { it.copy(selectedCategory = category) }
        getNews(category)
    }
}
