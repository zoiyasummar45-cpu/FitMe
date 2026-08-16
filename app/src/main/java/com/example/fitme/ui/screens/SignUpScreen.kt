package com.example.fitme.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitme.ui.components.FitMeBackButton
import com.example.fitme.ui.components.FitMeGradientButton
import com.example.fitme.ui.components.FitMeTextField
import com.example.fitme.ui.components.SocialAuthButton
import com.example.fitme.ui.theme.FitMeColors

@Composable
fun SignUpScreen(
    onSignUpSuccess: () -> Unit,
    onNavigateToLogin: () -> Unit
) {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var dob by remember { mutableStateOf("1998-05-15") }
    var agreeTerms by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FitMeColors.BackgroundLight)
            .verticalScroll(rememberScrollState())
            .padding(24.dp)
    ) {
        // Header Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            FitMeBackButton(onBack = onNavigateToLogin)

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Already have an account? ",
                    fontSize = 12.sp,
                    color = FitMeColors.TextSecondary
                )
                Text(
                    text = "Login",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = FitMeColors.MagentaPrimary,
                    modifier = Modifier.clickable(onClick = onNavigateToLogin)
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Create Your Account",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = FitMeColors.TextPrimary
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Sign up to start your personalized fitness journey with FitMe",
            fontSize = 13.sp,
            color = FitMeColors.TextSecondary
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Full Name
        FitMeTextField(
            value = fullName,
            onValueChange = { fullName = it },
            placeholder = "Full Name",
            leadingIcon = Icons.Filled.Person
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Email Address
        FitMeTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = "Email Address",
            leadingIcon = Icons.Filled.Email
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Phone Number (Optional)
        FitMeTextField(
            value = phone,
            onValueChange = { phone = it },
            placeholder = "Phone Number (Optional)",
            leadingIcon = Icons.Filled.Phone
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Password
        FitMeTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = "Password",
            leadingIcon = Icons.Filled.Lock,
            isPassword = true
        )

        Text(
            text = "🛡️ Use 8+ characters with letters, numbers and symbols",
            fontSize = 11.sp,
            color = FitMeColors.TextMuted,
            modifier = Modifier.padding(start = 4.dp, top = 4.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Confirm Password
        FitMeTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            placeholder = "Confirm Password",
            leadingIcon = Icons.Filled.Lock,
            isPassword = true
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Date of Birth
        FitMeTextField(
            value = dob,
            onValueChange = { dob = it },
            placeholder = "Date of Birth",
            leadingIcon = Icons.Filled.CalendarToday
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Terms Checkbox
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = agreeTerms,
                onCheckedChange = { agreeTerms = it },
                colors = CheckboxDefaults.colors(checkedColor = FitMeColors.MagentaPrimary)
            )
            Text(
                text = "I agree to the Privacy Policy and Terms of Use",
                fontSize = 12.sp,
                color = FitMeColors.TextSecondary
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Sign Up Gradient Button
        FitMeGradientButton(
            text = "Sign Up",
            onClick = onSignUpSuccess,
            enabled = agreeTerms
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp)
                    .background(FitMeColors.BorderLight)
            )
            Text(
                text = "  or continue with  ",
                fontSize = 12.sp,
                color = FitMeColors.TextMuted
            )
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp)
                    .background(FitMeColors.BorderLight)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            SocialAuthButton(
                iconText = "🌐",
                label = "Google",
                onClick = onSignUpSuccess,
                modifier = Modifier.weight(1f)
            )
            SocialAuthButton(
                iconText = "🍏",
                label = "Apple",
                onClick = onSignUpSuccess,
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "🔒 We respect your privacy. Your information is safe and secure with us.",
            fontSize = 11.sp,
            color = FitMeColors.TextMuted,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))
    }
}
