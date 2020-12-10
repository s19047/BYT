public class TicTacToe {
	public Board board;

	/**
	 * Bad Smell: Primitive Obsession, Duplicated code
	 * Extracted class Board,
	 *
	 * Instead of looping again to check if no empty places won the game, I added a flag (firstEmpty)
	 * <p>
	 * Instead of creating a new object of TicTacToe for each move, I simply updated this object (Deleted extra constructor)
	 *
	 * Used a technique known as magic square to simplify the winner checking process
	 **/

	public TicTacToe(String s) {
		board = new Board(s);
	}

	// fill the empty place with the player, then check if it wins, if so do it
	public int suggestMove(char player) {
		int firstEmpty = -1;
		for (int i = 0; i < 9; i++) {
			if (board.isEmptyAt(i)) {
				firstEmpty = ((firstEmpty == -1) ? i : firstEmpty);
				if (makeWinningMove(i, player))
					return i;
			}
		}
		//if no empty places win the game, just put it in the first empty one
		return firstEmpty;
	}

	public boolean makeWinningMove(int i, char player) {
		board.makeMove(i, player);
		if (board.hasWon(player))
			return true;
		board.makeMove(i, '-');
		return false;
	}

	// this is here only so that I don't have to change test class
	public char winner() {
		if (board.hasWon('X'))
			return 'X';
		if (board.hasWon('O'))
			return 'O';
		//no winner
		return '-';
	}

}
