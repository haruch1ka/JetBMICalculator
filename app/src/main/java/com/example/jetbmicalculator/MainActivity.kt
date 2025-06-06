package com.example.jetbmicalculator

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetbmicalculator.ui.theme.JetBMICalculatorTheme

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetBMICalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .padding(20.dp)
                    ) {
                        Text(
                            text = "BMI計算アプリ",
                            fontSize = 26.sp,
                            fontWeight = FontWeight.ExtraBold,
                        )
                        Spacer(modifier = Modifier.padding(20.dp))

                        //身長
                        PinkLabeledTextField(
                            value = "",
                            onValueChange = { /*TODO*/ },
                            label = "身長(cm)",
                            placeholder = "170"
                        )
                        Spacer(modifier = Modifier.padding(10.dp))

                        //体重
                        PinkLabeledTextField(
                            value = "",
                            onValueChange = { /*TODO*/ },
                            label = "体重(kg)",
                            placeholder = "65"
                        )
                        Spacer(modifier = Modifier.padding(10.dp))

                        //BMI計算ボタン
                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFF85F6A)),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "BMIを計算",
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Spacer(modifier = Modifier.padding(20.dp))

                        //BMIの結果
                        Text(
                            text = "あなたのBMIは22.5です",
                            color = Color.Gray,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,

                            )

                    }
                }
            }
        }
    }
}

@Composable
fun PinkLabeledTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
) {
    Column() {
        Text(
            text = label,
            color = Color(0xFFF85F6A),
            fontWeight = FontWeight.Bold,
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChange,
            placeholder = { Text(text = placeholder, color = Color.Gray) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
            )
        )

    }
}