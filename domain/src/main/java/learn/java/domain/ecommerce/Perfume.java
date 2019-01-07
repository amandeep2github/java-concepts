package learn.java.domain.ecommerce;

import learn.java.domain.ecommerce.types.PerfumeType;

public class Perfume extends Product {
    private PerfumeType perfumeType;

    public Perfume(PerfumeType perfumeType) {
        this.perfumeType = perfumeType;
    }

    public PerfumeType getPerfumeType() {
        return perfumeType;
    }
}
