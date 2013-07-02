package entities;

import java.awt.Graphics;

public abstract class AbstractBoard {

    public final static int MAX_ROWS = 3;
    public final static int MAX_COLS = 3;
    public final static int NUMBER_MATCH_WIN = 3;
    protected abstract boolean is_graphic();
    private char[] usableSymbols;
    private Symbol[][] slots = new Symbol[MAX_ROWS][MAX_COLS];

    public Symbol[][] getSlots() {
        return slots;
    }
    
    protected abstract void basedrawBoard(Symbol[][] slots);
    
    public void drawBoard() {        
        this.basedrawBoard(this.getSlots());
    }

    public void restart(){
        this.slots = new Symbol[MAX_ROWS][MAX_COLS];
    }
    
    public boolean isValidMovement(int x, int y) {
        if (x < 1 || x > MAX_ROWS) {
            return false;
        }
        if (y < 1 || y > MAX_COLS) {
            return false;
        }
        if (this.slots[x - 1][y - 1] != null) {
            return false;
        }
        return true;
    }

    public boolean make_movement(Symbol symbol) {
        int x = symbol.getX(), y = symbol.getY();
        if (this.isValidMovement(x, y)) {
            this.slots[x - 1][y - 1] = symbol;
            return true;
        }
        return false;
    }

    private boolean matchVertical(char match_symbol) {
        /*
         * LOOP OVER ALL ROW FOR EACH COL
         */
        int count_match = 0;
        for (int y = 0; y < MAX_COLS; y++) {
            count_match = 0;
            for (int x = 0; x < MAX_ROWS; x++) {
                Symbol symbol = this.getSlots()[x][y];
                if (symbol == null) {
                    continue;
                }
                if (symbol.getSymbol() == match_symbol) {
                    count_match += 1;
                }
            }
            if (count_match == NUMBER_MATCH_WIN) {
                break;
            }
        }
        return count_match == NUMBER_MATCH_WIN;
    }

    private boolean matchHorizontal(char match_symbol) {
        /*
         * LOOP OVER ALL ROW FOR EACH COL
         */
        int count_match = 0;
        for (int x = 0; x < MAX_ROWS; x++) {
            count_match = 0;
            for (int y = 0; y < MAX_COLS; y++) {
                Symbol symbol = this.getSlots()[x][y];
                if (symbol == null) {
                    continue;
                }
                if (symbol.getSymbol() == match_symbol) {
                    count_match += 1;
                }
            }
            if (count_match == NUMBER_MATCH_WIN) {
                break;
            }
        }
        return count_match == NUMBER_MATCH_WIN;
    }

    private boolean matchDiagonal(char match_symbol) {
        /*
         * LOOP OVER ALL ROW FOR EACH COL
         */
        int count_match = 0;
        for (int x = 0; x < MAX_ROWS; x++) {
            int y = x;
            Symbol symbol = this.getSlots()[x][y];
            if (symbol == null) {
                break;
            }
            if (symbol.getSymbol() == match_symbol) {
                count_match += 1;
            }
        }
        if (count_match != NUMBER_MATCH_WIN) {
            count_match = 0;
            for (int y = MAX_COLS - 1; y >= 0; y--) {
                int x = (MAX_COLS - 1) - y;
                Symbol symbol = this.getSlots()[x][y];
                if (symbol == null) {
                    break;
                }
                if (symbol.getSymbol() == match_symbol) {
                    count_match += 1;
                }
            }
        }
        return count_match == NUMBER_MATCH_WIN;
    }

    protected boolean isWinner(char match_symbol) {
        return this.matchDiagonal(match_symbol) | this.matchHorizontal(match_symbol)
                | this.matchVertical(match_symbol);
    }

    public Character getWinner() {
        for (int i = 0; i < this.getUsableSymbols().length; i++) {
            if (this.isWinner(this.getUsableSymbols()[i])) {
                return this.getUsableSymbols()[i];
            }
        }
        return null;
    }

    public boolean isFinished() {
        return this.hasAwinner() | this.isCompleteBoard();
    }

    private boolean hasAwinner() {
        // TODO Auto-generated method stub
        return this.getWinner() != null;
    }

    public boolean isCompleteBoard() {
        // TODO Auto-generated method stub
        for (int x = 0; x < MAX_ROWS; x++) {
            for (int y = 0; y < MAX_COLS; y++) {
                if (this.getSlots()[x][y] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public char[] getUsableSymbols() {
        return usableSymbols;
    }

    public void setUsableSymbols(char[] usableSymbols) {
        this.usableSymbols = usableSymbols;
    }
}
