fun detectBallLeftS1(ball: Ball, racket: Racket): Boolean =
        ball.current.x in (racket.location.x - RACKET_HALF_SIZE)..((racket.location.x - RACKET_HALF_SIZE) + RACKET_S1)

fun detectBallLeftS2(ball: Ball, racket: Racket): Boolean =
        ball.current.x in ((racket.location.x - RACKET_HALF_SIZE) + RACKET_S1)..((racket.location.x - RACKET_HALF_SIZE) + RACKET_S1 + RACKET_S2)

fun detectBallRightS1(ball: Ball, racket: Racket): Boolean =
        ball.current.x in (racket.location.x + RACKET_SM / 2 + RACKET_S2)..(racket.location.x + RACKET_HALF_SIZE)

fun detectBallRightS2(ball: Ball, racket: Racket): Boolean =
        ball.current.x in (racket.location.x + RACKET_SM / 2)..(racket.location.x + RACKET_HALF_SIZE - RACKET_S1)

fun detectBallMiddleSector(ball: Ball, racket: Racket): Boolean =
        ball.current.x in (racket.location.x - RACKET_SM / 2)..(racket.location.x + RACKET_SM / 2)



