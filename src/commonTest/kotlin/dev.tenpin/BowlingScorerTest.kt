package dev.tenpin

import kotlin.test.Test
import kotlin.test.assertEquals

internal class BowlingScorerTest {
    @Test
    fun scoresDigits() {
        assertEquals(1, BowlingScorer.score("1"))
        assertEquals(2, BowlingScorer.score("2"))
        assertEquals(3, BowlingScorer.score("3"))
        assertEquals(4, BowlingScorer.score("4"))
        assertEquals(5, BowlingScorer.score("5"))
        assertEquals(6, BowlingScorer.score("6"))
        assertEquals(7, BowlingScorer.score("7"))
        assertEquals(8, BowlingScorer.score("8"))
        assertEquals(9, BowlingScorer.score("9"))
    }
    @Test
    fun scoresDashAsZero() {
        assertEquals(0, BowlingScorer.score("-"))
    }
    @Test
    fun scoresXAsTen() {
        assertEquals(10, BowlingScorer.score("X"))
    }
    @Test
    fun scoresSpareAsTen() {
        assertEquals(10, BowlingScorer.score("-/"))
        assertEquals(10, BowlingScorer.score("1/"))
        assertEquals(10, BowlingScorer.score("2/"))
        assertEquals(10, BowlingScorer.score("3/"))
        assertEquals(10, BowlingScorer.score("4/"))
        assertEquals(10, BowlingScorer.score("5/"))
        assertEquals(10, BowlingScorer.score("6/"))
        assertEquals(10, BowlingScorer.score("7/"))
        assertEquals(10, BowlingScorer.score("8/"))
        assertEquals(10, BowlingScorer.score("9/"))
    }
    @Test
    fun addsNextBallOntoSpare() {
        assertEquals(10, BowlingScorer.score("-/-"))
        assertEquals(12, BowlingScorer.score("1/1"))
        assertEquals(14, BowlingScorer.score("2/2"))
        assertEquals(16, BowlingScorer.score("3/3"))
        assertEquals(18, BowlingScorer.score("4/4"))
        assertEquals(20, BowlingScorer.score("5/5"))
        assertEquals(22, BowlingScorer.score("6/6"))
        assertEquals(24, BowlingScorer.score("7/7"))
        assertEquals(26, BowlingScorer.score("8/8"))
        assertEquals(28, BowlingScorer.score("9/9"))
        assertEquals(30, BowlingScorer.score("9/X"))
    }
    @Test
    fun addsNextTwoBallsOntoStrike() {
        assertEquals(10, BowlingScorer.score("X--"))
        assertEquals(12, BowlingScorer.score("X1-"))
        assertEquals(14, BowlingScorer.score("X11"))
        assertEquals(18, BowlingScorer.score("X22"))
        assertEquals(22, BowlingScorer.score("X33"))
        assertEquals(26, BowlingScorer.score("X44"))
        assertEquals(28, BowlingScorer.score("X54"))
        assertEquals(30, BowlingScorer.score("XX-"))
        assertEquals(30, BowlingScorer.score("X9/"))
        assertEquals(28, BowlingScorer.score("X-9"))
        assertEquals(60, BowlingScorer.score("XXX"))
    }
    @Test
    fun scoresPerfectGame() {
        assertEquals(300, BowlingScorer.score("XXXXXXXXXXXX"))
    }
    @Test
    fun scoresAllSpares() {
        assertEquals(110, BowlingScorer.score("1/1/1/1/1/1/1/1/1/1/1"))
        assertEquals(120, BowlingScorer.score("2/2/2/2/2/2/2/2/2/2/2"))
        assertEquals(130, BowlingScorer.score("3/3/3/3/3/3/3/3/3/3/3"))
        assertEquals(140, BowlingScorer.score("4/4/4/4/4/4/4/4/4/4/4"))
        assertEquals(150, BowlingScorer.score("5/5/5/5/5/5/5/5/5/5/5"))
        assertEquals(160, BowlingScorer.score("6/6/6/6/6/6/6/6/6/6/6"))
        assertEquals(170, BowlingScorer.score("7/7/7/7/7/7/7/7/7/7/7"))
        assertEquals(180, BowlingScorer.score("8/8/8/8/8/8/8/8/8/8/8"))
        assertEquals(190, BowlingScorer.score("9/9/9/9/9/9/9/9/9/9/9"))
    }
    @Test
    fun scoresMikesSecondHighestGame() {
        assertEquals(241, BowlingScorer.score("XXX81XXX9/XXX6"))
    }
}