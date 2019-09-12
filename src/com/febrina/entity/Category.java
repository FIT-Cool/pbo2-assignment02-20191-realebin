package com.febrina.entity;


/**
 * Class Category
 * @author Febrina 1772006
 */
public class Category {
    public String _namaCat;

    public String get_namaCat() {
        return _namaCat;
    }

    public void set_namaCat(String _namaCat) {
        this._namaCat = _namaCat;
    }

    @Override
    public String toString() {
        return get_namaCat();
    }
}
