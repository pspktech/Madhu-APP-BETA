package com.example.portfolio.viewmodel

import androidx.lifecycle.ViewModel
import com.example.portfolio.data.model.Project
import com.example.portfolio.data.model.Skill
import com.example.portfolio.data.repository.PortfolioRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class PortfolioUiState(
    val name: String = "",
    val role: String = "",
    val tagline: String = "",
    val email: String = "",
    val github: String = "",
    val linkedin: String = "",
    val skills: List<Skill> = emptyList(),
    val projects: List<Project> = emptyList()
)

class PortfolioViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        PortfolioUiState(
            name = PortfolioRepository.profile.name,
            role = PortfolioRepository.profile.role,
            tagline = PortfolioRepository.profile.tagline,
            email = PortfolioRepository.profile.email,
            github = PortfolioRepository.profile.github,
            linkedin = PortfolioRepository.profile.linkedin,
            skills = PortfolioRepository.skills,
            projects = PortfolioRepository.projects
        )
    )
    val uiState: StateFlow<PortfolioUiState> = _uiState.asStateFlow()
}
