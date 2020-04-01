package ru.job4j;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.*;
import ru.job4j.chess.firuges.white.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LogicTest {
    @Test
    public void whenBishopCanMove() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C8));
        boolean rsl = logic.move(Cell.C8, Cell.E6);

        assertThat(rsl, is(true));
    }

    @Test
    public void whenBishopsMoveIsBlocked() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C8));
        logic.add(new PawnBlack(Cell.D7));
        boolean rsl = logic.move(Cell.C8, Cell.E6);

        assertThat(rsl, is(false));
    }

    @Test
    public void whenBishopMoveInLine() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C8));
        boolean rsl = logic.move(Cell.C8, Cell.C1);

        assertThat(rsl, is(false));
    }

    @Test
    public void whenFigureIsNotExist() {
        Logic logic = new Logic();
        boolean rsl = logic.move(Cell.C8, Cell.C1);

        assertThat(rsl, is(false));
    }

    @Test
    public void whenFigureIsStay() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C8));
        boolean rsl = logic.move(Cell.C8, Cell.C8);

        assertThat(rsl, is(false));
    }
}

