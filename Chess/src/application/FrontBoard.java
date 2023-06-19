package application;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import java.util.ArrayList;
import javafx.animation.RotateTransition;  
import javafx.util.Duration;  
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseButton;

public class FrontBoard  {

	private static final int filas= 8;
	private static final int columnas= 8;
	private static final Color whiteSquare = Color.rgb(238,238,210);
	private static final Color blackSquare = Color.rgb(118,150,86); 
	private static final Color selectedSquare = Color.web("#f7f683");
	private ArrayList<Square> squares = new ArrayList<>();
	private GridPane chessBoard = new GridPane();
	private String playerSide;
	private int ratio;
	private Square currentSquare= null;
	private Piece currentPiece = null;
	private Square pastSquare = null;
	private Piece pastPiece=null;

	enum Action {
		PIECETOPIECE,
		PIECETOSQUARE,
	}

	//Constructor
	public FrontBoard(GridPane Ppane, String playerSide, int ratio ) {
		chessBoard=Ppane;
		this.playerSide = playerSide;
		this.ratio = ratio;
		createBoard();
		setInitialPositions();
		if (playerSide.equals("White")) {
			rotateBoard();
		}
		setCommands();

	}

	//Creation of the board, setting the fields colors depending on the defined theme
	public void createBoard( )
	{
		for(int i=0 ;i < columnas; i++)
		{
			for(int j=0 ; j< filas; j++)
			{
				Square r = new Square(i, j, false, "White");
				r.setPrefHeight(ratio);
				r.setPrefWidth(ratio);
				if((i+j)%2==0)
				{
					r.setBackground(new Background(new BackgroundFill(whiteSquare, CornerRadii.EMPTY, Insets.EMPTY)));
				}
				else
				{
					r.setBackground(new Background(new BackgroundFill(blackSquare, CornerRadii.EMPTY, Insets.EMPTY)));
					r.setColor("Black");
				}
				chessBoard.add(r, j, i);
				squares.add(r);
			}

		}
	}

	//Adds an given piece to a given square
	private void addPiece(Square square, Piece piece){
		square.getChildren().add(piece);
		square.changeOccupation(true);
	}

	//Sets all pieces in the appropiate positions to strt a new game
	private void setInitialPositions()
	{
		for (Square casilla : squares) {
			switch (casilla.getLine()) {
			case 0:
				switch (casilla.getColumn()) {
				case 0:
					addPiece(casilla, new Rook("White", casilla.getLine(), casilla.getColumn(), ratio, this));

					break;
				case 1:
					addPiece(casilla, new Knight("White", casilla.getLine(), casilla.getColumn(), ratio,this));
					break;
				case 2:
					addPiece(casilla, new Bishop("White", casilla.getLine(), casilla.getColumn(), ratio,this));
					break;
				case 3:
					addPiece(casilla, new King("White", casilla.getLine(), casilla.getColumn(), ratio, this));
					break;
				case 4:
					addPiece(casilla, new Queen("White", casilla.getLine(), casilla.getColumn(), ratio, this));
					break;
				case 5:
					addPiece(casilla, new Bishop("White", casilla.getLine(), casilla.getColumn(), ratio,this));
					break;
				case 6:
					addPiece(casilla, new Knight("White", casilla.getLine(), casilla.getColumn(), ratio,this));
					break;
				case 7:
					addPiece(casilla, new Rook("White", casilla.getLine(), casilla.getColumn(), ratio,this));
					break;
				}
				break;
			case 1:
				addPiece(casilla, new Pawn("White", casilla.getLine(), casilla.getColumn(), ratio,this));
				break;
			case 6:
				addPiece(casilla, new Pawn("Black", casilla.getLine(), casilla.getColumn(), ratio,this));

				break;
			case 7:
				switch (casilla.getColumn()) {
				case 0:
					addPiece(casilla, new Rook("Black", casilla.getLine(), casilla.getColumn(), ratio,this));
					break;
				case 1:
					addPiece(casilla, new Knight("Black", casilla.getLine(), casilla.getColumn(), ratio,this));
					break;
				case 2:
					addPiece(casilla, new Bishop("Black", casilla.getLine(), casilla.getColumn(), ratio,this));
					break;
				case 3:
					addPiece(casilla, new King("Black", casilla.getLine(), casilla.getColumn(), ratio,this));
					break;
				case 4:
					addPiece(casilla, new Queen("Black", casilla.getLine(), casilla.getColumn(), ratio,this));
					break;
				case 5:
					addPiece(casilla, new Bishop("Black", casilla.getLine(), casilla.getColumn(), ratio,this));
					break;
				case 6:
					addPiece(casilla, new Knight("Black", casilla.getLine(), casilla.getColumn(), ratio,this));
					break;
				case 7:
					addPiece(casilla, new Rook("Black", casilla.getLine(), casilla.getColumn(), ratio,this));
					break;
				}
				break;

			}
		}
	}

