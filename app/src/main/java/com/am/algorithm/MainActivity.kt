package com.am.algorithm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.am.algorithm.ui.theme.AlgorithmTheme
import org.w3c.dom.Node

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlgorithmTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    var resultArray = IntArray(2)
    for (i in 0 until nums.size) {
        var strCalc = 0
        for (j in i + 1 until nums.size) {
            strCalc = nums[i] + nums[j]
            if (strCalc == target) {
                resultArray[0] = i
                resultArray[1] = j
                break
            }
        }
    }
    return resultArray
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val nums: IntArray = intArrayOf(3, 3)
    val targer = 6
    Text(
        text = "Hello ${twoSum(nums, targer)}",
        modifier = modifier
    )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AlgorithmTheme {
        Greeting("Android")
    }
}