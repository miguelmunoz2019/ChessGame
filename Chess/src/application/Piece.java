package application;
import application.FrontBoard.Action;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
public abstract class Piece extends ImageView {

	protected String color;
	protected String type;
	protected int posLine;
	protected int posColumn;
	protected int ratio;
	protected FrontBoard chessBoard;

	public Piece(String color, int posLine, int posColumn, int pRatio, FrontBoard pBoard){
		this.color = color;
		this.posLine = posLine;
		this.posColumn = posColumn;
		this.ratio=pRatio;
		this.chessBoard=pBoard;
	}

	public void setPieceImage(){
		this.setPiece(new Image("Application/PiecesImages/" + this .color + "" + this.type + ".png"));

	}
	public int getCurrentColumn() {
		return posColumn;
	}
	public int getCurrentLine() {
		return posLine;
	}


	public String getColor() {
		return this.color;
	}
	public void setPiece(Image image){
		this.setImage(image);
	}
	
	public abstract boolean checkMove(Action action, Square pastSquare, Square currentSquare);

	@Override
	public String toString() {
		return "Piece [color=" + color + ", type=" + type + "]";
	}
	

	
}