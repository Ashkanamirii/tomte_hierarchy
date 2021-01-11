import java.io.File
import java.io.InputStream
import java.util.*
import javax.swing.ImageIcon
import javax.swing.JOptionPane
import javax.swing.JOptionPane.showInputDialog
import javax.swing.JOptionPane.showMessageDialog
import kotlin.system.exitProcess


/**
 * Created by Ashkan Amiri
 * Date:  2021-01-11
 * Time:  19:43
 * Project: tomte_hierarchy
 * Copyright: MIT

 */
private val listFromFile = readFile()
private val bossList: MutableList<String> = mutableListOf()
private val childrenList: MutableList<String> = mutableListOf()
private val tomtenImage = ImageIcon(
    "D:\\New folder\\E&F\\fuktionalProgramming\\tomte_hierarchy\\src\\main\\resources\\unnamed.jpg"
)
private var choice = arrayOf("Bosses", "Sub bosses")

fun main() {
    userChoice()
    //findUserRequest("räven",1)?.forEach { e -> println(e) }
    //findUserRequest("Dammråttan", 2).forEach { e -> println(e) }
}

// Recursive method
fun findUserRequest(name: String, req: Int): MutableList<String> {
    listFromFile.forEach { i ->
        val lines = i.split(",")
        val boss = lines[0]
        val children = i.substringAfter(",").split(",")
        if (name.equals(boss, ignoreCase = true) && req == 1) {
            for (s in children) {
                childrenList.add(s)
            }
            return childrenList
        } else if (req == 2) {
            for (s in children) {
                if (s.equals(name, ignoreCase = true)) {
                    bossList.add(0, boss)
                    findUserRequest(boss, req)// upprepa metoden igen tills hitta Tomten
                }
            }
        }
    }
    return bossList
}

fun userChoice() {
    var x = true
    while (x) {
        val userInput = showInputDialog(
            null,
            "Chose one of them that you want to get information about:",
            "SantaClausHierarchy", JOptionPane.QUESTION_MESSAGE, tomtenImage, choice, choice[0]
        )
        if (userInput == null) {
            showMessage(Collections.singletonList("GOOD BYE"), "BYE")
            exitProcess(0)
        }
        if (userInput.equals("Bosses")) {
            val result = findUserRequest(showInput("BOSSES"), 2)
            if (result.size == 0)
                showMessage(
                    Collections.singletonList(
                        """
                            Either you have entered incorrectly
                            or it has no information at our place,\s
                            Please try again"""
                    ), "ERROR"
                )
            else {
                showMessage(result, "BOSSES")
                x = false
            }
        } else if (userInput.equals("Sub bosses")) {
            val result = findUserRequest(showInput("SUB BOSSES"), 1)
            if (result.size == 0)
                showMessage(
                    listOf(
                        "Either you have entered incorrectly " +
                                "or it has no information at our place, Please try again"
                    ), "ERROR"
                )
            else {
                showMessage(result, "SUB BOSSES")
                x = false
            }
        } else {
            exitProcess(0)
        }
    }
}

fun showMessage(userChoice: List<String>, title: String) {
    val output = StringBuilder()
    for (s in userChoice) output.append(s).append("\n")
    showMessageDialog(null, output.toString(), title, JOptionPane.ERROR_MESSAGE)
}

fun showInput(title: String): String {
    var name = showInputDialog(
        null,
        "Enter the name, to get the $title: ",
        title, JOptionPane.INFORMATION_MESSAGE
    )
    return if (name != null && name.isNotBlank() && name.isNotEmpty()) {
        name = name.trim { it <= ' ' }
        name.substring(0, 1).toUpperCase() + name.substring(1)
    } else {
        showMessage(listOf("GOOD BYE"), "BYE")
        exitProcess(0)
    }
}

fun readFile(): MutableList<String> {
    val inputStream: InputStream = File(
        "D:\\New folder\\E&F\\fuktionalProgramming" +
                "\\tomte_hierarchy\\src\\main\\resources\\santaClausHierarchy.txt"
    ).inputStream()
    val lineList = mutableListOf<String>()
    inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it) } }
//    lineList.forEach{println(it)}  Just for test!
//    println(lineList.size) Just for test!
    return lineList
}
