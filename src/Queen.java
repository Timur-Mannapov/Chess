public class Queen extends ChessPiece {

    public Queen(String color) {
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

        boolean isDiagonal = Math.abs(line - toLine) == Math.abs(column - toColumn);
        boolean isStraight = (line == toLine) || (column == toColumn);


        if (isDiagonal || isStraight) {

            int moveDirectionLine = Integer.compare(toLine, line);
            int moveDirectionColumn = Integer.compare(toColumn, column);
            int currentLine = line + moveDirectionLine;
            int currentColumn = column + moveDirectionColumn;

            while (currentLine != toLine || currentColumn != toColumn) {
                if (chessBoard.board[currentLine][currentColumn] != null) {
                    return false;
                }
                currentLine += moveDirectionLine;
                currentColumn += moveDirectionColumn;
            }

            if (chessBoard.board[toLine][toColumn] != null && this.getColor().equals(chessBoard.board[toLine][toColumn].getColor())) {
                return false;
            }

            return true;
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}