	//Changes the background to indicate that the given square has been selected
	private void selectPiece(Square square)
	{
		square.setBackground(new Background(new BackgroundFill(selectedSquare, CornerRadii.EMPTY, Insets.EMPTY)));

	}

	private void movePiece(Square past, Square current)
	{
		System.out.println("move");
		Piece Ppiece = (Piece)past.getChildren().get(0);
		past.getChildren().clear();
		current.getChildren().clear();
		addPiece(current, Ppiece);
		if(Ppiece.getColor().equals("White"))
		{
			playerSide="Black";
		}
		else {
			playerSide="White";
		}
		rotateBoard();

	}

	//Rotates the board according and all the squares with the pieces on them
	public void rotateBoard() {
		RotateTransition rotate = new RotateTransition();  
		rotate.setAxis(Rotate.Z_AXIS);  
		rotate.setByAngle(180);  
		rotate.setDuration(Duration.millis(100));  
		rotate.setNode(chessBoard);  
		rotate.play();  
		for (Square casilla : squares) {
			RotateTransition rotatePiece = new RotateTransition();  
			rotatePiece.setAxis(Rotate.Z_AXIS);  
			rotatePiece.setByAngle(180);  
			rotatePiece.setDuration(Duration.millis(100));  
			rotatePiece.setNode(casilla);  
			rotatePiece.play();  
		}
	}

	public GridPane getChessBoard()
	{
		return chessBoard;
	}
	public String getPlayerSide() {
		return playerSide;
	}
	public int getRatio() {
		return ratio;
	}

	private void resetColor(Square currentSquare) {
		if(currentSquare.getColor().equals("White"))
		{
			currentSquare.setBackground(new Background(new BackgroundFill(whiteSquare, CornerRadii.EMPTY, Insets.EMPTY)));	
		}
		else
		{
			currentSquare.setBackground(new Background(new BackgroundFill(blackSquare, CornerRadii.EMPTY, Insets.EMPTY)));	

		}
	}
	public void setCommands() {

		chessBoard.setOnMouseClicked((new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent mouseEvent) {


				if(mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
					EventTarget target = mouseEvent.getTarget();
					boolean seleccionado= false;
					// Clicked on a square
					if(target.toString().startsWith("Square")){
						if(currentSquare != null)
						{
							resetColor(currentSquare);
							if(!currentSquare.getChildren().isEmpty()) {
								pastPiece= (Piece) currentSquare.getChildren().get(0);
								currentPiece=null;
							}
						}
						pastSquare=currentSquare;
						currentSquare = (Square) target;
						if (!currentSquare.getChildren().isEmpty()  ) {

							currentPiece = (Piece) currentSquare.getChildren().get(0);
							//Si el cuadro seleccionado contiene una pieza del oponente, se revisa el movimiento
							if(currentPiece.getColor().equals(playerSide) ) {
								selectPiece(currentSquare);

							}
							else if(revisarMovimiento())
							{
								movePiece(pastSquare, currentSquare);
								pastSquare=null;
								pastPiece=null;
								currentSquare=null;
								currentPiece=null;
							}
						}
						else {
							if(pastPiece!=null) {
								if(revisarMovimiento())
								{
									movePiece(pastSquare, currentSquare);
								}
							}
							currentPiece=null;
						}
					}
					//Clicked on a piece
					else if(target.toString().startsWith("Piece")){
						System.out.println(target.toString());
					}


				}




			}
		}));
	}
	//Revisa si se está realizando un movimiento y si este es valido
	private boolean revisarMovimiento() {

		//Hay una casilla iluminada que contiene una pieza y esta seleccionandose una nueva pieza
		if(pastPiece!=null && currentPiece != null)
		{
			return esMovimientoValido(Action.PIECETOPIECE);
		}
		else if(pastPiece!=null && currentPiece == null) {
			return esMovimientoValido(Action.PIECETOSQUARE);
		}
		return false;
	}

	//Revisa si la pieza puede realizar el movimiento en cuestion
	private boolean esMovimientoValido( Action pAction) {
		switch (pAction){
		case PIECETOPIECE:
			if(pastPiece.getColor()!= currentPiece.getColor()) {
				if(pastPiece.checkMove(Action.PIECETOPIECE, pastSquare, currentSquare)) {
					return true;
				}
			}
			break;
		case PIECETOSQUARE:
			if(pastPiece.checkMove(Action.PIECETOSQUARE, pastSquare, currentSquare)) {
				return true;
			}
			break;
		}


		return false;
	}
	public Square getSquare(String id)
	{
		for(Square square : squares) {
			if(square.getIdentifier().equals(id))
				return square;
		}
		return null;
	}


}


