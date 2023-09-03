package ua.http.Currency;

public class CurrencyItem {
    private CCY ccy;
    private CCY base_ccy;
    private float buy;
    private float sale;

    public CCY getCcy() {
        return ccy;
    }

    public void setCcy(CCY ccy) {
        this.ccy = ccy;
    }

    public CCY getBase_ccy() {
        return base_ccy;
    }

    public void setBase_ccy(CCY base_ccy) {
        this.base_ccy = base_ccy;
    }

    public float getBuy() {
        return buy;
    }

    public void setBuy(float buy) {
        this.buy = buy;
    }

    public float getSale() {
        return sale;
    }

    public void setSale(float sale) {
        this.sale = sale;
    }

    public enum CCY {
        EUR,
        USD,
        UAH;
    }

    @Override
    public String toString() {
        return "CurrencyItem{" +
                "Валюта: " + ccy +
                ", Валюта обмена: " + base_ccy +
                ", Покупка: " + buy +
                ", Продажа: " + sale +
                '}';
    }
}
