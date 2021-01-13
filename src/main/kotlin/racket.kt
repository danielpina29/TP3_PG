
data class Racket(val location: Location)

const val RACKET_HEIGHT = 15
const val RACKET_S1 = 10
const val RACKET_S2 = 15
const val RACKET_LOCATION_Y = 550
const val RACKET_SIZE = 60


fun initializeRacket() : Racket{
    return Racket(Location(
        x = (ARENA_WIDTH / 2).toDouble(),
        y = (RACKET_LOCATION_Y).toDouble()),
    )
}

fun moveRacket(itx : Int, game: Game):Game {
    return Game(game.balls,Racket(Location(itx.toDouble(), RACKET_LOCATION_Y.toDouble())), game.brick, game.state)
}



