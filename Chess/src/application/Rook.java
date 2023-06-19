package application;

import application.FrontBoard.Action;
import javafx.scene.layout.GridPane;

public class Rook extends Piece{
	public Rook(String color, int posLine, int posColumn, int pRatio,  FrontBoard frontBoard) {
		super(color, posLine, posColumn, pRatio, frontBoard);
		this.type="Rook";
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
