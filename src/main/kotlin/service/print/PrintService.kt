package service.print

interface PrintService {

    fun addSnacks(start: Int, end: Int)

    fun addLadders(start: Int, end: Int)

    fun addPlayers(playerName: String)

    fun diceRolled(player: String, rollDice: Triple<Int, Int, Int>)

    fun printWinner(player: String)
}
