package com.scrabble;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;

public class MyDropTargetListener extends DropTargetAdapter {

    private DropTarget dropTarget;
    private Square s;
    private Player playingNow;

    public MyDropTargetListener(Square square, Window window) {
        s = square;
        dropTarget = new DropTarget(square, DnDConstants.ACTION_MOVE, this, true, null);
        this.playingNow = window.getPlayingNow();
    }

    @Override
    public void drop(DropTargetDropEvent event) {
        try {
            Transferable tr = event.getTransferable();

            if (event.isDataFlavorSupported(new DataFlavor(Letter.class, "Letter"))) {
                Letter letter = (Letter) tr.getTransferData(new DataFlavor(Letter.class, "Letter"));

                if (letter != null) {
                    s.add(letter);
                    s.revalidate();
                    s.repaint();
                    playingNow.removeSpecificTile(playingNow.getIndex(letter));
                    playingNow.displayHand();
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