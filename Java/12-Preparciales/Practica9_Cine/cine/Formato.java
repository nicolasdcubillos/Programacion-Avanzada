package cine;

public enum Formato {
    DOS_D(0),
    TRES_D(6000);

    private int recargo;

    Formato(int recargo) {
        this.recargo = recargo;
    }

    public int getRecargo() {
        return recargo;
    }
}
