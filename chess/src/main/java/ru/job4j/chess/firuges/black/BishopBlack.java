package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
           throw new IllegalStateException(
                    String.format("Could not way by diagonal from %s to %s", source, dest)
           );
        }
        int size = Math.abs(dest.x - source.x);
        Cell[] steps = new Cell[size];
        int deltaX = source.x < dest.x ? 1 : -1;
        int deltaY = source.y < dest.y ? 1 : -1;
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy((source.x + deltaX * (index + 1)), (source.y + deltaY * (index + 1)));
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean isDiagonal = false;
        if (Math.abs(dest.x - source.x) == Math.abs(dest.y - source.y)) {
            isDiagonal = true;
        }
        return isDiagonal;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
