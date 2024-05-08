public class Rook extends ChessPiece {

    public Rook(String color) {
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

        if (line != toLine && column != toColumn) {
            return false;
        }

        int stepLine = Integer.compare(toLine, line);
        int stepColumn = Integer.compare(toColumn, column);

        int currentLine = line + stepLine;
        int currentColumn = column + stepColumn;

        while ((stepLine != 0 && currentLine != toLine) || (stepColumn != 0 && currentColumn != toColumn)) {
            if (chessBoard.board[currentLine][currentColumn] != null) {
                if (currentLine != toLine || currentColumn != toColumn) {
                    return false;
                }
            }
            currentLine += stepLine;
            currentColumn += stepColumn;
        }

        if (chessBoard.board[toLine][toColumn] != null && this.getColor().equals(chessBoard.board[toLine][toColumn].getColor())) {
            return false;
        }

        return true;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}