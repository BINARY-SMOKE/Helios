package at.app
import java.io.File
import java.io.FileNotFoundException
import java.io.FileWriter
import java.util.*

fun main(args: Array<String>) {
    // Hier können Sie die initiale Konfiguration durchführen oder Aufgaben vor der Schleife erledigen.
    printWelcomeMessage()

    // Schleife für die dauerhafte Ausführung
    while (true) {
        val scanner = Scanner(System.`in`)

        print("Helios$: ")
        val userInput = scanner.nextLine()

        when (userInput) {
            "R" -> reader()
            "M" -> modifyFile()
            else -> println("Command not found")
        }

        Thread.sleep(1000)
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

fun modifyFile() {
    println("Enter the path of the file you want to modify: ")
    val filePath = readLine()
    if (filePath != null) {
        val file = File(filePath)
        if (!file.exists()) {
            println("File '$filePath' not found.")
            return
        }
        println("Enter the new content (terminate with an empty line):")
        val newContent = generateSequence { readLine() }.takeWhile { it.isNotBlank() }.joinToString("\n")
        try {
            FileWriter(file).use { writer ->
                writer.write(newContent)
            }
            println("File '$filePath' has been successfully modified.")
        } catch (e: Exception) {
            println("An error occurred while modifying the file: ${e.message}")
        }
    } else {
        println("Invalid file path.")
    }
}


fun reader() {
    while (true) {
        println("\n1. Display .txt file")

        println("2. Modify")
        println("3. Exit")

        print("Enter your choice (1/2): ")
        val choice = readLine()

        when (choice) {
            "1" -> {
                print("Enter the path of the .txt file: ")
                val filePath = readLine()
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

            "3" -> {
                println("Exiting program. Goodbye!")
                break
            }

            else -> println("Invalid choice. Please enter 1 or 2.")
        }
    }
    println("\u001B[97m")
}
