public class Dino {

    public final double tomeg;
    public final double hossz;

    public Dino(double tomeg, double hossz) {
        this.tomeg = tomeg;
        this.hossz = hossz;
    }

    public boolean megeszi(Dino d){
        return (this.tomeg > d.tomeg && this.hossz > d.hossz);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Dino{");
        sb.append("tomeg=").append(tomeg);
        sb.append(", hossz=").append(hossz);
        sb.append('}');
        return sb.toString();
    }
}
