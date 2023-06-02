import android.graphics.fonts.FontStyle
import android.os.Build
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculator.ui.theme.CalculatorTheme

@androidx.compose.runtime.Composable
fun NumberButton(
    number: String,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(1.dp),
        border = BorderStroke(1.2.dp, color = Color.Gray)
    ) {
        Text(text = "$number")
    }
}

@Composable
fun OperationButton(
    operator: String,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(0),
        border = BorderStroke(1.dp, color = Color.Black),
    ) {
        Text("$operator")
    }
}

@Composable
fun TextField(
    value: String, onvalueChange: Unit) {
    
}


@Preview
@Composable
fun CalculatorPreview() {
    CalculatorTheme {
        Column() {
            OperationButton(operator = "+")
            OperationButton(operator = "-")
            OperationButton(operator = "/")
            OperationButton(operator = "*")
            OperationButton(operator = "AC")
            NumberButton(number = "1")
            NumberButton(number = "2")
            NumberButton(number = "3")
            NumberButton(number = "4")
            NumberButton(number = "5")
            NumberButton(number = "6")
            NumberButton(number = "7")
            NumberButton(number = "8")
            NumberButton(number = "9")


        }
    }
}