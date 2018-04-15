package gof.builder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

abstract class Pizza {

    public enum Topping {HAM, MUSHROOM, ONIONS, PEPPER, SAUSAGE}

    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder, P extends Pizza> {

        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        protected abstract P build();

        protected abstract T self();

    }

    protected Pizza(Builder<?, ?> builder) {
        toppings = builder.toppings.clone();
    }


}
