package application;

public class King extends Piece {

	public King(String color, int posLine, int posColumn, int pRatio) {
		super(color, posLine, posColumn, pRatio);
		this.type="King";
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
