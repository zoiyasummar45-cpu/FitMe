package com.example.fitme.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitme.ui.theme.FitMeColors

@Composable
fun OnboardingHeader(
    currentStep: Int,
    totalSteps: Int = 6,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            FitMeBackButton(onBack = onBack)

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Step $currentStep of $totalSteps",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = FitMeColors.TextSecondary
            )

            Spacer(modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(40.dp)) // balance back button width
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Progress bar indicator
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            for (i in 1..totalSteps) {
                val isCompleted = i <= currentStep
                val isCurrent = i == currentStep

                Box(
                    modifier = Modifier
                        .size(if (isCurrent) 12.dp else 8.dp)
                        .clip(CircleShape)
                        .background(
                            if (isCompleted) FitMeColors.MagentaPrimary else FitMeColors.BorderLight
                        )
                )

                if (i < totalSteps) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(3.dp)
                            .padding(horizontal = 2.dp)
                            .clip(CircleShape)
                            .background(
                                if (i < currentStep) FitMeColors.MagentaPrimary else FitMeColors.BorderLight
                            )
                    )
                }
            }
        }
    }
}
