package service.game

interface GameService {

    fun addSnacks(start: Int, end: Int)

    fun addLadders(start: Int, end: Int)

    fun addPlayers(playerName: String)

    fun getPlayers(): Map<String, Int>

    fun rollDice(playerName: String): Triple<Int, Int, Int>
}
