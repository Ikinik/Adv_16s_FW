package eu.pedu.adv16s._2_1615.sora00_sorfa.auxiliaryClases;

/**
 * Created by Adam on 19.5.2016.
 */
public class Pair<T> {

    private final T left;
    private final T right;

    public Pair(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getLeft() { return left; }
    public T getRight() { return right; }


    @Override
    public int hashCode() { return left.hashCode() ^ right.hashCode(); }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) return false;
        Pair pairo = (Pair) o;

        return (this.left.equals(pairo.getLeft()) &&
                this.right.equals(pairo.getRight())) ||
                (this.left.equals(pairo.getRight()) &&
                        this.right.equals(pairo.getLeft()));
    }
}