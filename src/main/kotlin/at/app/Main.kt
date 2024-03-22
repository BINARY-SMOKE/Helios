package at.app
import java.io.File
import java.io.FileNotFoundException
import java.io.FileWriter
import java.io.RandomAccessFile
import java.nio.charset.Charset
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.*

fun main(args: Array<String>) {

    printWelcomeMessage()


    while (true) {
        val scanner = Scanner(System.`in`)

        print("Helios$: ")
        val userInput = scanner.nextLine()

        when (userInput) {
            "R" -> reader()
            "M" -> modifyFile()
            "S" -> {
                print("Enter the keyword to search for: ")
                val keyword = readLine()
                print("Enter the directory, if you don't specify C: will be searched: ")
                val directory = readLine()
                if (keyword != null) {
                    searchInDirectory(keyword, directory ?: "")
                } else {
                    println("Invalid keyword.")
                }
            }
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
     /       WELCOME FRIEND -------------------------------->  FOR READER PRESS ..................... R
    /_____________________________________________________/    FOR MODIFY PRESS ..................... M
                                                               FOR SEARCH PRESS ..................... S
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
    println("\u001B[97m")
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
        println("\n1. Display file")

        println("2. Modify")
        println("3. Exit")

        print("Enter your choice (1/2): ")
        val choice = readLine()

        when (choice) {
            "1" -> {
                print("Enter the path of the file: ")
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

fun searchFiles(directory: File, keyword: String): List<File> {
    val foundFiles = mutableListOf<File>()

    directory.walkTopDown().forEach { file ->
        if (file.isFile) {
            try {
                val randomAccessFile = RandomAccessFile(file, "r")
                val bytes = ByteArray(randomAccessFile.length().toInt())
                randomAccessFile.readFully(bytes)
                val content = String(bytes, Charset.defaultCharset())

                if (content.contains(keyword)) {
                    foundFiles.add(file)
                }

                randomAccessFile.close()
            } catch (e: Exception) {
                println("File: { ${file.absolutePath}  } could not be read because: { ${e.message} }")
            }
        }
    }

    return foundFiles
}

fun searchInDirectory(keyword: String, directory: String)
{
    val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")

    val startTime = LocalTime.now()
    val formattedTimeStart = startTime.format(formatter)

    println("Start: { $formattedTimeStart }")

    val dllDirectory: File

    if(directory.equals("")) {
        dllDirectory = File("C:\\")
    } else {
        dllDirectory = File(directory)
    }

    val result = searchFiles(dllDirectory, keyword)

    if (result.isNotEmpty()) {
        println("Files found:")
        result.forEach { println(it.absolutePath) }
    } else {
        println("No files with this keyword found.")
    }

    val endTime = LocalTime.now()
    val formattedTimeEnd = endTime.format(formatter)

    println("End: $formattedTimeEnd")
}