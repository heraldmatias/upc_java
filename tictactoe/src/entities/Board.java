package entities;

public class Board extends AbstractBoard {

    @Override
    protected boolean is_graphic() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected void basedrawBoard(Symbol[][] slots) {
        // TODO Auto-generated method stub
        StringBuffer filaBuffer = new StringBuffer();
        StringBuilder map = new StringBuilder();
        for (int x = 0; x < MAX_COLS; x++) {
            filaBuffer.delete(0, filaBuffer.length());
            for (int y = 0; y < MAX_ROWS; y++) {
                Symbol symbol = slots[x][y];
                filaBuffer.append(String.format("| %s |", (symbol == null) ? ' ' : symbol.getSymbol()));
            }
            filaBuffer.append('\n');
            map.append(filaBuffer);
        }
        System.out.println(map.toString());
    }

}
