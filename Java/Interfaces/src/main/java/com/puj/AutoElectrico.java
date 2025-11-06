package com.puj;

class AutoElectrico implements Vehiculo, Electrico {
    @Override
    public void acelerar() {
        System.out.println("El auto eléctrico acelera silenciosamente ⚡");
    }

    @Override
    public void frenar() {
        System.out.println("El auto eléctrico frena regenerando energía ");
    }

    @Override
    public void cargarBateria() {
        System.out.println("El auto eléctrico está cargando la batería");
    }
}