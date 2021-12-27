package com.example.textjetpack

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.textjetpack.ui.theme.TextJetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextJetpackTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Surface {
                        CustomText(
                            Padding = 17.dp,
                            Width = 150.dp,
                            Color = Color.Black,
                            textColor = Color.Blue
                        )
                    }
                    Surface {
                        CustomTextTwo()
                    }
                    Surface {
                        CustomTextThree()
                    }
                }
            }
        }
    }
}
//Custom Text
@Composable
fun CustomText(Padding:Dp, Width:Dp, Color:Color, textColor:Color){
    Text(text = stringResource(id = R.string.HelloWorld),
        modifier = Modifier
            //Background
            .background(Color)
            //Padding
            .padding(Padding)
            //Width
            .width(Width),
        //Color Text
        color = textColor,
        //Text Size
        fontSize = 44.sp,
        //Text Style
        fontStyle = FontStyle.Normal,
        //Text Weight
        fontWeight = FontWeight.Bold,
        //Text Align
        textAlign = TextAlign.Center
    )
}

//Custom Text (With Style)
@Composable
fun CustomTextTwo(){
    Text(
        buildAnnotatedString {
            withStyle(style = ParagraphStyle(textAlign = TextAlign.Center)){
                withStyle(style = SpanStyle(
                    color = Color.Blue,
                    fontSize = 20.sp
                )){
                    append("A")
                }
                append("B")
                append("C")
                append("D")
            }
        }, modifier = Modifier
            .width(150.dp)
            .background(Color.DarkGray)
    )
}

//Custom Text Repetition
@Composable
fun CustomTextThree(){
    Text(text = stringResource(id = R.string.HelloWorld)
        .repeat(20),
        maxLines = 2,
        overflow = TextOverflow.Ellipsis)
}

//Custom Text Selection
@Composable
fun CustomTextFour(){
    SelectionContainer {
        Column{
            Text(text = "Hello World!")
            DisableSelection {
                Text(text = "Hello World!")
            }
            Text(text = "Hello World!")
        }
    }
}

//Super Script Text
@Composable
fun SuperScriptText(normalText:String, superText:String,
normalTextSize: TextUnit = MaterialTheme.typography.subtitle1.fontSize,
superTextWeight:FontWeight = FontWeight.Normal){
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(
                fontSize = normalTextSize
            )){
                append(normalText)
            }
            withStyle(style = SpanStyle(
                fontSize = MaterialTheme.typography.overline.fontSize,
                fontWeight = superTextWeight,
                baselineShift = BaselineShift.Subscript
            )
            ){
                append(superText)
            }
        }
    )
}

@Preview(showBackground = true)

@Composable
fun DefaultPreview() {
    TextJetpackTheme {
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
        }
        SuperScriptText(normalText = "Hello World!", superText = "Welcome To Jetpack")
    }
}