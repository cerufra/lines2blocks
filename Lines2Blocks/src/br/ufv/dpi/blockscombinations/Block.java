package br.ufv.dpi.blockscombinations;

public class Block {
	private double height;
	private double length;
	private String name;
	
	public Block(double h, double l, String name)
	{
		this.setHeight(h);
		this.setLength(l);
		this.setName(name);
	}

	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getName() 
	{
		return this.name;
	}

	public double getHeight() 
	{
		return height;
	}

	public void setHeight(double height) 
	{
		this.height = height;
	}

	public double getLength() 
	{
		return length;
	}

	public void setLength(double length) 
	{
		this.length = length;
	}
	

}
