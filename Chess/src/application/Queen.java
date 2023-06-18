package application;

public class Queen extends Piece{

	public Queen(String color, int posLine, int posColumn, int pRatio) {
		super(color, posLine, posColumn, pRatio);
		this.type="Queen";
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
