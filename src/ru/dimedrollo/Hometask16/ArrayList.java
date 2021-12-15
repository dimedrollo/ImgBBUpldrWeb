package ru.dimedrollo.Hometask16;


public class ArrayList<E> extends java.util.ArrayList {

    public ArrayList removeAt(int index) {
        ArrayList a = new ArrayList();
        for (int indexCounter = 0; indexCounter < this.size(); indexCounter++) {
            if (indexCounter != index) {
                a.add(this.get(indexCounter));
            }
        }
        return a;
    }
}
