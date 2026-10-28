package com.madhupatel.portfolio.data.model

data class Skill(val name: String)

data class Contact(
    val type: String,
    val value: String,
    val url: String, // ఇది ContactSection లో వాడటానికి ముఖ్యం
    val icon: String
)

data class PortfolioUiState(
    val name: String = "Madhu Patel",
    val role: String = "Android Developer",
    val tagline: String = "Kotlin • MVVM • Material 3",
    val about: String = "Web apps, AI bots and Android tools — each one built end-to-end, from idea to deployment.",
    val skills: List<Skill> = emptyList(), // ఇక్కడ టైప్ ఇవ్వాలి
    val projects: List<Project> = emptyList(), // ఇక్కడ టైప్ ఇవ్వాలి
    val contacts: List<Contact> = emptyList() // ఇక్కడ టైప్ ఇవ్వాలి
)
