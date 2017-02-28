package com.scrabble;

public class Tray {
    int x, y;
    Square[x][y] tray = new Square[14][14];

    public Tray() {
        //[line], [column], (word, letter)
        //8 TWS, 24 DLS, 12 TLS, 16 DWS
        for (x=0;x<15;x++) {
            for (y=0;y<15;y++) {
                switch (x) {
                    case 0:
                        switch (y) {
                            case 0 || case 7 || case 14:
                                this.tray[x][y] = new Square(3, 1);
                            case 3 || case 11:
                                this.tray[x][y] = new Square(1, 2);
                            default:
                                this.tray[x][y] = new Square(1, 1);
                        }
                    case 1:
                        switch (y) {
                            case 1 || case 13:
                                this.tray[x][y] = new Square(2, 1);
                            case 5 || case 9:
                                this.tray[x][y] = new Square(1, 3);
                            default:
                                this.tray[x][y] = new Square(1, 1);
                        }
                    case 2:
                        switch (y) {
                            case 2 || case 12:
                                this.tray[x][y] = new Square(2, 1);
                            case 6 || case 8:
                                this.tray[x][y] = new Square(1, 2);
                            default:
                                this.tray[x][y] = new Square(1, 1);
                        }
                    case 3:
                        switch (y) {
                            case 3 || case 11:
                                this.tray[x][y] = new Square(2, 1);
                            case 0 || case 7 || case 14:
                                this.tray[x][y] = new Square(1, 2);
                            default:
                                this.tray[x][y] = new Square(1, 1);
                        }
                    case 4:
                        switch (y) {
                            case 4 || case 10:
                                this.tray[x][y] = new Square(2, 1);
                            default:
                                this.tray[x][y] = new Square(1, 1);
                        }
                    case 5:
                        switch (y) {
                            case 1 || case 5 || case 9 || case 13:
                                this.tray[x][y] = new Square(1, 3);
                            default:
                                this.tray[x][y] = new Square(1, 1);
                        }
                    case 6:
                        switch (y) {
                            case 2 || case 6 || case 8 || 12:
                                this.tray[x][y] = new Square(1, 2);
                            default:
                                this.tray[x][y] = new Square(1, 1);
                        }
                    case 7:
                        switch (y) {
                            case 0 || case 14:
                                this.tray[x][y] = new Square(3, 1);
                            case 3 || case 11:
                                this.tray[x][y] = new Square(1, 2);
                            default:
                                this.tray[x][y] = new Square(1, 1);
                        }
                    case 8:
                        switch (y) {
                            case 2 || case 6 || case 8 || case 12:
                                this.tray[x][y] = new Square(1, 2);
                            default:
                                this.tray[x][y] = new Square(1, 1);
                        }
                    case 9:
                        switch (y) {
                            case 1 || case 5 || case 9 || case 13:
                                this.tray[x][y] = new Square(1, 3);
                            default:
                                this.tray[x][y] = new Square(1, 1);
                        }
                    case 10:
                        switch (y) {
                            case 4 || case 10:
                                this.tray[x][y] = new Square(2, 1);
                            default:
                                this.tray[x][y] = new Square(1, 1);
                        }
                    case 11:
                        switch (y) {
                            case 3 || case 11:
                                this.tray[x][y] = new Square(2, 1);
                            case 0 || case 7 || case 14:
                                this.tray[x][y] = new Square(1, 2);
                            default:
                                this.tray[x][y] = new Square(1, 1);
                        }
                    case 12:
                        switch (y) {
                            case 2 || case 12:
                                this.tray[x][y] = new Square(2, 1);
                            case 6 || case 8:
                                this.tray[x][y] = new Square(1, 2);
                            default:
                                this.tray[x][y] = new Square(1, 1);
                        }
                    case 13:
                        switch (y) {
                            case 1 || case 13:
                                this.tray[x][y] = new Square(2, 1);
                            case 5 || case 9:
                                this.tray[x][y] = new Square(1, 2);
                            default:
                                this.tray[x][y] = new Square(1, 1);
                        }
                    case 14:
                        switch (y) {
                            case 0 || case 7 || case 14:
                                this.tray[x][y] = new Square(3, 1);
                            case 3 || case 11:
                                this.tray[x][y] = new Square(1, 2);
                            default:
                                this.tray[x][y] = new Square(1, 1);
                        }
                }
            }
        }
    }
}