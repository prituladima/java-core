package gof.builder;

import java.util.Objects;

public final class ItalianPizza extends Pizza {

    public enum Size {SMALL, MEDIUM, LARGE}

    private final Size size;

    public static final class Builder extends Pizza.Builder<Builder, ItalianPizza> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        public ItalianPizza build() {
            return new ItalianPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private ItalianPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }


}
