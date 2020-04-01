package ru.job4j;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopBlackTest {
    @Test
    public void checkPositionIsCorrect() {
        Cell expected = Cell.findBy(1,0);
        BishopBlack bishop = new BishopBlack(expected);
        assertThat(bishop.position(), is(expected));
    }

    @Test
    public void checkCopyIsCorrect() {
        Cell dest = Cell.findBy(4,4);
        BishopBlack bishop = new BishopBlack(Cell.findBy(0,0));
        assertThat(bishop.copy(dest).position(), is(dest));
    }

    @Test
    public void checkIsDiagonalIsTrue() {
        BishopBlack bishop = new BishopBlack(Cell.findBy(0,0));
        Cell dest = Cell.findBy(4,4);
        boolean bishopDiagonal = bishop.isDiagonal(bishop.position(), dest);
        assertThat(bishopDiagonal, is(true));
    }

    @Test
    public void checkIsDiagonalIsFalse() {
        BishopBlack bishop = new BishopBlack(Cell.findBy(0,0));
        Cell dest = Cell.findBy(3,4);
        boolean bishopDiagonal = bishop.isDiagonal(bishop.position(), dest);
        assertThat(bishopDiagonal, is(false));
    }

    @Test
    public void checkWayIsCorrect() {
        BishopBlack bishop = new BishopBlack(Cell.findBy(2,3));
        Cell dest = Cell.findBy(4,1);
        Cell[] route = bishop.way(bishop.position(), dest);
        Cell[] expected = new Cell[] {Cell.findBy(3,2), Cell.findBy(4,1)};
        assertThat(route, is(expected));
    }

    @Test
    public void checkWayIsIncorrect() throws IllegalStateException {
        BishopBlack bishop = new BishopBlack(Cell.findBy(2,2));
        Cell dest = Cell.findBy(3,0);
        try {
            bishop.way(bishop.position(), dest);
            Assert.fail("Expected IllegalStateException");
        } catch (IllegalStateException thrown) {
            Assert.assertEquals("Could not way by diagonal from C3 to D1", thrown.getMessage());
        }
    }
}
