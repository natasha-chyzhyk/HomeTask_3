package com.natasha.sourceit.task7.inheritage_composition;

public class Wolf extends Predator {

    public Wolf(float age, String area, int fang) {

        super("Wolf", age, area, fang);
    }

    @Override
    public Noise makeNoise() {

        return Noise.HOWL;
    }

    @Override
    public void sleep() {
        System.out.println(getName() + " sleep");
    }
}
