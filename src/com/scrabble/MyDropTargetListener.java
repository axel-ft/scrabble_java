package com.scrabble;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;

public class MyDropTargetListener extends DropTargetAdapter {

    private DropTarget dropTarget;
    private Square square;
    private Player playingNow;
    private Tray tray;

    public MyDropTargetListener(Square square) {
        this.square = square;
        this.dropTarget = new DropTarget(square, DnDConstants.ACTION_MOVE, this, true, null);
    }
    
    public void updatePlayingNowAndTray(Player playingNow, Tray tray) {
    	this.playingNow = playingNow;
    	this.tray = tray;
    }
    
	@Override
    public void drop(DropTargetDropEvent event) {
        try {
            Transferable tr = event.getTransferable();

            if (event.isDataFlavorSupported(new DataFlavor(Letter.class, "Letter"))) {
                Letter letter = (Letter) tr.getTransferData(new DataFlavor(Letter.class, "Letter"));
                if (letter != null && !square.isSquareUsed()) {
                	if (this.tray.isWordInProgress()) {
                		if (this.square.getXSquare() != this.tray.getXorigin() && this.square.getYSquare() != this.tray.getYorigin()) {
                    			this.square.setPendingFalse();
                    			event.rejectDrop();
                        		return;
                		}
                	}
                    
                    if (this.tray.isWordInProgress()) {
                    	System.out.println(tray.isWordHorizontal());System.out.println(tray.isWordVertical());
                		if ((this.tray.isWordHorizontal() && this.square.getYSquare() > this.tray.getYLastPlaced()+1 || this.square.getYSquare() < this.tray.getYLastPlaced())) {
                    		this.square.setPendingFalse();
                    		event.rejectDrop();
                       		return;
                		}
                		if (this.tray.isWordVertical() && this.square.getXSquare() > this.tray.getXLastPlaced()+1 || this.square.getXSquare() < this.tray.getXLastPlaced()) {
                			this.square.setPendingFalse();
                			event.rejectDrop();
                    		return;
                		}
                	}

                    this.square.setPendingTrue();                    
                	this.square.add(letter);
                    this.square.setSquareContent(letter.getAlpha());
                    this.tray.setXLastPlaced(this.square.getXSquare());
                    this.tray.setYLastPlaced(this.square.getYSquare());
                    this.square.revalidate();
                    this.square.repaint();
                    this.playingNow.removeSpecificTile(letter);
                    event.dropComplete(true);
                }
            } else {
                event.rejectDrop();
            }
        } catch (Exception e) {
            e.printStackTrace();
            event.rejectDrop();
        }
    }
}