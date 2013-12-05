package edu.virginia.cs3102.engine;

class TileSlot
{
    private int xPosition;
    private int yPosition;
    private Tile containedTile;

    public TileSlot(int x, int y)
    {
        this.xPosition = x;
        this.yPosition = y;            
    }

    public TileSlot(int x, int y, Tile t)
    {
        this.xPosition = x;
        this.yPosition = y;
        this.containedTile = t;
    }

    public int getXPosition(){
        return this.xPosition;
    }
    
    public void setXPosition(int x){
        this.xPosition=x;
    }

    public int getYPosition(){
        return this.yPosition;
    }
    
    public void setYPosition(int y){
        this.yPosition = y;
    }

    public Tile getContainedTile(){
        return containedTile;
    }
    
    public void setContainedTile(Tile t){
        this.containedTile = t;
    }
    
}