package review;

import java.io.Serializable;

class Bird {
    protected transient String name;

    public Bird() {
        this.name = "Matt";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Eagle extends Bird implements Serializable {
    {
        this.name = "Olivia";
    }

    public Eagle() {
        this.name = "Bridget";
    }

    public static void main(String[] args) {
        var e = new Eagle();
        e.name = "Adeline";
    }
}