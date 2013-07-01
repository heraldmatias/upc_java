package entities;

public abstract class AbstractPlayer {

    private Symbol symbol;

    public AbstractPlayer(Symbol symbol) {
        this.symbol = symbol;
    }

    public abstract boolean is_boot();

    public Symbol do_movement(int x, int y) {
        this.symbol.setX(x);
        this.symbol.setY(y);
        return this.symbol;
    }

    public Symbol do_movement() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public char getSymbol() {
        return this.symbol.getSymbol();        
    }
}
