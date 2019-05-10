package errectivejava.chapter02.item02.hierarchicalbuilder;

import java.util.Objects;

/**
 * effective-java-errectivejava.chapter02.item02.hierarchicalbuilder
 */
public class NyPizza extends Pizza {

    public enum Size {SMALL, MEDIUM, LARGE}

    private final Size size;

    public static class Builder extends Pizza.Builder<Builder>{
        private Size size;

        public Builder(Size size){
            this.size = Objects.requireNonNull(size);
        }

        @Override
        public NyPizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }

    @Override
    public String toString() {
        return "New York Pizza with " + toppings;
    }


}
