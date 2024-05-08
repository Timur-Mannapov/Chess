public class Bishop extends ChessPiece {

    public Bishop(String color) {
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

        if (Math.abs(line - toLine) != Math.abs(column - toColumn)) {
            return false;
        }

        int moveDirectionLine = (toLine - line) > 0 ? 1 : -1;
        int moveDirectionColumn = (toColumn - column) > 0 ? 1 : -1;

        int currentLine = line + moveDirectionLine;
        int currentColumn = column + moveDirectionColumn;
        while (currentLine != toLine && currentColumn != toColumn) {
            if (chessBoard.board[currentLine][currentColumn] != null) {
                return false;
            }
            currentLine += moveDirectionLine;
            currentColumn += moveDirectionColumn;
        }

        if (chessBoard.board[toLine][toColumn] != null && !this.getColor().equals(chessBoard.board[toLine][toColumn].getColor())) {
            return true;
        }

        return chessBoard.board[toLine][toColumn] == null;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}