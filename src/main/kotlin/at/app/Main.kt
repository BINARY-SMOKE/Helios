package org.example.at

import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.required
import java.io.File
import java.io.FileNotFoundException
import java.util.*

fun main(args: Array<String>) {

    try {

        // Hier können Sie die initiale Konfiguration durchführen oder Aufgaben vor der Schleife erledigen.
        printWelcomeMessage()

        // Schleife für die dauerhafte Ausführung
        while (true) {
            val scanner = Scanner(System.`in`)

            print("Helios$: ")
            val userInput = scanner.nextLine()

            if (userInput == "R") {
                reader()
            } else {
                println("Command not found")
            }

            Thread.sleep(1000)
        }
    } catch (e: Exception) {
        // Wenn ein Fehler bei der Verarbeitung der Argumente auftritt, zeigen Sie die Fehlermeldung und die Verwendung an.
        System.err.println(e.message)
        
    }
}

fun printWelcomeMessage() {
    print("\u001B[32m")
    println("""
        |    |  |¯¯¯¯  |      |  /¯¯¯\    /¯¯¯¯
        |----|  |----  |      | |     |  /____
        |    |  |____  |____  |  \___/   ____/  ©     
      /¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯/
     /       WELCOME FRIEND -------------------------------->  FOR MENUE PRESS ...................... M
    /_____________________________________________________/    FOR MENUE PRESS ...................... M
                                                               FOR MENUE PRESS ...................... M
                                                               FOR MENUE PRESS ...................... M
                                                               FOR MENUE PRESS ...................... M
                                                               FOR MENUE PRESS ...................... M
                                                               FOR MENUE PRESS ...................... M
                                                               FOR MENUE PRESS ...................... M
                                                               FOR MENUE PRESS ...................... M
                                                               FOR MENUE PRESS ...................... M
                                                               FOR MENUE PRESS ...................... M
                                                               FOR MENUE PRESS ...................... M
    """)
    println("\u001B[37m")
}

fun displayTextFile(filePath: String) {
    try {
        val file = File(filePath)
        val content = file.readText()
        println(content)
    } catch (e: FileNotFoundException) {
        println("Error: File '$filePath' not found.")
    } catch (e: Exception) {
        println("An error occurred: ${e.message}")
    }
}

fun reader() {
    while (true) {
        println("\n1. Display .txt file")
        println("2. Exit")

        print("Enter your choice (1/2): ")
        val choice = readLine()

        when (choice) {
            "1" -> {
                print("Enter the path of the .txt file: ")
                val filePath = readlnOrNull()
                println("Attempting to read file: $filePath")
                if (filePath != null) {
                    displayTextFile(filePath)
                } else {
                    println("Invalid file path.")
                }
            }

            "2" -> {
                println("Exiting program. Goodbye!")
                break
            }

            else -> println("Invalid choice. Please enter 1 or 2.")
        }
    }
}