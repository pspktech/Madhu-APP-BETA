# 📱 Madhu Patel — Personal Portfolio App

> A modern, animated **personal portfolio Android app** built with **Kotlin + Jetpack Compose + MVVM + Material Design 3** — showcasing real-world projects, skills, and contact info in a beautiful, native experience.

<p align="center">
  <img src="https://img.shields.io/badge/Kotlin-1.9.24-purple?style=for-the-badge&logo=kotlin" />
  <img src="https://img.shields.io/badge/Jetpack%20Compose-BOM%202024.09-blue?style=for-the-badge&logo=jetpackcompose" />
  <img src="https://img.shields.io/badge/MVVM-Architecture-green?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Material%203-Design-orange?style=for-the-badge&logo=materialdesign" />
  <img src="https://img.shields.io/badge/Min%20SDK-24-brightgreen?style=for-the-badge&logo=android" />
</p>

---

## 📌 Overview

This is the native Android version of my personal portfolio website ([madhupatel.is-a.dev](https://madhupatel.is-a.dev)).  
It showcases **6 real-world projects** — from an AI WhatsApp bot to a Kotlin-based Instagram downloader — with a smooth, animated **Hero section**, live links (GitHub / Live / APK / Telegram), and a dark frosted-glass Material 3 experience.

---

## ✨ Features

- 🎨 **Hero Section** with animated logo (fade + scale-in)
- 🧊 **Frosted-glass UI** — layered dark surfaces, gradient borders, soft shadows, and neon Indigo → Teal accents
- 📱 **6 Project cards** with category, tech chips, and dynamic action buttons
- 🔗 **One-tap links** — Details, Source, Live, APK, Telegram
- ✨ **Motion-first UX** — animated background blobs, hero parallax, card entrance/press motion, and staggered skill chips
- 📳 **Haptic feedback** — lightweight tactile feedback on project actions
- 🏗️ **MVVM Architecture** — clean separation: ViewModel → Repository → UI
- ⚡ **Jetpack Compose** — fully declarative UI, no XML layouts
- 🎯 **Material Design 3** — typography, color scheme, chips, cards
- 🔄 **StateFlow** — reactive UI state management
- 📦 **GitHub Actions CI** — auto-build APK on every push

---

## 🎬 Motion & Interaction Details

The app uses subtle animations to make the portfolio feel responsive without distracting from the project content:

- **Floating background blobs** continuously drift behind the content to add depth to the frosted-glass surfaces.
- **Hero parallax** moves the opening section at a slower rate while scrolling, creating a lightweight depth effect.
- **Animated glass borders** gently sweep between indigo and teal on glass cards.
- **Project card entrance motion** uses a staggered scale-in effect as cards appear.
- **Press feedback** slightly scales the primary project action and adds haptic feedback on tap.
- **Staggered skill chips** fade and scale into place one after another.
- **Hero glow animation** softly brings focus to the profile mark when the screen opens.

Animations are deliberately short and low-amplitude so the interface remains comfortable on smaller Android devices.

---

## 🖼️ App Preview

| Hero Section | Projects List | Project Card |
|:---:|:---:|:---:|
| Gradient header + animated logo | Scrollable project list | Tech chips + action buttons |

> *(Add screenshots here after building — place them in `screenshots/` folder)*

---

## 🛠️ Tech Stack

| Layer | Technology |
|-------|-----------|
| **Language** | Kotlin 1.9.24 |
| **UI Framework** | Jetpack Compose (BOM 2024.09.00) |
| **Design System** | Material Design 3 |
| **Architecture** | MVVM (Model-View-ViewModel) |
| **State Management** | Kotlin StateFlow + `collectAsStateWithLifecycle` |
| **Async** | Kotlin Coroutines |
| **Build System** | Gradle Kotlin DSL |
| **CI/CD** | GitHub Actions |
| **Application ID** | `com.madhupatel.portfolio` |
| **Min SDK** | 24 (Android 7.0) |
| **Target SDK** | 34 (Android 14) |

---

##
