public class Horse extends ChessPiece {

    public Horse(String color) {
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

        boolean isCorrectMove = Math.abs(line - toLine) == 2 && Math.abs(column - toColumn) == 1 ||
                Math.abs(line - toLine) == 1 && Math.abs(column - toColumn) == 2;

        if (isCorrectMove) {
            if (chessBoard.board[toLine][toColumn] != null) {
                return !this.getColor().equals(chessBoard.board[toLine][toColumn].getColor());
            } else {
                return true;
            }
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}