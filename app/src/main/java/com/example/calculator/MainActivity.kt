package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.CalculatorTheme
import com.example.calculator.ui.theme.Orange
import net.objecthunter.exp4j.ExpressionBuilder
import java.math.RoundingMode
import java.text.DecimalFormat


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Calculator()
                }
            }
        }
    }
}

@Composable
fun Calculator() {
    val display = DecimalFormat("#.###")
    display.roundingMode = RoundingMode.DOWN

    val answer = remember {
        mutableStateOf(0.0)
    }

    val operation = remember {
        mutableStateOf("0")
    }

    val buttonModifier = Modifier
        .padding(6.dp)
        .size(80.dp)
        .clip(CircleShape)

    //Button Background Colors
    val numBtnColor = ButtonDefaults.buttonColors(Color.Black)
    val operationBtnColor = ButtonDefaults.buttonColors(Color.DarkGray)
    val equalBtnColor = ButtonDefaults.buttonColors(Color.Gray)

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = operation.value,
            maxLines = 2,
            style = TextStyle(
                fontSize = 60.sp,
                textAlign = TextAlign.End
            ),
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
                .padding(top = 10.dp, start = 20.dp, bottom = 10.dp, end = 20.dp)
        )
        Box(
            contentAlignment = Alignment.CenterStart,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.5f)
                .padding(top = 10.dp, start = 20.dp, bottom = 10.dp, end = 20.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp)
            ) {
                Text(
                    text = display.format(answer.value),
                    maxLines = 1 ,
                    style = TextStyle(fontSize = 50.sp)
                )
            }//Row
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .weight(1.5f)
                .fillMaxWidth()
        ) {
            Button(
                onClick = {
                    operation.value = operation.value
                        .replace(Regex("[0-9,+*/.-]"), "")
                        .plus(0)
                    answer.value = 0.0
                },
                modifier = buttonModifier,
                colors = ButtonDefaults.buttonColors(Color.DarkGray)
            ) {
                Text(
                    text = "AC",
                    color = Color.White,
                    fontSize = 20.sp
                )
            }
            Button(
                onClick = { operation.value = operation.value.dropLast(1) },
                modifier = buttonModifier,
                colors = ButtonDefaults.buttonColors(Color.DarkGray)
            ) {
                Text(
                    text = "<-",
                    color = Color.White,
                    fontSize = 20.sp
                )
            }
            Button(
                onClick = {
                    val currentValue = operation.value.toDouble()
                    val percentage = currentValue / 100
                    operation.value = percentage.toString()
                },
                modifier = buttonModifier,
                colors = ButtonDefaults.buttonColors(Color.DarkGray)
            ) {
                Text(
                    text = "%",
                    color = Color.White,
                    fontSize = 20.sp
                )
            }
            Button(
                onClick = {
                    operation.value = operation.value.replace(Regex("[0-9,+*/.-]"), "").plus(0)
                },
                modifier = buttonModifier,
                colors = operationBtnColor
            ) {
                Text(
                    text = "C",
                    color = Color.Yellow,
                    fontSize = 20.sp
                )
            }
        }//Row
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .weight(1.5f)
                .fillMaxWidth()
        ) {
            Button(
                onClick = { operation.value = operation.value.plus("7") },
                modifier = buttonModifier,
                colors = numBtnColor
            ) {
                Text(
                    text = "7",
                    color = Color.White,
                    fontSize = 20.sp
                )
            }
            Button(
                onClick = { operation.value = operation.value.plus("8") },
                modifier = buttonModifier,
                colors = numBtnColor
            ) {
                Text(
                    text = "8",
                    color = Color.White,
                    fontSize = 20.sp
                )
            }
            Button(
                onClick = { operation.value = operation.value.plus("9") },
                modifier = buttonModifier,
                colors = numBtnColor
            ) {
                Text(
                    text = "9",
                    color = Color.White,
                    fontSize = 20.sp
                )
            }
            Button(
                onClick = { operation.value = operation.value.plus("/") },
                modifier = buttonModifier,
                colors = operationBtnColor,

                ) {
                Text(
                    text = "/",
                    color = Color(0xFFFF6B00),
                    fontSize = 20.sp
                )
            }
        }//Row
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .weight(1.5f)
                .fillMaxWidth()
        ) {
            Button(
                onClick = { operation.value = operation.value.plus("4") },
                modifier = buttonModifier,
                colors = numBtnColor
            ) {
                Text(
                    text = "4",
                    fontSize = 20.sp,
                    color = Color.White
                )
            }//TextRow
            Button(
                onClick = { operation.value = operation.value.plus("5") },
                modifier = buttonModifier,
                colors = numBtnColor
            ) {
                Text(
                    text = "5",
                    fontSize = 20.sp,
                    color = Color.White
                )
            }//TextRow
            Button(
                onClick = { operation.value = operation.value.plus("6") },
                modifier = buttonModifier,
                colors = numBtnColor
            ) {
                Text(
                    text = "6",
                    fontSize = 20.sp,
                    color = Color.White
                )
            }//TextRow
            Button(
                onClick = { operation.value = operation.value.plus("*") },
                modifier = buttonModifier,
                colors = operationBtnColor
            ) {
                Text(
                    text = "X",
                    fontSize = 20.sp,
                    color = Color(0xFFFF6B00)
                )
            }//TextRow
        }//Row
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .weight(1.5f)
                .fillMaxWidth()
        ) {
            Button(
                onClick = { operation.value = operation.value.plus("1") },
                modifier = buttonModifier,
                colors = numBtnColor
            ) {
                Text(
                    text = "1",
                    fontSize = 20.sp,
                    color = Color.White
                )
            }//TextRow
            Button(
                onClick = { operation.value = operation.value.plus("2") },
                modifier = buttonModifier,
                colors = numBtnColor
            ) {
                Text(
                    text = "2",
                    fontSize = 20.sp,
                    color = Color.White
                )
            }//TextRow
            Button(
                onClick = { operation.value = operation.value.plus("3") },
                modifier = buttonModifier,
                colors = numBtnColor
            ) {
                Text(
                    text = "3",
                    fontSize = 20.sp,
                    color = Color.White
                )
            }//TextRow
            Button(
                onClick = { operation.value = operation.value.plus("-") },
                modifier = buttonModifier,
                colors = operationBtnColor
            ) {
                Text(
                    text = "-",
                    fontSize = 30.sp,
                    color = Color(0xFFFF6B00)
                )
            }//TextRow
        }//RowScope
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .weight(1.5f)
                .fillMaxWidth()
        ) {
            Button(
                onClick = { operation.value = operation.value.plus("0") },
                modifier = buttonModifier,
                colors = numBtnColor
            ) {
                Text(
                    text = "0",
                    fontSize = 20.sp,
                    color = Color.White
                )
            }//TextRow
            Button(
                onClick = { operation.value = operation.value.plus(".") },
                modifier = buttonModifier,
                colors = numBtnColor
            ) {
                Text(
                    text = ".",
                    fontSize = 20.sp,
                    color = Color.White
                )
            }//TextRow
            Button(
                onClick = { answer.value = ExpressionBuilder(operation.value).build().evaluate() },
                modifier = buttonModifier,
                colors = equalBtnColor
            ) {
                Text(
                    text = "=",
                    fontSize = 20.sp,
                    color = Color.White
                )
            }//TextRow
            Button(
                onClick = { operation.value = operation.value.plus("+") },
                modifier = buttonModifier,
                colors = operationBtnColor
            ) {
                Text(
                    text = "+",
                    fontSize = 20.sp,
                    color = Color(0xFFFF6B00)
                )
            }//TextRow
        }//RowScope


    }


}


@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {

    Calculator()

}