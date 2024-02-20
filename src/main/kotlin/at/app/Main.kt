package org.example.at

import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.required
import kotlinx.cli.*

class CommandLineOptions {
    var input by parser.option(ArgType.String, shortName = "i", description = "Der Eingabedateipfad").required()
    var output by parser.option(ArgType.String, shortName = "o", description = "Der Ausgabedateipfad").required()
}

fun main(args: Array<String>) {
    val options = CommandLineOptions()
    val parser = ArgParser("YourApplication")

    try {
        parser.parse(args)

        // Hier können Sie die initiale Konfiguration durchführen oder Aufgaben vor der Schleife erledigen.

        System.out.println("\u001B[32m");
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

        // Schleife für die dauerhafte Ausführung
        while (true) {
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
        parser.printHelp()
    }
}
