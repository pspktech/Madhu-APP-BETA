package com.madhupatel.portfolio.viewmodel

import androidx.lifecycle.ViewModel
import com.madhupatel.portfolio.data.model.PortfolioUiState
import com.madhupatel.portfolio.data.repository.PortfolioRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PortfolioViewModel(
    private val repository: PortfolioRepository = PortfolioRepository()
) : ViewModel() {
    private val _uiState = MutableStateFlow(PortfolioUiState())
    val uiState: StateFlow<PortfolioUiState> = _uiState.asStateFlow()

    init { 
        _uiState.value = repository.getPortfolio() 
    }
}
