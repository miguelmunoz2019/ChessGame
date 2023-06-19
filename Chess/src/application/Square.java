package application;

import javafx.scene.layout.StackPane;

public class Square extends StackPane {

	private int posLine;
	private int posColumn;
	private boolean occupied;
	private String id;
	private String color;

	public Square(int posLine, int posColumn, boolean occupiedState, String color) {
		this.posLine = posLine;
		this.posColumn = posColumn;
		this.occupied = occupiedState;
		this.color = color;
		setIdentifier();
	}
	public String getIdentifier()
	{
		return id;
	}
	public void setIdentifier()
	{
		id= positionsToId(posColumn, posLine);
	}

	public void changeOccupation(boolean state)
	{
		occupied=state;
	}
	public int getColumn()
	{
		return posColumn;
	}

	public int getLine()
	{
		return posLine;
	}
	@Override
	public String toString() {
		return "Square [posLine=" + posLine + ", posColumn=" + posColumn + "]";
	}
	public boolean isOccupied()
	{
		return occupied;
	}

	public String getColor() 
	{
		return color;
	}

	public void setColor(String string) {
		color=string;
	}
	private String positionsToId(int posColumn, int posLine) {
		String alphabet = "abcdefgh";
		String letra =alphabet.substring(7-posColumn, 8-posColumn);
		String numero=""+(posLine+1);
		return letra+numero;
	}






}
