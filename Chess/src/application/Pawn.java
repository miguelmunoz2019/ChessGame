package application;

import application.FrontBoard.Action;

public class Pawn extends Piece {

	public boolean firstMove;
	public boolean enPassant;
	public Pawn(String color, int posLine, int posColumn, int pRatio, FrontBoard pBoard) {
		super(color, posLine, posColumn, pRatio,  pBoard);
		this.type="Pawn";
		setPieceImage();
		this.setFitHeight(pRatio);
		this.setFitWidth(pRatio);
		this.setPreserveRatio(true);
		this.firstMove = true;
		this.enPassant = false;
	}
	@Override
	public boolean checkMove(Action action, Square pastSquare, Square currentSquare) {
		switch (action){
		case PIECETOPIECE:
			switch (this.color) {
			case "White": 
				System.out.println(currentSquare.getLine());
				System.out.println(pastSquare.getLine());
				if(currentSquare.getLine()==pastSquare.getLine()+1 && (currentSquare.getColumn()==pastSquare.getColumn()+1 || currentSquare.getColumn()==pastSquare.getColumn()-1)) {
					
					if(!currentSquare.getChildren().isEmpty()) {
						if(firstMove) {
							firstMove=false;
						}
						return true;
					}
					else if(currentSquare.getLine()==5 && currentSquare.getColumn() == pastSquare.getColumn()-1) {
						Square temporal= new Square(4,  currentSquare.getColumn(), false, "White");
						temporal= this.chessBoard.getSquare(temporal.getIdentifier());
						if(!temporal.getChildren().isEmpty())
						{
							Piece PTemporal= (Piece) temporal.getChildren().get(0);
							if(PTemporal.type.equals("Pawn"))
							{
								Pawn peon= (Pawn) PTemporal;
								if(peon.enPassant) {
									temporal.getChildren().clear();
								}

							}
						}

					}

				}

				break;
			case "Black":
				break;
			}
			break;
		case PIECETOSQUARE:
			switch (this.color) {
			case "White": 
				if(firstMove) {
					if(currentSquare.getLine()== pastSquare.getLine()+2) {
						firstMove=false;
						enPassant=true;
						return true;
					}
				}
				else if(currentSquare.getLine()== pastSquare.getLine()+1) {
					firstMove=false;
					enPassant=false;
					return true;
				}
				break;
			case "Black":
				break;
			}
			break;

		}

		return false;

	}
}
