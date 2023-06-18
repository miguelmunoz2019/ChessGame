package application;

public class Bishop extends Piece {

	public Bishop(String color, int posLine, int posColumn, int pRatio) {
		super(color, posLine, posColumn, pRatio);
		this.type="Bishop";
		setPieceImage();
		this.setFitHeight(pRatio);
		this.setFitWidth(pRatio);
		this.setPreserveRatio(true);
	}

	@Override
	public boolean checkMove() {
		// TODO Auto-generated method stub
		return false;
	}
}
