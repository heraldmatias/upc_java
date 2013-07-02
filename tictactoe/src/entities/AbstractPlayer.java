package entities;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        return this.getSymbol() == ((AbstractPlayer)obj).getSymbol();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.symbol);
        return hash;
    }
    
    
}
