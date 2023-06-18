package application;

public class Knight extends Piece{

	public Knight(String color, int posLine, int posColumn, int pRatio) {
		super(color, posLine, posColumn, pRatio);
		this.type="Knight";
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
