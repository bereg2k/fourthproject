package operations;

abstract class Operation {
    private float n1;
    private float n2;

    Operation(float n1, float n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    float getN1() {
        return n1;
    }

    float getN2() {
        return n2;
    }
}
