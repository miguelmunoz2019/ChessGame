package application;

import application.FrontBoard.Action;
import javafx.scene.layout.GridPane;

public class King extends Piece {

	public King(String color, int posLine, int posColumn, int pRatio, FrontBoard pBoard) {
		super(color, posLine, posColumn, pRatio, pBoard);
		this.type="King";
		setPieceImage();
		this.setFitHeight(pRatio);
		this.setFitWidth(pRatio);
		this.setPreserveRatio(true);
	}

	@Override
	public boolean checkMove(Action action, Square pastSquare, Square currentSquare) {
		switch (action){
		case PIECETOPIECE:
			
			break;
		case PIECETOSQUARE:
			break;

		}

		return true;

	}
}
