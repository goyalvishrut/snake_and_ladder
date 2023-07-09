package storage

interface LocalStorage {

    fun addSnacks(start: Int, end: Int)

    fun addLadders(start: Int, end: Int)

    fun addPlayers(playerName: String)

    fun getPlayers(): Map<String, Int>

    fun getSnacks(): Map<Int, Int>

    fun getLadders(): Map<Int, Int>

    fun movePlayer(playerName: String, newPosition: Int)
}