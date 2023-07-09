import controller.GameController
import service.game.GameServiceImpl
import service.print.PrintServiceImpl
import storage.LocalStorageImpl

private val localStorage = LocalStorageImpl()
private val printService = PrintServiceImpl()
private val gameService = GameServiceImpl(localStorage = localStorage)
private val gameController = GameController(printService = printService, gameService = gameService)

/*
https://workat.tech/machine-coding/practice/snake-and-ladder-problem-zgtac9lxwntg
 */
fun main() {
    testInput()

    val snakes = readln()
    val snakesLines = generateSequence(readlnOrNull()) { readlnOrNull() }
    snakesLines.take(snakes.toInt()).forEach { input ->
        val (start, end) = input.split(" ").map { it.toInt() }
        gameController.addSnakes(start, end)
    }

    val ladders = readln()
    val laddersLines = generateSequence(readlnOrNull()) { readlnOrNull() }
    laddersLines.take(ladders.toInt()).forEach { input ->
        val (start, end) = input.split(" ").map { it.toInt() }
        gameController.addLadders(start, end)
    }

    val players = readln()
    val playersLines = generateSequence(readlnOrNull()) { readlnOrNull() }
    playersLines.take(players.toInt()).forEach { gameController.addPlayers(it) }

    gameController.startGame()
}

fun testInput() {
    val snakes = listOf(
        "62 5",
        "33 6",
        "49 9",
        "88 16",
        "41 20",
        "56 53",
        "98 64",
        "93 73",
        "95 75"
    )
    val ladders = listOf(
        "2 37",
        "27 46",
        "10 32",
        "51 68",
        "61 79",
        "65 84",
        "71 91",
        "81 100"
    )
    val players = listOf("Gaurav", "Sagar")

    ladders.forEach { ladder ->
        val (start, end) = ladder.split(" ").map { it.toInt() }
        gameController.addLadders(start, end)
    }
    snakes.forEach { snake ->
        val (start, end) = snake.split(" ").map { it.toInt() }
        gameController.addSnakes(start, end)
    }
    players.forEach { gameController.addPlayers(it) }

    gameController.startGame()
}