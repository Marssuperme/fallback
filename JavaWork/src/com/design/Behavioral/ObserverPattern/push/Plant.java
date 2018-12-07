package com.design.Behavioral.ObserverPattern.push;

public abstract class Plant {
    abstract void addInsect(Insect insect);
    abstract void removeInsect(Insect insect);
    abstract void notifyInsect(Boolean isOpen);
}
