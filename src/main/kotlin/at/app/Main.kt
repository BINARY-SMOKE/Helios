package org.example.at

import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.required
import java.util.*

class CommandLineOptions(parser: ArgParser) {
    val input by parser.option(ArgType.String, shortName = "i", description = "Der Eingabedateipfad").required()
    val output by parser.option(ArgType.String, shortName = "o", description = "Der Ausgabedateipfad").required()
}

fun main(args: Array<String>) {
    val parser = ArgParser("YourApplication")
    val options = CommandLineOptions(parser)
    printWelcomeMessage()
    try {
        parser.parse(args)

        // Hier können Sie die initiale Konfiguration durchführen oder Aufgaben vor der Schleife erledigen.

        // Schleife für die dauerhafte Ausführung
        while (true) {
            val scanner = Scanner(System.`in`)

            print("Geben Sie etwas ein: ")
            val userInput = scanner.nextLine()

            println("Sie haben eingegeben: $userInput")

            // Hier können Sie die wiederholende Funktionalität Ihrer Anwendung implementieren.
            // Zum Beispiel: Daten verarbeiten, auf Benutzereingaben warten, usw.

            println("Eingabedateipfad: ${options.input}")
            println("Ausgabedateipfad: ${options.output ?: "Nicht angegeben"}")

            // Kurze Pause, um die CPU nicht zu belasten (kann je nach Anforderungen angepasst werden)
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
    println("\u001B[97m")
}