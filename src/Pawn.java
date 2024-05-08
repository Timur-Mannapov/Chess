public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

        @Override
        public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
            if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) {
                return false;
            }

            if (toLine == line || (this.color.equals("White") && toLine < line) || (this.color.equals("Black") && toLine > line)) {
                return false;
            }

            if (chessBoard.board[toLine][toColumn] != null && !this.getColor().equals(chessBoard.board[toLine][toColumn].getColor())) {
                return Math.abs(column - toColumn) == 1 && Math.abs(toLine - line) == 1;
            }

            if (column == toColumn) {
                if (this.color.equals("White")) {
                    if (line == 1 && toLine == 3) {
                        return chessBoard.board[2][column] == null && chessBoard.board[3][column] == null;
                    } else {
                        return toLine - line == 1 && chessBoard.board[toLine][toColumn] == null;
                    }
                } else {
                    if (line == 6 && toLine == 4) {
                        return chessBoard.board[5][column] == null && chessBoard.board[4][column] == null;
                    } else {
                        return line - toLine == 1 && chessBoard.board[toLine][toColumn] == null;
                    }
                }
            }

            return false;
        }

        @Override
        public String getSymbol() {
            return "P";
        }
    }