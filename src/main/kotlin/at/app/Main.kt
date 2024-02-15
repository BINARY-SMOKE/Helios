package org.example.at

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val name = "Achim"
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    println("""
        |    |  |¯¯¯¯  |      |  /---\    /¯¯¯¯
        |----|  |----  |      | |     |  /____
        |    |  |____  |____  |  \---/   ____/
        ©
        """)

    val (a, b) = readln().split(' ').map(String::toInt)
    println(a + b)
}