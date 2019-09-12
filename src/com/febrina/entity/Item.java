package com.febrina.entity;

/**
 * Class Item
 * @author Febrina 1772006
 */
public class Item {
    public String _name;
    public Double _price;
    public Category _category;

    /**
     * Class get_name
     * @author Febrina 1772006
     */
    public String get_name() {
        return _name;
    }

    /**
     * Class set_name
     * @author Febrina 1772006
     */
    public void set_name(String _name) {
        this._name = _name;
    }

    /**
     * Class get_price
     * @author Febrina 1772006
     */
    public Double get_price() {
        return _price;
    }

    /**
     * Class set_price
     * @author Febrina 1772006
     */
    public void set_price(Double _price) {
        this._price = _price;
    }

    /**
     * Class get_category
     * @author Febrina 1772006
     */
    public Category get_category() {
        return _category;
    }

    /**
     * Class set_category
     * @author Febrina 1772006
     */
    public void set_category(Category _category) {
        this._category = _category;
    }
}
