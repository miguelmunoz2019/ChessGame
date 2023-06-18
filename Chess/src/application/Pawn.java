package application;

public class Pawn extends Piece {

	public boolean firstMove;
	public Pawn(String color, int posLine, int posColumn, int pRatio) {
		super(color, posLine, posColumn, pRatio);
		this.type="Pawn";
		setPieceImage();
		this.setFitHeight(pRatio);
		this.setFitWidth(pRatio);
		this.setPreserveRatio(true);
		this.firstMove = true;
	}
	@Override
	public boolean checkMove() {
		// TODO Auto-generated method stub
		return true;
	}
	

}
