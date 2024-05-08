public class King extends ChessPiece {

    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7 || (line == toLine && column == toColumn)) {
            return false;
        }

        if (Math.abs(line - toLine) > 1 || Math.abs(column - toColumn) > 1) {
            return false;
        }

        if (chessBoard.board[toLine][toColumn] != null && this.getColor().equals(chessBoard.board[toLine][toColumn].getColor())) {
            return false;
        }

        return true;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        return false;
    }
}