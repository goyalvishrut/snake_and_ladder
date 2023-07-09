package controller

import service.game.GameService
import service.print.PrintService
import kotlin.system.exitProcess

class GameController(
    private val printService: PrintService,
    private val gameService: GameService,
) {

    fun addSnakes(start: Int, end: Int) {
        gameService.addSnacks(start, end)
        printService.addSnacks(start, end)
    }

    fun addLadders(start: Int, end: Int) {
        printService.addLadders(start, end)
    }

    fun addPlayers(playerName: String) {
        gameService.addPlayers(playerName)
        printService.addPlayers(playerName)
    }

    fun startGame() {
        val players = gameService.getPlayers()
        while (true) {
            players.keys.forEach { player ->
                val rolledDice = gameService.rollDice(player)
                printService.diceRolled(player, rolledDice)
                if (rolledDice.second == 100) {
                    printService.printWinner(player)
                    exitProcess(1)
                }
            }
        }
    }
}
