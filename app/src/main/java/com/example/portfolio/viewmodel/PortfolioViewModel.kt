package com.example.portfolio.viewmodel

import androidx.lifecycle.ViewModel
import com.example.portfolio.data.model.PortfolioUiState
import com.example.portfolio.data.repository.PortfolioRepository
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
