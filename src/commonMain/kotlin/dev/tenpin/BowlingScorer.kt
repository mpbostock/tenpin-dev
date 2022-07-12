package dev.tenpin


object BowlingScorer {
    const val MAX_FRAME_SCORE = 10
    fun score(game: String): Int {
        var score = 0
        var frameCount = 0
        game.forEachIndexed { index, c ->
            if (index < 20) score += parseThrow(c)
            frameCount += if(index % 2 != 0 || c == 'X') 1 else 0
            when (c) {
                'X' -> {
                    if (frameCount <= 9) {
                        val firstAddedThrow = parseThrow(game.getOrNull(index + 1))
                        score += firstAddedThrow
                        val secondAddedThrow = game.getOrNull(index + 2)
                        score += if (secondAddedThrow == '/') (MAX_FRAME_SCORE - firstAddedThrow) else parseThrow(
                            secondAddedThrow
                        )
                    }
                }
                '/' -> {
                    score += (MAX_FRAME_SCORE - parseThrow(game[index - 1]))
                    score += parseThrow(game.getOrNull(index + 1))
                }
            }
        }
        return score
    }

    private fun parseThrow(c: Char?): Int {
        return c?.let {
            when {
                it.isDigit() -> it.digitToInt()
                it == 'X' -> MAX_FRAME_SCORE
                else -> 0
            }
        } ?: 0
    }
}