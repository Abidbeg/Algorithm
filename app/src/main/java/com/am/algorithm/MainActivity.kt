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
import org.w3c.dom.NodeList
import java.util.Stack

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

fun isPalindrome(x: Int): Boolean {
    var result = true
    var data = x.toString()
    var i = 0
    var j = x.toString().length - 1

    while (i <= j) {
        if (data[i] != data[j]) {
            result = false
            break
        }
        i++
        j--
    }
    return result
}

fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.size == 0) return ""
    var res = ""
    for (j in 0 until strs[0].length) {
        val c = strs[0][j]
        for (i in 1 until strs.size) {
            if (j >= strs[i].length || strs[i][j] != c) {
                return res
            }
        }
        res += c
    }
    return res
}

fun isValid(s: String): Boolean {
    val stack = Stack<Char>()
    val range = (1..2)
    s.forEach { c ->
        when {
            stack.empty() -> stack.push(c)
            (c - stack.peek()) in range -> stack.pop()
            else -> stack.push(c)
        }
    }
    return stack.empty()
}

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    val result = ListNode(0)
    var current = result

    var node1 = l1
    var node2 = l2
    while (node1 != null || node2 != null) {
        if (node1 == null) {
            current.next = node2
            break
        }
        if (node2 == null) {
            current.next = node1
            break
        }

        current = current.next!!
    }
    return result?.next
}

fun removeDuplicates(nums: IntArray): Int {
    var count = 0

    for (i in nums.indices) {
        if (i < nums.size - 1 && nums[i] == nums[i + 1]) {
            continue
        }
        nums[count] = nums[i]
        count++
    }

    return count
}

fun removeElement(nums: IntArray, strVal: Int): Int {
    var j = 0
    for (i in nums) {
        if (i != strVal) {
            nums[j++] = i
        }
    }
    return j
}

fun strStr(haystack: String, needle: String): Int {
    if ("" == needle) {
        return 0
    }
    var len1 = haystack.length
    var len2 = needle.length
    var p = 0
    var q = 0
    while (p < len1) {
        if (haystack[p] == needle[q]) {
            if (len2 == 1) {
                return p
            }
            ++p
            ++q
        } else {
            p -= q - 1
            q = 0
        }
        if (q == len2) {
            return p - q
        }

    }
    return -1
}

fun searchInsert(nums: IntArray, target: Int): Int {
    var returnIndex = 0
    for (i in nums.indices) {
        if (nums.contains(target)) {
            if (nums[i] == target) {
                returnIndex = i
            }
        } else {
            if (target > nums[i]) {
                returnIndex++
            }
        }
    }

    return returnIndex
}


fun lengthOfLastWord(s: String): Int {
    var strData = s.trim().split(" ").last()
    var strLen = strData.length
    return strLen
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val strs = intArrayOf(1, 3, 5, 6)
    val targer = 5
    Text(
        text = "hey ${lengthOfLastWord("   fly me   to   the moon  ")}",
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

class ListNode constructor(var value: Int = -1, var next: ListNode? = null) {
    override fun toString(): String {
        return "$value -> ${next.toString()}"
    }

    companion object {
        // a help function to generate a linked list with given values quickly, for test purpose only
        fun quickList(nodes: List<Int>): ListNode {
            val dummy = ListNode()
            nodes.reversed().forEach({
                val temp = ListNode(it)
                temp.next = dummy.next
                dummy.next = temp
            })
            return dummy.next!!
        }
    }
}