import pt.isel.canvas.*

const val ARENA_WIDTH = 416
const val ARENA_HEIGHT = 600

fun main () {
    onStart {
        val arena = Canvas(ARENA_WIDTH,ARENA_HEIGHT, BLACK)
        var game = initializeGame()

        arena.onMouseDown {
            game = game.startGame(game)
        }
        arena.onMouseMove {
            game = Game(game.ball,game.lifes, moveRacket(it.x,game), game.bricks, game.state)
        }


        arena.onTimeProgress(10) {

            game = computeNextLifesAndBall(game)
            game = computeNextGame(game)
            drawGame(arena, game)
            println(game.state)

            if (finishGame(game))
                arena.close()






        }
    }

    onFinish {

    }

}