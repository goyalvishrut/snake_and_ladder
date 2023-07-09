package storage

class LocalStorageImpl: LocalStorage {

    private val snakes: MutableMap<Int, Int> = mutableMapOf()
    private val ladders: MutableMap<Int, Int> = mutableMapOf()
    private val players: MutableMap<String, Int> = mutableMapOf()

    override fun addSnacks(start: Int, end: Int) {
        snakes[start] = end
    }

    override fun addLadders(start: Int, end: Int) {
        ladders[start] = end
    }

    override fun addPlayers(playerName: String) {
        players[playerName] = 0
    }

    override fun getPlayers(): Map<String, Int> {
        return players.toMap()
    }

    override fun getSnacks(): Map<Int, Int> {
        return snakes.toMap()
    }

    override fun getLadders(): Map<Int, Int> {
        return ladders.toMap()
    }

    override fun movePlayer(playerName: String, newPosition: Int) {
        players[playerName] = newPosition
    }
}