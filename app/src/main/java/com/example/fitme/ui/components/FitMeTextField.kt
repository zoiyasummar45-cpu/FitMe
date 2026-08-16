package com.example.fitme.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitme.ui.theme.FitMeColors

@Composable
fun FitMeTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    leadingIcon: ImageVector? = null,
    isPassword: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    modifier: Modifier = Modifier
) {
    var passwordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = placeholder,
                color = FitMeColors.TextMuted,
                fontSize = 14.sp
            )
        },
        leadingIcon = leadingIcon?.let {
            {
                Icon(
                    imageVector = it,
                    contentDescription = null,
                    tint = FitMeColors.TextSecondary,
                    modifier = Modifier.size(20.dp)
                )
            }
        },
        trailingIcon = if (isPassword) {
            {
                Icon(
                    imageVector = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                    contentDescription = "Toggle Password",
                    tint = FitMeColors.TextSecondary,
                    modifier = Modifier
                        .size(20.dp)
                        .clickable { passwordVisible = !passwordVisible }
                )
            }
        } else null,
        visualTransformation = if (isPassword && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = keyboardOptions,
        singleLine = true,
        shape = RoundedCornerShape(16.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = FitMeColors.MagentaPrimary,
            unfocusedBorderColor = FitMeColors.BorderLight,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White
        ),
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
    )
}

@Composable
fun MetricPicker(
    label: String,
    value: Int,
    unit: String,
    onValueChange: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = label,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = FitMeColors.TextPrimary
        )
        Spacer(modifier = Modifier.height(6.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)
                .border(1.dp, FitMeColors.BorderLight, RoundedCornerShape(16.dp))
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(FitMeColors.BackgroundLight)
                    .clickable { if (value > 1) onValueChange(value - 1) },
                contentAlignment = Alignment.Center
            ) {
                Text("-", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = FitMeColors.MagentaPrimary)
            }

            Row(verticalAlignment = Alignment.Bottom) {
                Text(
                    text = "$value",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = FitMeColors.TextPrimary
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = unit,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    color = FitMeColors.TextSecondary,
                    modifier = Modifier.padding(bottom = 2.dp)
                )
            }

            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(FitMeColors.BackgroundLight)
                    .clickable { onValueChange(value + 1) },
                contentAlignment = Alignment.Center
            ) {
                Text("+", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = FitMeColors.MagentaPrimary)
            }
        }
    }
}
