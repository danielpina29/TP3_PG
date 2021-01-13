data class Game(val balls : List<Ball>, val racket : Racket, val brick : List<Brick>, val state : GameState )

enum class GameState { NOT_STARTED, STARTED }

fun initializeGame() : Game {
    val emptyListBalls : List<Ball> = listOf()
    val newRacket : Racket = initializeRacket()
    val newBricks : List<Brick> = levelBricks

    return  Game(emptyListBalls, newRacket, newBricks, GameState.NOT_STARTED)
}

fun computeNextBalls(game: Game) : List<Ball> {
    val newballs = game.balls.map { moveBall(it) }
     return newballs
}


fun computeNextRacket(game: Game) : Racket {
    fun detectRacketLeftCollision(game: Game) : Boolean{
        return game.racket.location.x <= RACKET_SIZE / 2
    }
    fun detectRacketRightCollision(game: Game) : Boolean{
        return game.racket.location.x >= ARENA_WIDTH - RACKET_SIZE /2
    }
   return when {
       detectRacketLeftCollision(game)-> Racket(Location((RACKET_SIZE / 2).toDouble(), game.racket.location.y))
       detectRacketRightCollision(game) -> Racket(Location((ARENA_WIDTH - RACKET_SIZE /2).toDouble(), game.racket.location.y))
       else -> game.racket
    }
}

fun computeNextGame(game: Game) : Game =
    Game(computeNextBalls(game), computeNextRacket(game), game.brick, game.state)

