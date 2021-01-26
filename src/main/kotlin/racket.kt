
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

fun moveRacket(itx : Int, game: Game):Racket {

    fun detectRacketLeftCollision() =
        itx <= RACKET_SIZE / 2

    fun detectRacketRightCollision() =
      itx >= ARENA_WIDTH - RACKET_SIZE /2

    return when {
        detectRacketLeftCollision()-> Racket(Location((RACKET_SIZE / 2).toDouble(), game.racket.location.y))
        detectRacketRightCollision() -> Racket(Location((ARENA_WIDTH - RACKET_SIZE /2).toDouble(), game.racket.location.y))
        else -> Racket(Location(itx.toDouble(), RACKET_LOCATION_Y.toDouble()))
    }

}



