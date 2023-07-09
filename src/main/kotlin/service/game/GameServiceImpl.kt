package service.game

import storage.LocalStorage

class GameServiceImpl(private val localStorage: LocalStorage): GameService {

    override fun addSnacks(start: Int, end: Int) {
        localStorage.addSnacks(start, end)
    }

    override fun addLadders(start: Int, end: Int) {
        localStorage.addLadders(start, end)
    }

    override fun addPlayers(playerName: String) {
        localStorage.addPlayers(playerName)
    }

    override fun getPlayers(): Map<String, Int> {
        return localStorage.getPlayers()
    }

    override fun rollDice(playerName: String): Triple<Int, Int, Int> {
        val diceValue = (1 .. 6).random()
        val playerPosition = localStorage.getPlayers()[playerName]!!
        val snacks = localStorage.getSnacks()
        val ladders = localStorage.getLadders()
        val newPosition = if ((playerPosition + diceValue) in snacks) {
            snacks[playerPosition + diceValue]
        } else if ((playerPosition + diceValue) in ladders) {
            ladders[playerPosition + diceValue]
        } else {
            playerPosition + diceValue
        }
        return if (newPosition!! <= 100) {
            localStorage.movePlayer(playerName, newPosition)
            Triple(playerPosition, newPosition, diceValue)
        } else {
            Triple(playerPosition, playerPosition, diceValue)
        }
    }
}
