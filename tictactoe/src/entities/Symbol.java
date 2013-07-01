package entities;

public class Symbol {

    private int x;
    private int y;
    private Character symbol;

    public Symbol() {
    }

    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    public Symbol(char symbol, int x, int y) {
        this.symbol = symbol;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Character getSymbol() {
        return symbol;
    }   
    
}
