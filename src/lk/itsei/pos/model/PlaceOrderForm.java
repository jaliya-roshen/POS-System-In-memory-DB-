package lk.itsei.pos.model;

import java.time.LocalDate;

public class PlaceOrderForm {


    private String orderId;
    private LocalDate orderDate;
    private String customerId;
    private String customerName;
    private String itemCode;
    private String ItemDescription;
    private int qtyOnHand;
    private double unitPrice;
    private int enterQty;
    private double total;

    public PlaceOrderForm() {
    }

    public PlaceOrderForm(String orderId, LocalDate orderDate, String customerId, String customerName, String itemCode, String itemDescription, int qtyOnHand, double unitPrice, int enterQty, double total) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.customerName = customerName;
        this.itemCode = itemCode;
        ItemDescription = itemDescription;
        this.qtyOnHand = qtyOnHand;
        this.unitPrice = unitPrice;
        this.enterQty = enterQty;
        this.total = total;
    }

    public PlaceOrderForm(String orderId, LocalDate orderDate, String customerId, String customerName, double total) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.customerName = customerName;
        this.total = total;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemDescription() {
        return ItemDescription;
    }

    public void setItemDescription(String itemDescription) {
        ItemDescription = itemDescription;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getEnterQty() {
        return enterQty;
    }

    public void setEnterQty(int enterQty) {
        this.enterQty = enterQty;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "PlaceOrderForm{" +
                "orderId='" + orderId + '\'' +
                ", orderDate=" + orderDate +
                ", customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", ItemDescription='" + ItemDescription + '\'' +
                ", qtyOnHand=" + qtyOnHand +
                ", unitPrice=" + unitPrice +
                ", enterQty=" + enterQty +
                ", total=" + total +
                '}';
    }
}
