package application;

public class Rook extends Piece{
	public Rook(String color, int posLine, int posColumn, int pRatio) {
		super(color, posLine, posColumn, pRatio);
		this.type="Rook";
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
