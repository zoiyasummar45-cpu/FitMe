package com.example.fitme.ui.model

data class FitMeUserData(
    val email: String = "",
    val fullName: String = "",
    val gender: String = "Female",
    val fitnessGoal: String = "Lose Weight",
    val fitnessLevel: String = "Beginner",
    val ageYears: Int = 25,
    val heightCm: Int = 165,
    val weightKg: Int = 60,
    val wellnessStage: String = "Menstrual Cycle"
)
