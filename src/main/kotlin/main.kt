import pt.isel.canvas.*

const val ARENA_WIDTH = 416
const val ARENA_HEIGHT = 600

fun main () {
    onStart {
        val arena = Canvas(ARENA_WIDTH,ARENA_HEIGHT, BLACK)
        var game = initializeGame()

        arena.onMouseDown {


        }
        arena.onMouseMove {
            game = moveRacket(it.x,game)

        }
        arena.onTimeProgress(10) {
            game = computeNextGame(game)
            drawGame(arena, game)
        }
    }

    onFinish {

    }

}