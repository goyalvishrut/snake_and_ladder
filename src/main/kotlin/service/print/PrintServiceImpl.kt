package service.print

import java.util.*

class PrintServiceImpl: PrintService {

    override fun addSnacks(start: Int, end: Int) {
        println("Added a snack from start $start to end $end")
    }

    override fun addLadders(start: Int, end: Int) {
        println("Added a ladder from start $start to end $end")
    }

    override fun addPlayers(playerName: String) {
        println("Added a player named $playerName")
    }

    override fun diceRolled(player: String, rollDice: Triple<Int, Int, Int>) {
        println("${player.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }} rolled a ${rollDice.third} and moved from ${rollDice.first} to ${rollDice.second}")
    }

    override fun printWinner(player: String) {
        println("$player wins the game")
    }
}
